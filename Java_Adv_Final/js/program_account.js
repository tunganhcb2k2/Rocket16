$(function () {
    if (!isLogin()) {
        window.location.replace("http://127.0.0.1:5500/html/login.html");
    }

    $(".header").load("header.html", function () {
        document.getElementById("fullName").innerHTML = localStorage.getItem("FULL_NAME");
    });
    $(".main").load("home.html");
    $(".footer").load("footer.html");
});

function isLogin() {
    if (localStorage.getItem("ID")) {
        return true;
    }
    return false;
}

function logout() {
    localStorage.removeItem("ID");
    localStorage.removeItem("FULL_NAME");
    localStorage.removeItem("ROLE");
    localStorage.removeItem("USERNAME");
    localStorage.removeItem("PASSWORD");

    // redirect to login page
    window.location.replace("http://127.0.0.1:5500/html/login.html");

}

function clickNavHome() {
    $(".main").load("home.html");
}

function clickNavViewListAccounts() {
    if(localStorage.getItem("ROLE") == "ADMIN"){
        $(".main").load("viewAccounts.html", function() {
            buildTable();
        })
    } else {
        alert("You are not ADMIN");
    }
};

var accounts = [];
var currentPage = 1;
var size = 10;
var sortField = "createdDate";
var isAsc = false;

function GetListAccounts() {
     // call API
    var url = "http://localhost:8080/api/v1/accounts";

    url += "?pageNumber=" + currentPage + "&size=" + size;

    url += "&sort=" + sortField + "," + (isAsc ? "asc" : "desc");

    $.ajax({
        url: url,
        type: 'GET',
        contentType: "application/json",
        dataType: 'json', // datatype return

        // dinh kem username + password de dang nhap
        beforeSend: function (xhr) {                             //get username + password
            xhr.setRequestHeader("Authorization", "Basic " + btoa(localStorage.getItem("USER_NAME") + ":" + localStorage.getItem("PASSWORD")));
        },
        success: function (data, textStatus,xhr) {
            console.log(data);
            console.log(data);
            // reset list accounts
            accounts = [];
            // success
            accounts = data.content;
            fillAccountToTable();
            resetTable();
            pagingTable(data.totalPages);
        },
        error(jqXHR,textStatus,errorThrown){
            // login success
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
            }
        }
    );
}

function pagingTable(pageAmount) {

    var pagingStr = "";

    if (pageAmount > 1 && currentPage > 1) {
        pagingStr +=
            '<li class="page-item">' +
            '<a class="page-link" onClick="prevPaging()">Previous</a>' +
            '</li>';
    }

    for ( i = 0; i < pageAmount; i++) {
        pagingStr +=
            '<li class="page-item ' + (currentPage == i + 1 ? "active" : "") + '">' +
            '<a class="page-link" onClick="changePage(' + (i + 1) + ')">' + (i + 1) + '</a>' +
            '</li>';
    }

    if (pageAmount > 1 && currentPage < pageAmount) {
        pagingStr +=
            '<li class="page-item">' +
            '<a class="page-link" onClick="nextPaging()">Next</a>' +
            '</li>';
    }

    $('#pagination').empty();
    $('#pagination').append(pagingStr);

}

function resetPaging() {
    currentPage = 1;
    size = 10;
}

function prevPaging() {
    changePage(currentPage - 1);
}

function nextPaging() {
    changePage(currentPage + 1);
}

function changePage(page) {
    if (page == currentPage) {
        return;
    }
    currentPage = page;
    buildTable();
}

function changeSort(field){
    if (field == sortField) {
        isAsc = !isAsc;
    } else{
        sortField = field;
        isAsc = true;
    }
    buildTable();

}
function resetSort() {
    sortField = "createdDate";
    isAsc = true;
}

function resetDeleteCheckbox() {
    // reset delete all checkbox
    document.getElementById("checkbox-all").checked = false;

    // reset checkbox item
    var i = 0;
    while (true) {
        var checkboxItem = document.getElementById("checkbox-" + i);
        if (checkboxItem !== undefined && checkboxItem !== null) {
            checkboxItem.checked = false;
            i++;
        } else {
            break;
        }
    }
}

function resetTable() {
    resetPaging();
    resetSort();
    resetDeleteCheckbox();
}

function fillAccountToTable() {
    accounts.forEach(function(item,index) {
        $('tbody').append(
            '<tr>' +
            '<td><input id="checkbox-' + index + '" type="checkbox" onClick="onChangeCheckboxItem()"></td>' +
            '<td>' + item.username + '</td>' +
            '<td>' + item.fullName + '</td>' +
            '<td>' + item.role + '</td>' +
            '<td>' + item.createdDate + '</td>' +
            '<td>' + item.departmentName + '</td>' +
            '<td>' +
            '<a class="edit" class="edit" data-toggle="tooltip" onclick="openUpdateModal(' + item.id + ')"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>' +
			'<a class="delete" class="delete" data-toggle="tooltip" onClick="openConfirmDelete(' + item.id + ')"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>' +
            '</td>' +
            '</tr>')
    });
}

