function getcontrol()
{
    getElement();
    checkInfoInput();
    btn_Delete.forEach((del)=>{
        let idProd = getParentElement(del, "TR").querySelectorAll("td")[0].innerHTML;
        del.onclick = ()=>{
            $.post(
                `${window.location.href}/delete?id=${idProd}`,
            )
            .done(function (){
                loadDataTable();
            });
        }
    })
    function getParentElement(elm, tagName){
        if(elm.parentElement.tagName == tagName){
            return elm.parentElement;
        }
        return getParentElement(elm.parentElement, tagName);
    }
    btn_Edit.forEach((edit)=>{
        let idProd = getParentElement(edit, "TR").querySelectorAll("td")[0].innerHTML;
        edit.onclick = ()=>{
            if(document.querySelector(".insert_category-input").value!==""){
                $.post(
                    `${window.location.href}/edit?id=${idProd}`,
                    {
                        name: document.querySelector(".insert_category-input").value,
                    }
                )
                    .done(function (){
                        loadDataTable();
                        document.querySelector(".insert_category-input").value = "";
                    })
            }
        };
    })
    btn_add.onclick = ()=>{
        if(document.querySelector(".insert_category-input").value!==""){
            $.post(
                `${window.location.href}/create?name=${document.querySelector(".insert_category-input").value}`,
            )
                .done(function (){
                    loadDataTable();
                    document.querySelector(".insert_category-input").value = "";
                })
        }
    }
}