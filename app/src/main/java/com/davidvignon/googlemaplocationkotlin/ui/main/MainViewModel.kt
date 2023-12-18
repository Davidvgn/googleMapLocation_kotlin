package com.davidvignon.googlemaplocationkotlin.ui.main

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.ViewModel
import com.davidvignon.googlemaplocationkotlin.data.LocationRepository
import com.davidvignon.googlemaplocationkotlin.data.PermissionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
   private val permissionRepository: PermissionRepository,
   private val locationRepository: LocationRepository,
) : ViewModel() {

     @SuppressLint("MissingPermission")
     fun refresh() {
        if (permissionRepository.isLocationPermissionGranted()) {
            locationRepository.startLocationRequest()
            }
        }
}