function buildTable() {
    $('tbody').empty();
    GetListAccounts();
}

function openAddModal() {
    openModal();
    resetFormAdd();
}

function resetFormAdd() {
    document.getElementById("titleModal").innerHTML = "Add Account";
    document.getElementById("id").value = "";
    document.getElementById("username").value = "";
    document.getElementById("password").value = "";
    document.getElementById("firstName").value = "";
    document.getElementById("lastName").value = "";
    document.getElementById("role").value = "";
    document.getElementById("email").value = "";
    document.getElementById("departmentId").value = "";
}

function openModal() {
    $('#addModal').modal('show');
}

function hideModal() {
    $('#addModal').modal('hide');
}

function addAccount() {
       // validate unique username
        // get data
    var username = document.getElementById("username").value;

    // validate name 6 -> 50 characters
    if (!username || username.length < 6 || username.length > 50) {
        // show error message
        showErrorMessage("Nhập lại Username");
        return;
    }
    $.ajax({
        url: "http://localhost:8080/api/v1/accounts/username/" + username + '/exists',
        type: 'GET',
        contentType: "application/json",
        dataType: 'json', // datatype return
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(localStorage.getItem("USER_NAME") + ":" + localStorage.getItem("PASSWORD")));
        },
        success: function (data, textStatus, xhr) {
            if (data) {
                // show error message
                // showNameErrorMessage("Username is exists!");
            } else {
                var password = document.getElementById("password").value;
                if(!password || password.length < 6 || password.length > 800){
                    showErrorMessage("Nhập lại password");
                    return;
                }
                var firstName = document.getElementById("firstName").value;
                if(!firstName){
                    showErrorMessage("Nhập lại FirstName");
                    return;
                }
                var lastName = document.getElementById("lastName").value;
                if(!lastName){
                    showErrorMessage("Nhập lại LastName");
                    return;
                }
                var role = document.getElementById("role").value;
                if(role == "ADMIN" || role == "EMPLOYEE" || role == "MANAGER"){
                } else{
                    showErrorMessage("Nhập lại role ( ADMIN or EMPLOYEE or MANAGER) !!!");
                    return;
                }
                var email = document.getElementById("email").value;
                if(!email || email.length < 10 || email.length > 50){
                    showErrorMessage("Nhập lại email");
                    return;
                }
                var departmentId = document.getElementById("departmentId").value;
                if(!departmentId){
                    showErrorMessage("Nhập lại department ID");
                    return;
                }
                
                var account = {
                    username: username,
                    password: password,
                    firstName: firstName,
                    lastName: lastName,
                    role: role,
                    email: email,
                    departmentId: departmentId
                };

                $.ajax({
                    url: 'http://localhost:8080/api/v1/accounts',
                    type: 'POST',
                    contentType: "application/json",
                    data: JSON.stringify(account),
                    beforeSend: function (xhr) {
                        xhr.setRequestHeader("Authorization", "Basic " + btoa(localStorage.getItem("USER_NAME") + ":" + localStorage.getItem("PASSWORD")));
                    },
                    success: function(data, textStatus, xhr) {
                        console.log(data);
                        hideModal();
                        showSuccessAlert();
                        resetTable();
                        buildTable();
                    },
                    error(jqXHR, textStatus, errorThrown) {
                        console.log(jqXHR);
                        console.log(textStatus);
                        console.log(errorThrown);
                    }
                });
            }
        },
            error(jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        });
}

function resetFormUpdate() {
    document.getElementById("titleModal").innerHTML = "Update Account";
    document.getElementById("id").style.display = "block";
    document.getElementById("username").style.display="block";
    document.getElementById("usernameLabel").style.display = "block";
    document.getElementById("password").value = "";
    document.getElementById("firstName").value = "";
    document.getElementById("lastName").value = "";
    document.getElementById("role").value = "";
    document.getElementById("email").value = "";
    document.getElementById("departmentId").value = "";
}

function openUpdateModal(id) {
    $.ajax({
        url: "http://localhost:8080/api/v1/accounts/" + id,
        type: 'GET',
        contentType: "application/json",
        dataType: 'json', // datatype return
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(localStorage.getItem("USER_NAME") + ":" + localStorage.getItem("PASSWORD")));
        },
        success: function (data, textStatus, xhr) {
            // success
            openModal();
            resetFormUpdate();
            // fill data
            document.getElementById("id").value = data.id;
            document.getElementById("username").value = data.username;
        },
        error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
        }
    });}

