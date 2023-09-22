package com.companyname.imagesearchpage.Item

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface InterFace {
    @GET("v2/search/image")
    fun getItem(
        @Header("Authorization") apikey:String?,
        @Query("query") query:String?,
        @Query("sort") sort: String?,
        @Query("page") page:Int,
        @Query("size") size:Int
    ): Call<ItemX?>?
}
