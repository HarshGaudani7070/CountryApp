package com.example.countryapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient  {

    companion object {


        val BASE_URL = "https://restcountries.com/v2/"
        lateinit var retrofit: Retrofit

        fun getApiClient(): Retrofit {

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
    }

}