package com.example.friyerr_mobile.service.model

open class Accommodation(name : String ,
                         TypeLocation : String ,
                         TypeAccomodation : String ,
                         Surface : Float,
                         Rate :Float,
                         Adress: String,
                         Cp : Int,
                         City:String,
                         Country: String,
                         Description : String,
                         NbrOfPieces : Int,
                         NbrBathroom :Int,
                         UrlImage : String,
                         IsLike : Boolean,
                         Latitude : Float,
                         Longitude: Float)
{
    var nameAccommodation : String
    var typeLocation: String
    var typeAccomodation: String
    var suraface : Float
    var rate : Float
    var adress: String
    var cp:Int
    var city : String
    var country : String
    var description: String
    var nbrOfPieces : Int
    var nbrBathroom :  Int
    var urlImage: String
    var isLike:Boolean
    var longitude : Float
    var latitude : Float
    init {
        this.nameAccommodation=name
        this.typeLocation=TypeLocation
        this.typeAccomodation=TypeAccomodation
        this.suraface=Surface
        this.rate=Rate
        this.adress=Adress
        this.cp=Cp
        this.city=City
        this.country=Country
        this.description=Description
        this.nbrOfPieces=NbrOfPieces
        this.nbrBathroom=NbrBathroom
        this.urlImage=UrlImage
        this.isLike=IsLike
        this.longitude=Longitude
        this.latitude=Latitude
    }
}