package com.example.friyerr_mobile.service.model

class User ()  {
    var Firstname : String
    var Name : String
    var Civility: String
    var ZipCode : String
    var Pseudo : String
    var Picture_Url : String
    var Email :  String
    var PhoneNumber : String
    var UserName : String
    var Accommodation : Accommodation?
    var City: City?
    var Id : String


    init {
        this.Firstname = ""
        this.Name=""
        this.Civility=""
        this.ZipCode=""
        this.Pseudo=""
        this.Picture_Url=""
        this.Email=""
        this.PhoneNumber=""
        this.UserName=""
        this.Accommodation= null
        this.City=null
        this.Id=""


    }
}