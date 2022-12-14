let specialCharacters = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/;




function Reset_validator(){
    document.querySelectorAll("#form-infoMember .form-group").forEach((element)=>{
        element.classList.remove('invalid');
    })
    document.querySelectorAll("#form-infoMember .form-message").forEach((message)=>{message.innerText=''});
}

Validator.isRequired = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            return (value.trim().length == 0 || specialCharacters.test(value) || /[0-9]/.test(value))? message : undefined
        }
    };
}

Validator.isEmail = function (selector, message) {
    return {
        selector: selector,
        test: function (value) {
            var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
            return regex.test(value) ? undefined :  message;
        }
    };
}
Validator.isPhoneNumber = function(selector, message){
    return{
        selector: selector,
        test: function(value){

            return (value.length != 10 || specialCharacters.test(value) || /[a-zA=Z]/.test(value) || value.trim().length == 0)?  message : undefined
        }
    }
}
Validator.minLength = function (selector, min, max, message) {
    return {
        selector: selector,
        test: function (value) {
            return (value.trim().length >= min && value.trim().length <= max) ? undefined :  message || `Vui lòng nhập tối thiểu ${min} - ${max} kí tự`;
        }
    };
}
Validator.isAddress = function(selector, message){
    return{
        selector: selector,
        test: function(value){
            return (value.length >= 200 || value.trim().length == 0) ? message : undefined;
        }
    }
}
Validator.isSalary = function(selector, message){
    return{
        selector: selector,
        test: function(value){
            return (specialCharacters.test(value) || /[a-zA=Z]/.test(value) || value.trim().length == 0 || value.trim()[0] == 0)?  message : undefined
        }
    }
}