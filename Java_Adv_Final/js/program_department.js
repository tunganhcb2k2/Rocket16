function clicknavViewListDepartment() {
    if(localStorage.getItem("ROLE") == "ADMIN"){
        $(".main").load("viewDepartments.html", function() {
            buildTable1();
        })
    } else {
        alert("You are not ADMIN");
    }
}

var departments = [];
var counter1 = 0;
var currentPage1 = 1;
// var size = 10;

function getListDepartments() {
    var url = "http://localhost:8080/api/v1/departments";

    url += "?pageNumber=" + currentPage1;
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
            // reset list accounts
            departments = [];
            // success
            departments = data.content;
            fillDepartmentToTable();
            pagingTable1(data.totalPages);
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

function pagingTable1(pageAmount1) {
    var pagingStr1 = "";

    if (pageAmount1 > 1 && currentPage1 > 1) {
        pagingStr1 +=
            '<li class="page-item">' +
            '<a class="page-link" onclick="prevPaging1()">Previous</a>' +
            '</li>';
    }
    for (i = 0; i < pageAmount1; i++) {
        pagingStr1 +=
            '<li class="page-item ' + (currentPage1 == i + 1 ? "active" : "") + '">' +
            '<a class="page-link" onclick="changePage1(' + (i + 1) + ')">' + (i + 1) + '</a>' +
            '</li>';
    }

    if (pageAmount1 > 1 && currentPage1 < pageAmount1) {
        pagingStr1 +=
            '<li class="page-item">' +
            '<a class="page-link" onclick="nextPaging1()">Next</a>' +
            '</li>';
    }


    $('#pagination1').empty();
    $('#pagination1').append(pagingStr1);

}

// them vao cac ham delete all(viet trc buildTable) 
function resetPaging1() {
    currentPage1 = 1;
}

function prevPaging1() {
    changePage1(currentPage1 - 1);
}

function nextPaging1() {
    changePage1(currentPage1 + 1);
}

function changePage1(page1) {
    if (page1 == currentPage1) {
        return;
    }
    currentPage1 = page1;
    buildTable1();
}


function buildTable1() {
    $('tbody').empty();
    getListDepartments();
}

function fillDepartmentToTable() {
    departments.forEach(function (item, index) {
        $('tbody').append(
            '<tr>' +
            '<td> <input id = "checkbox -' + index + '" type ="checkbox"> </td>' +
            '<td>' + item.name + '</td>' +
            '<td>' + item.totalMember + '</td>' +
            '<td>' + item.type + '</td>' +
            '<td>' + item.createdDate + '</td>' +
            '<td>' +
            '<a class="edit" title="Edit" data-toggle="tooltip" onclick="openUpdateModal1(' + item.id + ')"><i class="material-icons">&#xE254;</i></a>' +
            '<a class="delete" title="Delete" data-toggle="tooltip" onclick = "openConfirmDelete1(' + item.id + ')"><i class="material-icons">&#xE872;</i></a>' +
            '</td>' +
            '</tr>')
    });

}

function openAddModal1() {
    openModal1();
    resetformAdd1();


}


function resetformUpdate1() {
    document.getElementById("titleModal").innerHTML = "Edit Department";
    document.getElementById("id").style.display = "block";
    document.getElementById("name").value = "";
    document.getElementById("totalMember").value = "";
    document.getElementById("type").value = "";
    // hideNameErrorMessage();
    // hidetotalMemberErrorMessage();
    // hidetypeErrorMessage();
}

function resetformAdd1() {
    document.getElementById("titleModal").innerHTML = "Add Department";
    // document.getElementById("id").value = "";
    document.getElementById("name").value = "";
    document.getElementById("totalMember").value = "";
    document.getElementById("type").value = "";
    // hideNameErrorMessage();
    // hidetotalMemberErrorMessage();
    // hidetypeErrorMessage();

}

function openModal1() {
    $('#myModal').modal('show');
}

function hideModal1() {
    $('#myModal').modal('hide');
}

// function showNameErrorMessage(message) {
//     document.getElementById("nameErrorMessage").style.display = "block";
//     document.getElementById("nameErrorMessage").innerHTML = message;
// }

// function hideNameErrorMessage() {
//     document.getElementById("nameErrorMessage").style.display = "none";
// }

// function showtotalMemberErrorMessage(message) {
//     document.getElementById("totalMemberErrorMessage").style.display = "block";
//     document.getElementById("totalMemberErrorMessage").innerHTML = message;
// }

// function hidetotalMemberErrorMessage() {
//     document.getElementById("totalMemberErrorMessage").style.display = "none";
// }

// function showtypeErrorMessage(message) {
//     document.getElementById("typeErrorMessage").style.display = "block";
//     document.getElementById("typeErrorMessage").innerHTML = message;
// }

// function hidetypeErrorMessage() {
//     document.getElementById("typeErrorMessage").style.display = "none";
// }

function addDepartment() {
    var name = document.getElementById("name").value;
    var totalMember = document.getElementById("totalMember").value;
    var type = document.getElementById("type").value;

    // validate check unique
    $.ajax({
        url: "http://localhost:8080/api/v1/departments/name/" + name,
        type: 'GET',
        contentType: "application/json",
        dataType: 'json', // datatype return
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(localStorage.getItem("USER_NAME") + ":" + localStorage.getItem("PASSWORD")));
        },
        success: function (data, textStatus, xhr) {
        if (data == true) {
            showNameErrorMessage("Department name is exists!!");
        } else {
                    var department = {
                        name: name,
                        totalMember: totalMember,
                        type: type
                    };
                    $.ajax({
                        url: 'http://localhost:8080/api/v1/departments',
                        type: 'POST',
                        data: JSON.stringify(department), // body
                        contentType: "application/json", // type of body (json,xml,text)
                        beforeSend: function (xhr) {
                            xhr.setRequestHeader("Authorization", "Basic " + btoa(localStorage.getItem("USER_NAME") + ":" + localStorage.getItem("PASSWORD")));
                        },
                        success: function (data, textStatus, xhr) {
                            hideModal1();
                            showSuccessAlert1();
                            buildTable1();
                        },
                        error(jqXHR, textStatus, errorThrown) {
                            alert("Error when loading data");
                            console.log(jqXHR);
                            console.log(textStatus);
                            console.log(errorThrown);
                        }
                    })
        

        }

    },error(jqXHR, textStatus, errorThrown) {
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    }
});
}

