package com.indigo.custom.networks

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object{
      private var instance:ApiService ?= null
       fun getApiService():ApiService{
           if (instance==null){
               instance = Retrofit.Builder()
                   .baseUrl("https://jsonplaceholder.typicode.com/")
                   .addConverterFactory(GsonConverterFactory.create())
                   .build().create(ApiService::class.java)
           }
           return instance!!
       }
    }
}