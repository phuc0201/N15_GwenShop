function getcontrol(){
    getElement();
    document.querySelector(".form_product-detail").style.display = "none";
    btn_Delete.forEach((del)=>{
        let idProd = getParentElement(del, "TR").querySelectorAll("td")[1].innerHTML;
        del.onclick = ()=>{
            $.post(
                `${window.location.href}/delete?id=${idProd}`,
            )
                .done(function (){
                    loadDataTable();
                });
        }
    })
    btn_ShowInfoOrder.forEach((order)=>{
        let idProd = getParentElement(order, "TR").querySelectorAll("td")[1].innerHTML;
        order.onclick = ()=>{
            ShowProductInOrder();
            $.ajax({
                url: `${window.location.href}/edit?id=${idProd}`,
                method: "GET",
                success: function (data){
                    document.querySelector(".form_product-detail").innerHTML = data;
                }
            })
        }
    })
    function getParentElement(elm, tagName){
        if(elm.parentElement.tagName == tagName){
            return elm.parentElement;
        }
        return getParentElement(elm.parentElement, tagName);
    }
    function ShowProductInOrder(){
        document.querySelector(".form_product-detail").style.display = "block";
        let layer = document.createElement("div");
        layer.className = "layer";
        document.querySelector("body").append(layer);
        layer.onclick =_=>{
            document.querySelector(".form_product-detail").style.display = "none";
            layer.remove();
        }
    }
}