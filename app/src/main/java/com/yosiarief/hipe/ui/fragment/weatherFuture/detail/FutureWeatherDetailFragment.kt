package com.yosiarief.hipe.ui.fragment.weatherFuture.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.yosiarief.hipe.R

class FutureWeatherDetailFragment : Fragment() {

    companion object {
        fun newInstance() = FutureWeatherDetailFragment()
    }

    private lateinit var viewModel: FutureWeatherDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.future_weather_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FutureWeatherDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
