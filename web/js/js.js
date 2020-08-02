window.onload = function () {
    var input_username = document.getElementById("input_username");
    var input_password = document.getElementById("input_password");
    var error1 = document.getElementById("error1");
    var error2 = document.getElementById("error2");
    var btn = document.getElementById("btn");
    var form_sub = document.getElementById("form_sub");
    var flag = false;
    input_username.onblur = function () {
        if(input_username.value.trim().length==0){
            error1.innerText = "用户名不能为空";
            flag = false;
        }
        else {
            error1.innerText = "";
            flag = true;
        }
    }
    input_password.onblur = function () {
        if(input_password.value.trim().length==0){
            error2.innerText = "密码不能为空";
            flag = false;
        }
        else {
            error2.innerText = "";
            flag = true;
        }

    }
    btn.onclick = function () {
        if(flag){
            form_sub.submit();
        }
        else {
            alert("输入信息有误");
        }

    }

}