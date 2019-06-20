package com.example.friyerr_mobile.service.model

class User ()  {
    var firsname : String
    var name : String
    var civility: String
    var zipCode : String
    var pseudo : String
    var picture_Url : String
    var email :  String
    var phoneNumber : String
    var username : String
    var accommodation : Accommodation?
    var city: City?


    init {
        this.firsname = ""
        this.name=""
        this.civility=""
        this.zipCode=""
        this.pseudo=""
        this.picture_Url=""
        this.email=""
        this.phoneNumber=""
        this.username=""
        this.accommodation= null
        this.city=null


    }
}