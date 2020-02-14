package com.example.nationwidemarketcondition.networkmodel.dataclass

import com.google.gson.annotations.SerializedName
import com.naver.maps.geometry.LatLng

data class MapRetrofitData(
    @SerializedName("status")
    val status:String,
    @SerializedName("x")
    val lang:String,
    @SerializedName("y")
    val long:String
){
    data class latlng(var lang:String, var long:String)
//    fun getStatus():String{
//        return status
//    }
//
//    fun getLatLng():LatLng{
//        return LatLng(lang.toDouble(),long.toDouble())
//    }


}