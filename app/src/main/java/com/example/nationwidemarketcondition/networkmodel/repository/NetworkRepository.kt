package com.example.nationwidemarketcondition.networkmodel.repository

import com.example.nationwidemarketcondition.networkmodel.RetrofitMapInterface
import com.example.nationwidemarketcondition.networkmodel.dataclass.MapRetrofitData
import io.reactivex.Single
import java.lang.Exception

class NetworkRepository(var retrofitMapInterface : RetrofitMapInterface) {
    private val NAVER_API_CLIENT = "j4wmk0uctf"
    private val NAVER_API_SECRET = "T35GsupgkCiBsEMzFx4heOry6Za5OEJyWVru8gNU"
    lateinit var geocode:MapRetrofitData
    fun getGeocode(query:String): MapRetrofitData{
        try{
            val addressToLatlng = retrofitMapInterface.requestLocation(query,NAVER_API_CLIENT,NAVER_API_SECRET)
            val requestGeocode = addressToLatlng.execute().body()!!
            geocode=requestGeocode
            println(requestGeocode.status)
            println(requestGeocode.lang)
        }
        catch (e:Exception){
            e.printStackTrace()
        }
        return geocode

    }
}