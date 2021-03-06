package com.sampleweather.mossinwkung.sampleweatherapplication.presentation.weather

import com.sampleweather.mossinwkung.sampleweatherapplication.response.WeatherResponse

interface WeatherMainContract {
    interface View {
        fun showOutput(response: WeatherResponse)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun getCurrentWeather(city: String, degree: String)
    }
}