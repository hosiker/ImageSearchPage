package com.companyname.imagesearchpage.Item

import com.companyname.imagesearchpage.Constants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {

    //API 객체를 변경
    val apiService: InterFace
        get()= instance.create(InterFace::class.java)

    //레트로 핏 초기화 및 반환
    private val instance: Retrofit
        private get() {
            // Gson 객체 생성
            val gson = GsonBuilder().setLenient().create()

            // 레트로핏 인스턴스 생성
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
}