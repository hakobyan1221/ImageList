package com.test.imagelistapp.data.imageList.remote

import com.test.imagelistapp.data.API_KEY
import com.test.imagelistapp.data.imageList.remote.model.ImageListDataModel
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET("/api")
    suspend fun loadImages(
        @Query("key") key: String = API_KEY, @Query("q", encoded = true) q: String = "flowers",
        @Query("image_type") imageType: String = "photo",
        @Query("page") page: Int
    ): ImageListDataModel
}
