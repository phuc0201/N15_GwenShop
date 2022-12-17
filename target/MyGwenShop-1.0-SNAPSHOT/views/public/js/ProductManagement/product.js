// MAIN //
let idProdCurrent;
function getcontrol()
{
    getElement();
    checkBox_checked()
    if(list_image.length == 1)
        showImage.style.backgroundImage = null;

    let categorySelector = document.getElementById("select_category");
    categorySelector.onchange=_=>{
        if(categorySelector.value == "all"){
            loadDataTable();
        }
        else{
            document.querySelectorAll(".table_wrapper tbody tr")
            .forEach(row=>{
                if(row.querySelectorAll("td")[2].innerHTML != categorySelector.value){
                    row.style.display = "none";
                }else row.style.display = "table-row";
            })
        }
    }
    btn_Delete.forEach((del)=>{
        del.onclick = ()=>{
           let idProd = getParentElement(del, "TR").querySelectorAll("td")[1].innerHTML;
            $.ajax({
                url: `${window.location.href}/delete`,
                method: "POST",
                data: {
                    id: idProd,
                },
                success: function () {
                    loadDataTable();
                }
            });
        }
    })
    function getParentElement(elm, tagName){
        if(elm.parentElement.tagName == tagName){
            return elm.parentElement;
        }
        return getParentElement(elm.parentElement, tagName);
    }
    for(let img = 0; img < image_item.length - 1; img ++){
        image_item[img].onclick = ()=>{
            showImage.style.backgroundImage = image_item[img].style.backgroundImage;
        }
    }

    btn_add.onclick=()=>{
        showFormInfoProduct();
        btn_update.style.display = "none";
        btn_insert.style.display = "block";
    };
    btn_Edit.forEach((edit)=>{
        edit.onclick = ()=>{
            let col = getParentElement(edit, "TR").querySelectorAll("td");
            idProdCurrent = col[1].innerText;
            showFormInfoProduct();
            btn_insert.style.display = "none";
            btn_update.style.display = "block";
            document.getElementById("product_name").value = col[4].innerText
            document.getElementById("form-inforProduct__description").value = col[5].querySelector(".product-description").value
            document.getElementsByName("product_amount")[0].value = col[6].innerText
            document.getElementById("product_price").value = col[7].innerText
            document.getElementById("category").value = col[2].innerText
            document.querySelector(".main-image").style.backgroundImage = col[3].querySelector(".product-image").style.backgroundImage
            $.ajax({
                url: `${window.location.href}/edit?id=${idProdCurrent}`,
                method: "GET",
                success: function (data) {
                    getElement();
                    let wrapper = document.createElement("div");
                    wrapper.innerHTML = data;
                    wrapper.style.display = "flex"
                    list_image_wrap.insertBefore(wrapper, list_image[list_image.length-1]);
                    getcontrol();
                    plusImages(1);
                }
            });
        };
    })

    function showFormInfoProduct(){
        resetInputForm(form_infoProduct);
        let layer = document.createElement("div");
        layer.className = "layer";
        document.querySelector("body").appendChild(layer);

        layer.addEventListener("click", ()=>{
            form_infoProduct.style.display = "none";
            layer.remove();
        })
        form_infoProduct.style.display = "block";
    }
    function resetInputForm(element)
    {
        element.querySelectorAll('input').forEach((input)=>{
            input.value = "";
            input.parentElement.classList.remove("invalid");
        })
        element.querySelectorAll('.form-message').forEach((message)=>{
            message.innerHTML = "";
        })
        for(let img = 0; img < list_image.length - 1; img++){
            list_image[img].remove();
        }
        document.getElementById("form-inforProduct__description").value = "";
        showImage.style.backgroundImage = null;
    }
    icon_minus.forEach((elm)=>{
        elm.onclick = ()=>{
            let elmPar = elm.parentElement;
            elm.parentElement.remove();
            getElement();
            if(elmPar.lastChild.style.backgroundImage == showImage.style.backgroundImage)
            {
                if(list_image.length == 1)
                    showImage.style.backgroundImage = null;
                else
                    showImage.style.backgroundImage = image_item[image_item.length-2].style.backgroundImage;
            }
            if(elmPar.className == list_image[0].className)
            {
                getcontrol();
                plusImages(-1);
            }
        }
    })
}

