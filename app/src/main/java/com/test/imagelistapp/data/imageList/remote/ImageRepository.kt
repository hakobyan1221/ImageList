package com.test.imagelistapp.data.imageList.remote

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.test.imagelistapp.data.imageList.remote.model.ImageDataModel

interface ImageRepository {

    suspend fun getImageList():LiveData<PagingData<ImageDataModel>>
}
