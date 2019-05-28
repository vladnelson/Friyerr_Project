package com.example.friyerr_mobile.viewmodel.Account

class Register(pseudo : String, email : String, password : String , passwordAgain : String  ) {
    var pseudoRegister : String
    var emailRegister : String
    var passwordRegister : String
    var passwordAgainRegister : String

    init {
        this.pseudoRegister=pseudo
        this.emailRegister=email
        this.passwordRegister=password
        this.passwordAgainRegister=passwordAgain
    }
}