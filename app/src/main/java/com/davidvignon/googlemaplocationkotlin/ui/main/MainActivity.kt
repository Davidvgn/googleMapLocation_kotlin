package com.davidvignon.googlemaplocationkotlin.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.commitNow
import androidx.lifecycle.Observer
import com.davidvignon.googlemaplocationkotlin.ui.map.MapFragment
import com.davidvignon.googlemaplocationkotlin.R
import com.davidvignon.googlemaplocationkotlin.databinding.MainActivityBinding
import com.davidvignon.googlemaplocationkotlin.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding { MainActivityBinding.inflate(it) }
    private val viewModel by viewModels<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            displayFragment(MapFragment.newInstance())
        }
    }

    private fun displayFragment(fragment: Fragment) {
        supportFragmentManager.commitNow {
            replace(R.id.main_FrameLayout_fragment_container, fragment)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh()
    }
}