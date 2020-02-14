package com.example.nationwidemarketcondition.networkmodel

import com.example.nationwidemarketcondition.networkmodel.dataclass.MapRetrofitData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitMapInterface {
    @GET("/map-geocode/v2/geocode")
    fun requestLocation(
        @Query("query") query: String,
        @Header("X-NCP-APIGW-API-KEY-ID") apiID: String,
        @Header("X-NCP-APIGW-API-KEY") apiSecret: String
    ): Call<MapRetrofitData>
}