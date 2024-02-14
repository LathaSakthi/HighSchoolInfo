package com.example.highschoolinfo.mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.highschoolinfo.dao.SchoolInfo
import com.example.highschoolinfo.dao.SchoolInfoDetailsList
import com.example.highschoolinfo.retrofit.RetrofitInstance
import kotlinx.coroutines.launch
import java.net.URL

class SchoolListViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var  _schoolListInfo: MutableLiveData<SchoolInfoDetailsList>
    init{

        viewModelScope.launch {
        // TODO: Get data from network
        //URL("https://data.cityofnewyork.us/resource/s3k6-pzi2.json")

        var retrofit = RetrofitInstance()

        val result = retrofit.retrofitInstance?.getSchoolInfo()

            println(result)

        // TODO: Check _schoolListInfo.value = retrofit.retrofitInstance?.getSchoolInfo()


        }
    }


    // Getters
    var schoolListInfo: LiveData<SchoolInfoDetailsList> = _schoolListInfo
}