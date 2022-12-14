function getElement(){
    layer = document.querySelector(".layer");
    checkbox_wastebasket = document.querySelectorAll(".table_wrapper input")
    icon_wastebasket = document.querySelector(".content__header--buttonDel")
    closeFormMember = document.querySelector("#inforMember .icon_close")
    btn_add = document.querySelector(".content__header--buttonAdd");
    getInforMember = document.querySelectorAll(".table_wrapper table tbody tr");
    InforMember = document.querySelectorAll("#form-infoMember input")
    search = document.querySelector(".search--input")
    btn_insert = document.querySelector("#inforMember .form-info--button .btn_Insert")
    btn_update = document.querySelector("#inforMember .form-info--button .btn_Update")
    btn_delete = document.querySelector("#inforMember .form-info--button .btn_Delete")
    form_informMember = document.getElementById("inforMember");
    fullname = document.getElementById("fullname");
    email = document.getElementById("email");
    passwd = document.getElementById("password");
    addr = document.getElementById("address");
    phonenumber = document.getElementById("phonenumber");

}
getElement();