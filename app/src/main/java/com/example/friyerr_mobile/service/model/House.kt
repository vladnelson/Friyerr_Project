package com.example.friyerr_mobile.service.model

class House(name : String ,
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
            UrlImage: String,
            IsLike: Boolean,
            Longitude : Float,
            Latitude: Float) : Accommodation(
    name,
    TypeLocation,
    TypeAccomodation,
    Surface,
    Rate,
    Adress,
    Cp,
    City,
    Country,
    Description,
    NbrOfPieces,
    NbrBathroom,
    UrlImage,
    IsLike,
    Longitude,
    Latitude)
{
    init {

    }
}