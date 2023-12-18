package com.davidvignon.googlemaplocationkotlin.data

import android.Manifest.permission
import android.app.Application
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PermissionRepository
@Inject constructor(
    private val application: Application
){

    fun isLocationPermissionGranted():Boolean =
         ContextCompat.checkSelfPermission(
            application,
            permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED



     fun getPermissionsFlow(): Flow<List<PermissionEntity>> = flow {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(
                    application, permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(
                    application,
                    permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            )
                emit(
                    listOf(
                        PermissionEntity(permission.ACCESS_FINE_LOCATION, true),
                        PermissionEntity(permission.ACCESS_COARSE_LOCATION, true)
                    )
                )
        }
    }
}

