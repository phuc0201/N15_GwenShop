let openSidebar = true;
let sidebar = document.getElementById('sidebar')
let content = document.querySelector('#web_body .content')

function loadDataTable(){
    $.ajax({
        url: `${window.location.href}/load-table`,
        method: "GET",
        success: function (data) {
            let table_content = document.querySelector(".table_wrapper table");
            table_content.innerHTML = data;
            getcontrol();
        }
    });
}
loadDataTable();
document.getElementById('guide-button').addEventListener("click", ()=>{
    if(openSidebar == true)
    {
        openNav();
        openSidebar = false;
    }
    else
    {
        closeNav();
        openSidebar = true;
    }
})
function openNav() {
    sidebar.style.transform = "translateX(0%)";
}
function closeNav() {
    sidebar.style.transform = "translateX(-100%)";
}


function showSuccessToast(action) {
    // let messageConfirm = `Bạn có chắc chắn muốn ${action} không`;
    let message = `Bạn đã ${action} thành công`;
    toast({
        title: "Thành công",
        message: message,
        type: "success",
        duration: 1500
    });
}
function showErrorToast(action) {
    let message = `Bạn đã ${action} thất bại`;
    toast({
        title: "Thất bại",
        message: message,
        type: "error",
        duration: 1500
    });
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
function checkBox_checked(){
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
    icon_wastebasket.addEventListener("click", ()=>{
        let id = []
        checkbox_wastebasket.forEach((item)=>{
           if(item.checked){
                id.push(getParentElement(item, "TR").querySelectorAll("td")[1].innerHTML)
           }
        })
        $.post(
            `${window.location.href}/deleteMany`,
            {
                arrayData:id,
                mode:"insert"
            }
        )
        .done(function (){
            icon_wastebasket.style.display = "none";
            loadDataTable();
        })
    })
}

function getParentElement(elm, tagName){
    if(elm.parentElement.tagName == tagName){
        return elm.parentElement;
    }
    return getParentElement(elm.parentElement, tagName);
}

function Validator(options) {
    options.rules.forEach((rule)=>{
        if(rule.selector.length >= 1)
        {
            rule.selector.forEach((item_rule)=>{
                let inputElement = item_rule;
                inputElement.onblur = function () {
                    validate(options,inputElement, rule);
                }
                inputElement.oninput = function () {
                    validate(options,inputElement, rule);
                }
            })
        }
        else{
            let inputElement = rule.selector;
            inputElement.onblur = function () {
                validate(options,inputElement, rule);
            }
            inputElement.oninput = function () {
                validate(options,inputElement, rule);
            }
        }
    })
}

function validate(options,inputElement, rule)
{
    errorElement = inputElement.parentElement.querySelector(options.errorSelector);
    if(rule.test(inputElement.value)){
        errorElement.innerText = rule.test(inputElement.value);
        inputElement.parentElement.classList.add("invalid");
    }
    else{
        errorElement.innerText = '';
        inputElement.parentElement.classList.remove("invalid");
    }
    return errorElement.innerText? false:true;
}
function checkSubmit(options, btn_name=""){
    let formElement = document.querySelector(options.form);
    if(btn_name == "delete"){
        DeleteData();
        formElement.style.display = "none";
        document.querySelector(".layer").remove();
    }
    else {
        if(formElement)
        {
            formElement.onsubmit = function (e){
                let isFormValid = true;
                options.rules.forEach((rule)=>{
                    let isValid = true;
                    if(rule.selector.length >= 1)
                    {
                        rule.selector.forEach((item_rule)=>{
                            let inputElement = item_rule;
                            isValid = validate(options,inputElement, rule);
                        })
                    }
                    else{
                        let inputElement = rule.selector;
                        isValid = validate(options,inputElement, rule);
                    }
                    if(!isValid){
                        isFormValid = false;
                    }
                })
                if (options.listImage)
                    if(document.querySelectorAll(options.listImage).length == 1)
                        isFormValid = false;

                if(isFormValid)
                {
                    if(btn_name == "create"){
                        InsertData();
                    }
                    else if(btn_name == "edit"){
                        UpdateData();
                    }
                    formElement.style.display = "none";
                    document.querySelector(".layer").remove();
                    e.preventDefault();
                }
                else{
                    showErrorToast('thực thi');
                    e.preventDefault();
                }
            }
        }
    }
}
