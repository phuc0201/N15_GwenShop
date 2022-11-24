let tableThead = document.querySelector(".table_wrapper thead")
let tableBody = document.querySelector(".table_wrapper tbody")
tableThead.innerHTML = `
<tr>
    <th></th>
    <th>ID</th>
    <th>Full Name</th>
    <th>Email</th>
    <th>PassWord</th>
    <th>Address</th>
    <th>PhoneNumber</th>
    <th>Salary</th>
    <th>Role</th>
    <th>Created_at</th>
    <th>Deleted_at</th>                     
</tr>
`
for(let i = 0; i<100; i++)
{
    tableBody.innerHTML += `<tr>
                            <td><input type="checkbox"></td>
                            <td>${i+1}</td>
                            <td>Trịnh Hoàng Phúc ${i+1}</td>
                            <td>hoangphuc${i+1}@gmail.com</td>
                            <td>phuc0201</td>
                            <td>An Giang</td>
                            <td>0328614013</td>
                            <td>50000000</td>
                            <td name = "position">Quản lý</td>
                            <td>2022-11-07</td>
                            <td>null</td>
                        </tr>`
}

let layer = document.getElementById("layer");
let checkbox_wastebasket = document.querySelectorAll(".table_wrapper input")
let icon_wastebasket = document.querySelector(".content__header--buttonDel")
let closeFormMember = document.querySelector("#inforMember .icon_close")
let btn_add = document.querySelector(".content__header--buttonAdd");
let getInforMember = document.querySelectorAll(".table_wrapper table tbody tr");
let InforMember = document.querySelectorAll(".form-info table input")
let search = document.querySelector(".search--input")
let btn_insert = document.querySelector("#inforMember .form-info--button .btn_Insert")
let btn_update = document.querySelector("#inforMember .form-info--button .btn_Update")
let btn_delete = document.querySelector("#inforMember .form-info--button .btn_Delete")
let form_informMember = document.getElementById("inforMember");

checkbox_wastebasket.forEach((item)=>{
    item.addEventListener("click", ()=>{ 
        let checked = false;
        checkbox_wastebasket.forEach((item)=>{
            if(item.checked == true){
                checked = true
                icon_wastebasket.style.display = "block";
            }
        })
        if(checked == false){
            icon_wastebasket.style.display = "none";
        }
    })
})

closeFormMember.addEventListener("click", ()=>{
    layer.style.display = "none"
})


getInforMember.forEach((item)=>{
    item.addEventListener("dblclick", ()=>{
        layer.style.display = "block";
        form_informMember.style.display = "block"
        btn_insert.style.display = "none"
        btn_update.style.display = "block";
        btn_delete.style.display = "block";
        getDataTable = item.querySelectorAll("td")
        for (let value = 0; value < InforMember.length; value++)
        {   
            InforMember[value].value = getDataTable[value + 2].innerHTML;          
        }
        form_informMember.querySelector("#role").value = item.querySelector("td[name=position]").innerHTML
    })
})

btn_add.addEventListener("click", ()=>{
    layer.style.display = "block";
    form_informMember.style.display = "block";      
    btn_insert.style.display = "block";
    btn_update.style.display = "none";
    btn_delete.style.display = "none";
    for (let value = 0; value < InforMember.length; value++)  
    {
        InforMember[value].value = ""; 
    }  
})

btn_insert.addEventListener("click", ()=>{
    showSuccessToast("thêm");
})
btn_update.addEventListener("click", ()=>{
    showSuccessToast("cập nhật");
})
btn_delete.addEventListener("click", ()=>{
    showSuccessToast("xóa");
})
icon_wastebasket.addEventListener("click", ()=>{
    showSuccessToast("xóa");
})

function showSuccessToast(action) {
    let messageConfirm = `Bạn có chắc chắn muốn ${action} không`;
    let message = `Bạn đã ${action} thành công`;
    if(confirm(messageConfirm) == true)
    {
        toast({
            title: "Thành công",
            message: message,
            type: "success",
            duration: 2000
          });
        layer.style.display = "none";
    }
}
function showErrorToast(action) {
    let message = `Bạn đã ${action} thất bại`;
    toast({
        title: "Thất bại",
        message: message,
        type: "error",
        duration: 2000
      });
    layer.style.display = "none";
}

// Toast function
function toast({ title = "", message = "", type = "info", duration = 3000 }) {
    const main = document.getElementById("toast");
    if (main) {
      const toast = document.createElement("div");

      const autoRemoveId = setTimeout(function () {
        main.removeChild(toast);
      }, duration + 1000);

      toast.onclick = function (e) {
        if (e.target.closest(".toast__close")) {
          main.removeChild(toast);
          clearTimeout(autoRemoveId);
        }
      };
  
      const icons = {
        success: "fas fa-check-circle",
        info: "fas fa-info-circle",
        warning: "fas fa-exclamation-circle",
        error: "fas fa-exclamation-circle"
      };
      const icon = icons[type];
      const delay = (duration / 1000).toFixed(2);
  
      toast.classList.add("toast", `toast--${type}`);
      toast.style.animation = `slideInLeft ease .3s, fadeOut linear 1s ${delay}s forwards`;
  
      toast.innerHTML = `
                      <div class="toast__icon">
                          <i class="${icon}"></i>
                      </div>
                      <div class="toast__body">
                          <h3 class="toast__title">${title}</h3>
                          <p class="toast__msg">${message}</p>
                      </div>
                      <div class="toast__close">
                          <i class="fas fa-times"></i>
                      </div>
                  `;
      main.appendChild(toast);
    }
}
  

// Check thông tin trên form
const name = document.getElementById("name"); // not number and special character
const email = document.getElementById("email"); 
const password = document.getElementById("password"); //< 20 kytu chỉ chứa và có đủ ký tự, ký tự đặc biệt, số
const address = document.getElementById("address"); // không chứa ký tự đặc biệt
const phone = document.getElementById("phonenumber"); // toàn số và phải đủ 10 số
const Salary = document.getElementById("salary"); //toàn số 
