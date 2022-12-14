let specialCharacters = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;

Validator.isCharacters = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            return (value.trim().length == 0 || specialCharacters.test(value) || /[0-9]/.test(value))? message : undefined
        }
    };
}

Validator.isNumber = function(selector, message){
    return{
        selector: selector,
        test: function(value){
            return (specialCharacters.test(value) || /[a-zA=Z]/.test(value) || value.trim().length == 0 || value.trim()[0] == '0')?  message : undefined
        }
    }
}
Validator.isProductName = function(selector, message){
    return {
        selector: selector,
        test: function (value) {
            return (value.trim().length == 0 || specialCharacters.test(value))? message : undefined
        }
    };
}
