package com.example.repository.repository.datasourse

import com.example.model.details.DetailsPokemonData
import com.example.model.result.PokemonResultData
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class RetrofitImplementation {

    private val service = getService()

    suspend fun getData(): com.example.model.result.PokemonResultData {
        return service.getDataPokemonAsync().await()
    }

    suspend fun getPokemonImageData(url: String): com.example.model.details.DetailsPokemonData {
        return service.getPokemonDetailsAsync(url).await()
    }

    private fun getService(): ApiService {
        return createRetrofit().create(ApiService::class.java)
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(createOkHttpClient(PODInterceptor()))
            .build()
    }

    private fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return httpClient.build()
    }

    class PODInterceptor : Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
            return chain.proceed(chain.request())
        }
    }

    companion object {
        private const val BASE_URL = "https://pokeapi.co/api/v2/"
    }
}
