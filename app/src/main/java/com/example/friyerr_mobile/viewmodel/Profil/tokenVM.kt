package com.example.friyerr_mobile.viewmodel.Profil


class TokenVM() {
    var access_token: String
    var token_type: String
    var expires_in: Int
    var userName: String
    var issued: String
    var FacebookToken: String
    var userId: Int


    init {
        this.access_token = ""
        this.token_type = ""
        this.expires_in = 0
        this.userName = ""
        this.issued = ""
        this.FacebookToken = ""
        this.userId = 0
    }


}