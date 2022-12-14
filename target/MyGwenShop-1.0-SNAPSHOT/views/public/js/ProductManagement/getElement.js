function getElement(){
    icon_wastebasket = document.querySelector(".content__header--buttonDel")
    btn_add = document.querySelector(".content__header--buttonAdd");
    checkbox_wastebasket = document.querySelectorAll(".table_wrapper input")
    btn_Delete = document.querySelectorAll(".table_product .btn_Delete")
    btn_Edit = document.querySelectorAll(".table_product .btn_Edit")
    list_image_wrap = document.querySelector("#form-inforProduct__image .list-image")
    list_image = document.querySelectorAll("#form-inforProduct__image .list-image .image-item_wrapper")
    image_item = document.querySelectorAll("#form-inforProduct__image .list-image .image-item")
    showImage = document.querySelector("#form-inforProduct__image .main-image")
    form_infoProduct = document.getElementById("form-inforProduct")
    addColor = document.querySelector("#form-inforProduct__infor #product_color .icon-plus")
    icon_minus = document.querySelectorAll(".icon-minus")
    addSize = document.querySelector("#form-inforProduct__infor #product_size .icon-plus")
    description = document.getElementById("form-inforProduct__description");
    listColor = document.querySelector("#form-inforProduct__infor #product_color .list-color")
    listSize = document.querySelector("#form-inforProduct__infor #product_size .list-size")
    addNewImage = document.querySelector("#form-inforProduct__image .list-image .addImage")
    btn_insert = document.querySelector("#form-inforProduct__infor .button-insert");
    btn_update = document.querySelector("#form-inforProduct__infor .button-update");
}
getElement()
