package com.example.nationwidemarketcondition.map

import android.content.Context
import android.widget.Toast
import com.naver.maps.map.LocationSource
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.PathOverlay

class MainMap:OnMapReadyCallback {
    var nMap:NaverMap? = null //맵 객체, UI 이벤트를 다룸
//    var markerStartPoint = Marker()
//    var markerWayPoint = Marker()
//    var markerGoalPoint = Marker()
//    var pathOverlay: PathOverlay = PathOverlay()
    var listener: (()->Unit)? = null //맵이 생기기 전에 호출됨을 방지함
    var context: Context?=null //MapFragment의 context를 가져옴
    var locationSource:LocationSource ?=null //MapFragment에서 Location을 띄우기 위함
    override fun onMapReady(naverMap: NaverMap) {
        nMap = naverMap
        listener = {
            nMap!!.locationSource=locationSource
            nMap!!.uiSettings.isLocationButtonEnabled = true
            nMap!!.locationOverlay.isVisible = true
            nMap!!.locationTrackingMode = LocationTrackingMode.Follow

            nMap?.setOnMapClickListener { pointF, coord ->
                Toast.makeText(context, "${coord.latitude}, ${coord.longitude}",Toast.LENGTH_SHORT).show()
                println("${coord.latitude}, ${coord.longitude}")
            }
        }
        listener?.invoke()
    }
}