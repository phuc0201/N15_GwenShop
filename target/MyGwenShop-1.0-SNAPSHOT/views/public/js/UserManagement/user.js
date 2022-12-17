let column_data = [];
function getcontrol()
{
    getElement();
    checkBox_checked();
    getInforMember.forEach((item) => {
        item.addEventListener("dblclick", () =>{
            let layer = document.createElement("div");
            layer.className = "layer";
            document.querySelector("body").appendChild(layer);
            layer.addEventListener("click", ()=>{
                form_informMember.style.display = "none";
                layer.remove();
            })
            form_informMember.style.display = "flex"
            btn_insert.style.display = "none"
            btn_update.style.display = "block";
            btn_delete.style.display = "block";
            column_data = item.querySelectorAll("td");
            let column_name = [fullname, email, passwd, addr, phonenumber];
            for(let dt = 2; dt < column_data.length-1; dt++){
                column_name[dt-2].value = column_data[dt].innerText;
            }
        })
    })

    btn_add.onclick = ()=>{
        let layer = document.createElement("div");
        layer.className = "layer";
        document.querySelector("body").appendChild(layer);
        layer.addEventListener("click", ()=>{
            form_informMember.style.display = "none";
            layer.remove();
        })
        form_informMember.style.display = "flex"
        btn_insert.style.display = "block";
        btn_update.style.display = "none";
        btn_delete.style.display = "none";
        InforMember.forEach((input)=>input.value = "")
        Reset_validator();
    }
}

function getDataInput(){
    return {fullname: document.getElementById("fullname").value,
        email: document.getElementById("email").value,
        passwd: document.getElementById("password").value,
        addr: document.getElementById("address").value,
        phonenumber: document.getElementById("phonenumber").value,
    }
}
function EditData(){
    let data = {};
    data = getDataInput();
    data.create_at = column_data[column_data.length-1].innerHTML;
    return data;
}
function UpdateData(){
    $.ajax({
        url: `${window.location.href}/edit?id=${parseInt(column_data[1].innerHTML)}`,
        method: "POST",
        data: EditData(),
        success: function (data) {
            if(data == "error")
                showErrorToast("thay đổi");
            else{
                showSuccessToast("thay đổi");
                loadDataTable();
            }
        }
    });
}
function InsertData(){
    $.ajax({
        url: `${window.location.href}/create`,
        method: "POST",
        data: getDataInput(),
        success: function (data) {
            if(data == "success")
            {
                showSuccessToast("thêm");
                loadDataTable();
            }
            else showErrorToast("thêm")
        }
    });
}
function DeleteData(){
    $.ajax({
        url: `${window.location.href}/delete`,
        method: "POST",
        data: {
            id: parseInt(column_data[1].innerHTML),
        },
        success: function (data) {
            if(data=="error")
                showErrorToast("xóa");
            else{
                showSuccessToast("xóa");
                loadDataTable();
            }
        }
    });
}
