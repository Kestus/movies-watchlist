package ru.kestus.movies_watchlist.data.network.interceprot

import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import java.util.Calendar

class TimeoutInterceptor(
    private val timeout: Long = 1000
) : Interceptor {

    private var previousRequestTime = timeNow() - timeout

    override fun intercept(chain: Interceptor.Chain): Response {
        val now = timeNow()
        val response = if (now - previousRequestTime < timeout) {
            Response.Builder()
                .protocol(Protocol.HTTP_2)
                .code(408)
                .body("".toResponseBody())
                .message("Request timeout: ${timeout / 1000} second(s)")
                .request(chain.request())
                .build()

        } else {
            chain.proceed(chain.request())
        }
        previousRequestTime = now
        return response
    }

    private fun timeNow() = Calendar.getInstance().timeInMillis

}