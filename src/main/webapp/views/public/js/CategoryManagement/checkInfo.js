let specialCharacters = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;
function checkInfoInput (){
    Validator({
        form: '.content__header section',
        errorSelector: '.message',
        rules: [
            Validator.isCharacters(document.querySelector('.content__header .insert_category-input'), "a-z A-Z"),
        ],
        onsubmit: function(){}
    });
}

Validator.isCharacters = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            return (value.trim().length == 0 || specialCharacters.test(value) || /[0-9]/.test(value))? message : undefined
        }
    };
}