var oldName;


function openUpdateModal1(id) {
        $.ajax({
            url: "http://localhost:8080/api/v1/departments/" + id,
            type: 'GET',
            contentType: "application/json",
            dataType: 'json', // datatype return
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Authorization", "Basic " + btoa(localStorage.getItem("USER_NAME") + ":" + localStorage.getItem("PASSWORD")));
            },
            success: function (data, textStatus, xhr) {
                // success
                openModal1();
                resetformUpdate1();

                oldName = data.name;
                // fill data
                document.getElementById("id").value = data.id;

            },
            error(jqXHR, textStatus, errorThrown) {
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
            }
        });}



function save1() {
    var id = document.getElementById("id").value;
    if (id == null || id == "") {
        addDepartment();
    } else {
        updateDepartment(id);
    }
}

function updateDepartment(id) {
    var name = document.getElementById("name").value;
    var totalMember = document.getElementById("totalMember").value;
    var type = document.getElementById("type").value;
    var createdDate = document.getElementById("createdDate").value;


    // validate

    // call api
    var department = {
        name: name,
        totalMember: totalMember,
        type: type
    };

    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'PUT',
        data: JSON.stringify(department),
        contentType: "application/json",
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(localStorage.getItem("USER_NAME") + ":" + localStorage.getItem("PASSWORD")));
        },
        success: function (result) {
            // success
            hideModal1();
            showSuccessAlert1();
            buildTable1();
        }

    });


}

function openConfirmDelete1(id) {
        // get index from department's id
        var index = departments.findIndex(x => x.id == id);
        var name = departments[index].name;
    
        var result = confirm("Want to delete " + name + "?");
        if (result) {
            deleteDepartment1(id);
        }

    }

function deleteDepartment1(id) {
    // TODO validate
    $.ajax({
        url: 'http://localhost:8080/api/v1/departments/' + id,
        type: 'DELETE',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(localStorage.getItem("USER_NAME") + ":" + localStorage.getItem("PASSWORD")));
        },
            // dataType: 'json', // datatype return
        success: function (data, textStatus, xhr) {
            console.log(data);
            showSuccessAlert1();
            resetPaging1();
            buildTable1();
        }

    });
}

// function deleteAllDepartment1() {
//     var ids = [];
//     var names = [];
//     var i = 0;
//     while (true) {
//         var checkboxItem = document.getElementById("checkbox-" + i);
//         if (checkboxItem !== undefined && checkboxItem !== null) {
//             if (checkboxItem.checked) {
//                 ids.push(departments[i].id);
//                 names.push(departments[i].name);
//             }
//             i++;
//         } else {
//             break;
//         }
//     }
//     // confirm

//     var result = confirm("want to delete " + names + "?");
//     if (result) {
//         // call API
//         $.ajax({
//             url: 'http://localhost:8080/api/v1/departments?ids=' + ids,
//             type: 'DELETE',
//             success: function (result) {
//                 // error
//                 if (result == undefined || result == null) {
//                     alert("Error when loading data");
//                     return;
//                 }
//                 // success
//                 showSuccessAlert1();
//                 resetPaging1();
//                 buildTable1();
//             }

//         });
//     }
// }

// function onChangeCheckboxAll1() {
//     var i = 0;
//     while (true) {
//         var checkboxItem = document.getElementById("checkbox-" + i);
//         if (checkboxItem !== undefined && checkboxItem !== null) {
//             checkboxItem.checked = document.getElementById("checkbox-all").checked
//             i++;
//         } else {
//             break;
//         }
//     }
// }

// function onChangeCheckboxItem1() {
//     var i = 0;
//     while (true) {
//         var checkboxItem = document.getElementById("checkbox-" + i);
//         if (checkboxItem !== undefined && checkboxItem !== null) {
//             if (!checkboxItem.checked) {
//                 document.getElementById("checkbox-all").checked = false;
//                 return;
//             }
//             i++;
//         } else {
//             break;
//         }
//     }
//     document.getElementById("checkbox-all").checked = true;

// }

function showSuccessAlert1() {
    $("#success-alert").fadeTo(2000, 500).slideUp(500, function () {
        $("#success-alert").slideUp(500);
    });
}