let slideImageIndex = 0;

function plusImages(firstImage) {
    showSlideImage(slideImageIndex += firstImage);
}
function currentImage(currImage) {
    showImage.style.backgroundImage = list_image[currImage].style.backgroundImage;
}
function showSlideImage(images)
{
    if(list_image.length >= 5)
    {
        if (images < 0) {slideImageIndex = 0}
        if (images > list_image.length - 5) {slideImageIndex = list_image.length - 5;}
        for(let i = slideImageIndex; i < slideImageIndex + 5; i++)
            list_image[i].style.display = "block";
        for(let i = slideImageIndex + 5; i < list_image.length; i++)
            list_image[i].style.display = "none";
        for(let i = slideImageIndex - 1; i >= 0; i--)
            list_image[i].style.display = "none";
    }
}


//
// addColor.addEventListener("click", ()=>{
//     let section = document.createElement("section")
//     section.innerHTML=`
//     <input type="text" class="item-color" value="" placeholder="Nhập tên màu" name="color"></input>
//     <i class="fa-solid fa-circle-minus icon-minus"></i>
//     <span class="form-message"></span>
//   `
//     listColor.appendChild(section)
//     getcontrol();
// })
//
//
// addSize.addEventListener("click", ()=>{
//     let section = document.createElement("section")
//     section.innerHTML=`
//     <input type="text" class="item-size" value="" placeholder="Nhập size" name="size"></input>
//     <i class="fa-solid fa-circle-minus icon-minus"></i>
//     <span class="form-message"></span>
//   `
//     listSize.appendChild(section)
//     getcontrol();
// })

addNewImage.addEventListener("click", ()=>{
    importImage();
})

function importImage() {
    let fileInput = document.createElement('input');
    fileInput.type = 'file';
    fileInput.setAttribute("multiple", "multiple")
    fileInput.click();
    fileInput.onchange = ()=> {
        if (fileInput.multiple)
        {
            for (let file of fileInput.files) {
                setImage(file);
            }
        }
        else{
            setImage(fileInput.files[0])
        }
    };
}
function setImage(file){
    let wrapper = document.createElement("div");
    let img = document.createElement("div");
    let iconRemove = document.createElement("i");
    iconRemove.className="fa-solid fa-circle-minus icon-minus";
    wrapper.className = "image-item_wrapper";
    img.className = "image-item";
    wrapper.appendChild(iconRemove);
    wrapper.appendChild(img);
    list_image_wrap.insertBefore(wrapper, list_image[list_image.length-1]);
    var reader = new FileReader();
    reader.addEventListener("load", ()=>{
        img.style.backgroundImage = `url(${reader.result})`;
        getElement();
        showImage.style.backgroundImage = image_item[image_item.length-2].style.backgroundImage;
    })
    reader.readAsDataURL(file);
    getcontrol();
    plusImages(1);
}
function InsertData(){
    let Image = [];
    getElement();
    image_item.forEach((img)=>{
        let image = img.style.backgroundImage;
        if(image){
            Image.push(image.slice(5, -2));
        }
    })
    $.post(
        `${window.location.href}/create`,
        {
            arrayData:Image,
            name: document.getElementById("product_name").value,
            description: document.getElementById("form-inforProduct__description").value,
            amount: document.getElementsByName("product_amount")[0].value,
            price: document.getElementById("product_price").value,
            category: document.getElementById("category").value,
            mode:"insert"
        }
    )
    .done(function (){
        loadDataTable();
    })
}
function UpdateData(){
    let Image = [];
    getElement();
    image_item.forEach((img)=>{
        let image = img.style.backgroundImage;
        if(image){
            Image.push(image.slice(5, -2));
        }
    })
    $.post(
        `${window.location.href}/edit?id=${idProdCurrent}`,
        {
            arrayData:Image,
            name: document.getElementById("product_name").value,
            description: document.getElementById("form-inforProduct__description").value,
            amount: document.getElementsByName("product_amount")[0].value,
            price: document.getElementById("product_price").value,
            category: document.getElementById("category").value,
            mode:"insert"
        }
    )
        .done(function (){
            loadDataTable();
        })
}