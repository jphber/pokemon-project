package com.jeanbernuy.pokemonapp.core

import com.google.gson.GsonBuilder
import com.jeanbernuy.pokemonapp.core.AppConstants.APP_KEY
import com.jeanbernuy.pokemonapp.core.AppConstants.BASE_URL
import com.jeanbernuy.pokemonapp.data.remote.WebService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestEngine {

    val httpClient: OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor { chain ->
            chain.proceed(
                chain.request().newBuilder().addHeader(
                    "app_key",
                    "$APP_KEY"
                ).build()
            )
        }
        .build()

    val restEngine by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(httpClient)
            .build().create(WebService::class.java)
    }

}