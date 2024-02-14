package com.example.highschoolinfo.retrofit

import retrofit2.Retrofit

class RetrofitInstance {

    val retrofitBuilder = Retrofit.Builder()
        .baseUrl("https://data.cityofnewyork.us/resource/")
        //.addConverterFactory(GSONConverterFactory.create())
        .build()

    //This can be called in Application class, but for now directly accessing in viewmodel
    public val retrofitInstance = retrofitBuilder.create(RetrofitAPIInterface::class.java)

}