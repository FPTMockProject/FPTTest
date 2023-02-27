package com.example.network

import com.google.gson.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*

object RetrofitHelper {
    const val SERVER_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss" // Adjust as per your use case
    fun getInstance(baseUrl: String): Retrofit {
        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        val gson = GsonBuilder()
            .setDateFormat(SERVER_DATE_FORMAT)
            .registerTypeAdapter(Date::class.java, object : JsonSerializer<Date> {
                private val utcDateFormat = SimpleDateFormat(
                    SERVER_DATE_FORMAT,
                    Locale.ENGLISH
                ).apply {
                    timeZone = TimeZone.getTimeZone("UTC")
                }

                // Avoid using local date formatter (with timezone) to send UTC date
                override fun serialize(
                    src: Date?,
                    typeOfSrc: Type?,
                    context: JsonSerializationContext?
                ): JsonElement {
                    return JsonPrimitive(src?.let { utcDateFormat.format(it) })
                }
            })
            .create()
        val gsonConverterFactory = GsonConverterFactory.create(gson)

        return Retrofit.Builder().baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(gsonConverterFactory)
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }
}