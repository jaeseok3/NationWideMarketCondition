package com.example.nationwidemarketcondition.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.nationwidemarketcondition.R
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMapOptions
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.util.FusedLocationSource
import kotlinx.android.synthetic.main.activity_map.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapFragment : Fragment() {
    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }

    private var mainMap:MainMap= MainMap()

    private val mViewModel by viewModel<MapViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View=inflater.inflate(R.layout.activity_map,container,false)
        mainMapSetting(mainMap)

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentManager = childFragmentManager
        val mapFragment = fragmentManager.findFragmentById(R.id.map) as MapFragment?
            ?: MapFragment.newInstance((NaverMapOptions().locationButtonEnabled(true))
                .also {
                    fragmentManager.beginTransaction().add(R.id.map, map).commit()
                })

        mapFragment.getMapAsync(mainMap)

    }

    private fun mainMapSetting(mainMap: MainMap){
        mainMap.context=this.context
        mainMap.locationSource=FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)
    }
}