function save() {
    var id = document.getElementById("id").value;

    if (id == null || id == "") {
        addAccount();
    } else {
        updateAccount(id);
    }
}

function updateAccount(id) {
    var password = document.getElementById("password").value;
    if(!password || password.length < 6 || password.length > 800){
        showErrorMessage("Nhập lại password");
        return;
    }
    var firstName = document.getElementById("firstName").value;
    if(!firstName){
        showErrorMessage("Nhập lại FirstName");
        return;
    }
    var lastName = document.getElementById("lastName").value;
    if(!lastName){
        showErrorMessage("Nhập lại LastName");
        return;
    }
    var role = document.getElementById("role").value;
    if(role == "ADMIN" || role == "EMPLOYEE" || role == "MANAGER"){
    } else{
        showErrorMessage("Nhập lại role ( ADMIN or EMPLOYEE or MANAGER) !!!");
        return;
    }
    var email = document.getElementById("email").value;
    if(!email || email.length < 10 || email.length > 50){
        showErrorMessage("Nhập lại email");
        return;
    }
    var departmentId = document.getElementById("departmentId").value;
    if(!departmentId){
        showErrorMessage("Nhập lại department ID");
        return;
    }
    var account = {
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role,
            email: email,
            departmentId: departmentId
            };
            $.ajax({
            url: 'http://localhost:8080/api/v1/accounts/' + id,
            type: 'PUT',
            data: JSON.stringify(account), // body
            contentType: "application/json", // type of body (json, xml, text)
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Authorization", "Basic " + btoa(localStorage.getItem("USER_NAME") + ":" + localStorage.getItem("PASSWORD")));
            },
                    // dataType: 'json', // datatype return
                success: function (data, textStatus, xhr) {
            console.log(data);
           // success
            hideModal();
            showSuccessAlert();
            resetTable();
            buildTable();
        }
    });
}


function openConfirmDelete(id) {
    // get index from employee's id
    var index = accounts.findIndex(x => x.id == id);
    var username = accounts[index].username;

    var result = confirm("Want to delete " + username + "?");
    if (result) {
        deleteAccount(id);
    }
}

function deleteAccount(id) {
    // TODO validate


    $.ajax({
        url: 'http://localhost:8080/api/v1/accounts/' + id,
        type: 'DELETE',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(localStorage.getItem("USER_NAME") + ":" + localStorage.getItem("PASSWORD")));
        },
            // dataType: 'json', // datatype return
        success: function (data, textStatus, xhr) {
            console.log(data);
           // success
            hideModal();
            showSuccessAlert();
            resetTable();
            buildTable();
        }
    });
}

function onChangeCheckboxItem() {
    var i = 0;
    while (true) {
        var checkboxItem = document.getElementById("checkbox-" + i);
        if (checkboxItem !== undefined && checkboxItem !== null) {
            if (!checkboxItem.checked) {
                document.getElementById("checkbox-all").checked = false;
                return;
            }
            i++;
        } else {
            break;
        }
    }
    document.getElementById("checkbox-all").checked = true;

}

function onChangeCheckboxAll() {
    var i = 0;
    while (true) {
        var checkboxItem = document.getElementById("checkbox-" + i);
        if (checkboxItem !== undefined && checkboxItem !== null) {
            checkboxItem.checked = document.getElementById("checkbox-all").checked
            i++;
        } else {
            break;
        }
    }
}

function deleteAllModal() {
    // get checked
    var ids = [];
    var usernames = [];
    var i = 0;
    while (true) {
        var checkboxItem = document.getElementById("checkbox-" + i);
        if (checkboxItem !== undefined && checkboxItem !== null) {
            if (checkboxItem.checked) {
                ids.push(accounts[i].id);
                usernames.push(accounts[i].username);
            }
            i++;
        } else {
            break;
        }
    }

    // open confirm ==> bạn có muốn xóa bản ghi ...


    var result = confirm("Want to delete " + usernames + "?");
    if (result) {
        // call API
        $.ajax({
            url: 'http://localhost:8080/api/v1/accounts?ids=' + ids,
            type: 'DELETE',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Authorization", "Basic " + btoa(localStorage.getItem("USER_NAME") + ":" + localStorage.getItem("PASSWORD")));
            },
            success: function (result) {
                // error
                if (result == undefined || result == null) {
                    alert("Error when loading data");
                    return;
                }

                // success
                showSuccessAlert();
                resetPaging();
                resetTable();
                buildTable();
            }
        });
    }

}



function showSuccessAlert() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function() {
        $("#success-alert").slideUp(500);
    });
}

function showErrorMessage(message) {
    document.getElementById("ErrorMessage").style.display = "block";
    document.getElementById("ErrorMessage").innerHTML = message;
}

function hideErrorMessage() {
    document.getElementById("ErrorMessage").style.display = "none";
}