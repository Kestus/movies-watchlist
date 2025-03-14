package ru.kestus.movies_watchlist.data.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.kestus.movies_watchlist.data.network.kino.model.CollectionResponse
import ru.kestus.movies_watchlist.data.network.kino.model.DetailedMovieDto

interface ApiServiceKino {

    @GET("films/collections?type=TOP_POPULAR_MOVIES")
    suspend fun getPopular(@Query("page") page: Int = 1): CollectionResponse

    @GET("films/{id}")
    suspend fun getMovie(@Path("id") idKino: Int): DetailedMovieDto

}