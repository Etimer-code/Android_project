package com.example.footballview.di

import com.example.footballview.data.StandingsTableRepositoryImpl
import com.example.footballview.data.network.FootballViewAPI
import com.example.footballview.domain.StandingsTableRepository
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create

object NetworkProvider {

    private val footballViewApi: FootballViewAPI =
        Retrofit.Builder()
            .baseUrl("https://api.football-data.org")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        val request = chain.request()
                            .newBuilder()
                            .addHeader("X-Auth-Token", "e7fb964657c64ed1b08d76018d46d613")
                            .build()
                        chain.proceed(request)
                }.build()
            )
            .addConverterFactory(
                Json(builderAction = {
                    isLenient = true
                    ignoreUnknownKeys = true
                }).asConverterFactory(MediaType.parse("application/json")!!)
            )
            .build()
            .create()

    private var standingsTableRepository : StandingsTableRepository? = null

    fun getStandingsTableRepository() : StandingsTableRepository =
        standingsTableRepository ?: StandingsTableRepositoryImpl(footballViewApi).also { standingsTableRepository = it }
}