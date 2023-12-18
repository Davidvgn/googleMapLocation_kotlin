package com.davidvignon.googlemaplocationkotlin.ui.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.davidvignon.googlemaplocationkotlin.data.LocationRepository
import com.davidvignon.googlemaplocationkotlin.data.PermissionRepository
import com.davidvignon.googlemaplocationkotlin.utils.Event
import com.google.android.gms.maps.model.LatLng
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MapViewModel @Inject constructor(
    private val locationRepository: LocationRepository,
) : ViewModel(
) {

    val viewActionLiveData: LiveData<LatLng> = liveData {
        locationRepository.startLocationRequest().collect() {
            emit(LatLng(it.lat, it.long))
        }
    }

}


