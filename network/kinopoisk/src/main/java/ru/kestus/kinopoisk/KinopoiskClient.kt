package ru.kestus.kinopoisk

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.get
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import ru.kestus.kinopoisk.dto.CollectionResponseDao
import ru.kestus.kinopoisk.dto.DetailedMovieDto
import ru.kestus.kinopoisk.dto.MovieDto

class KinopoiskClient {

    companion object {
        private const val KINO_BASE_URL = "https://kinopoiskapiunofficial.tech/api/v2.2/"
    }

    private val client = HttpClient {
        // throw exceptions on 3xx, 4xx, 5xx response codes
        expectSuccess = true

        defaultRequest {
            url(KINO_BASE_URL)

            headers.append(HttpHeaders.ContentType, "application/json")
            headers.append("X-API-KEY", BuildConfig.API_KEY)
        }

        install(Logging) {
            logger = Logger.SIMPLE
        }

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }

    }

    private var requestsCount = 0

    suspend fun getPopularMovies(page: Int = 1): List<MovieDto> {
        if (requestsCount >= 3) throw RuntimeException("req")
        requestsCount++
        val result = client.get("films/collections?type=TOP_POPULAR_MOVIES") {
            url {
                parameters.append("page", page.toString())
            }
        }.body<CollectionResponseDao>()
        return result.items
    }

    suspend fun getMovie(id: Int): DetailedMovieDto {
        if (requestsCount >= 3) throw RuntimeException("req")
        requestsCount++
        return client.get("films/$id").body<DetailedMovieDto>()
    }

}