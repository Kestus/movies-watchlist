package ru.kestus.movies_watchlist.data.network

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.kestus.movies_watchlist.data.network.interceprot.TimeoutInterceptor

object ApiFactory {

    private const val KINO_BASE_URL = "https://kinopoiskapiunofficial.tech/api/v2.2/"

    private val gson = GsonBuilder()
//            .registerTypeAdapter()
        .create()
    private val converterFactory = GsonConverterFactory.create(gson)

    private val headerInterceptor = Interceptor {
        val withHeaders = it.request()
            .newBuilder()
            .addHeader("X-API-KEY", "c6c6e888-24d0-4a69-8176-261f0facf93a")
            .addHeader("Content-Type", "application/json")
            .build()
        it.proceed(withHeaders)
    }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(headerInterceptor)
        .addInterceptor(loggingInterceptor)
        .addInterceptor(TimeoutInterceptor())
        .build()

    private val kinoInstance by lazy {
        Retrofit.Builder()
            .baseUrl(KINO_BASE_URL)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
    }

    fun getService(): ApiServiceKino = kinoInstance.create(ApiServiceKino::class.java)

}