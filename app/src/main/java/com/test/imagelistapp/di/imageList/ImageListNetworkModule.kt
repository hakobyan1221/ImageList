package com.test.imagelistapp.di.imageList

import com.google.gson.Gson
import com.test.imagelistapp.data.BASE_URL
import com.test.imagelistapp.data.imageList.remote.PixabayApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier


@Qualifier
@Retention
internal annotation class InternalApi

@Module
@ImageListScope
class ImageListNetworkModule {

    @Provides
    @InternalApi
    fun provideOkHttpClient() =
        OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS).build()

    @Provides
    @InternalApi
    fun provideConverterFactory() =
        GsonConverterFactory.create(Gson())

    @Provides
    @InternalApi
    fun provideRetrofit(
        @InternalApi converterFactory: GsonConverterFactory,
        @InternalApi client: OkHttpClient
    ): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(converterFactory)
            .client(client)
            .build()

    @Provides
    @ImageListScope
    fun provideDogApi(@InternalApi retrofit: Retrofit): PixabayApi =
        retrofit.create(PixabayApi::class.java)
}
