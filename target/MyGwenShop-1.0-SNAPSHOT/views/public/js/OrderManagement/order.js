function getcontrol(){
    getElement();
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
    btn_Edit.forEach((edit)=>{
        let idProd = getParentElement(edit, "TR").querySelectorAll("td")[1].innerHTML;
        edit.onclick = ()=>{
            $.ajax({
                url: `${window.location.href}/edit?id=${idProd}`,
                method: "GET",
                success: function (data){
                    alert(data)
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
}