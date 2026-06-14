function login(){
    // get usrname + password
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

     // validate
    if (!username) {
        showNameErrorMessage("Please input username!");
        return;
    }

    if (!password) {
        showNameErrorMessage("Please input password!");
        return;
    }


    // validate username 6 -> 50 characters
    if (username.length < 6 || username.length > 50 || password.length < 6 || password.length > 800) {
        // show error message
        showNameErrorMessage("Login fail!");
        return;
    }


    // call API
    $.ajax({
        url: 'http://localhost:8080/api/v1/login/',
        type: 'GET',
        contentType: "application/json",
        dataType: 'json', // datatype return

        // dinh kem username + password de dang nhap
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(username + ":" + password));
        },
        success: function (data, textStatus,xhr) {
            console.log(data);

            // luu thong tin username + password der dinh kem vao method
            // luu o tren trang web => application => local storgae
            localStorage.setItem("ID", data.id);
            localStorage.setItem("USER_NAME", username);
            localStorage.setItem("ROLE", data.role);
            localStorage.setItem("FULL_NAME", data.fullName);
            localStorage.setItem("PASSWORD", password);
            // redirect to home page (chuyen sang home page)
            // https://www.w3schools.com/howto/howto_js_redirect_webpage.asp
            window.location.replace("http://127.0.0.1:5500/html/index.html");
        },
        // login fail
        error(jqXHR,textStatus,errorThrown){
        if(jqXHR.status == 401){
            showNameErrorMessage("Login fail!");
        } else{
            // login success
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
            }
        }
    });
}
function showNameErrorMessage(message) {
    document.getElementById("nameErrorMessage").style.display = "block";
    document.getElementById("nameErrorMessage").innerHTML = message;
}

function hideNameErrorMessage() {
    document.getElementById("nameErrorMessage").style.display = "none";
}