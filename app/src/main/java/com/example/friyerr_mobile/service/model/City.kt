package com.example.friyerr_mobile.service.model

class City(Id: Int,
           Name : String,
           CP : Int,
           Country : String,
           Density : Int ,
           Longitude_deg : Float,
           Latitude_deg : Float,
           Longitude_grd : String,
           Latitude_grd : String) {

    var id: Int
    var name : String
    var cP : Int
    var country : String
    var density : Int
    var longitude_deg : Float
    var latitude_deg : Float
    var longitude_grd : String
    var latitude_grd : String


    init {
        this.cP=CP
        this.id=Id
        this.name=Name
        this.country=Country
        this.density=Density
        this.longitude_deg=Longitude_deg
        this.latitude_deg=Latitude_deg
        this.longitude_grd=Longitude_grd
        this.latitude_grd=Latitude_grd
    }

}