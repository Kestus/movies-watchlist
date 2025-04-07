package ru.kestus.kinopoisk

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class KtorClient(
    private val baseUrl: String,
    private val requestHeaders: List<Pair<String, String>>
) {
    fun client() = HttpClient {
        // throw exceptions on 3xx, 4xx, 5xx response codes
        expectSuccess = true

        defaultRequest {
            url(baseUrl)
            for (header in requestHeaders) {
                headers.append(header.first, header.second)
            }
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
}