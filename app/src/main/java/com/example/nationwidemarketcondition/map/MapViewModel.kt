package com.example.nationwidemarketcondition.map

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nationwidemarketcondition.networkmodel.repository.NetworkRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class MapViewModel(var networkRepository: NetworkRepository) :ViewModel(){
    var status:MutableLiveData<String> ?= MutableLiveData()
    var _status:MutableLiveData<String> ?= status

    fun getStatus(query:String){
        println(query)
        var state = networkRepository.getGeocode(query)
        status!!.postValue(state.status)
        status!!.postValue("hahahha")
//        println(state.getStatus())
    }

}