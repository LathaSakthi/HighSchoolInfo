package com.example.highschoolinfo.retrofit

import com.example.highschoolinfo.dao.SchoolInfoDetailsList
import retrofit2.http.GET
import javax.security.auth.callback.Callback

abstract class RetrofitAPIInterface {

@GET
abstract fun getSchoolInfo(): Result<SchoolInfoDetailsList>

}