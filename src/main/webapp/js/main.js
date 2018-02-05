function relocate(loc) {
    location=loc;
}

function now(field) {
    field.setAttribute("min",(new Date()).toISOString())
}

function validatePasswordRepeat() {
    var password = document.getElementById("password").value;
    var password1 = document.getElementById("passwordRepeat").value;
    if(password===password1){
        document.getElementById("password").style.borderColor="";
        document.getElementById("passwordRepeat").style.borderColor="";
        return true;
    }else{
        document.getElementById("password").style.borderColor="red";
        document.getElementById("passwordRepeat").style.borderColor="red";
        return false;
    }
}