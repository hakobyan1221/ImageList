package com.test.imagelistapp.data.imageList.remote

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.test.imagelistapp.data.imageList.remote.ImagePagingSource.Companion.PAGE_SIZE
import com.test.imagelistapp.data.imageList.remote.model.ImageDataModel
import com.test.imagelistapp.di.imageList.ImageListScope
import javax.inject.Inject


class ImageRepositoryImpl @Inject constructor
    (private val imagePagingSource: ImagePagingSource) : ImageRepository {
    override suspend fun getImageList(): LiveData<PagingData<ImageDataModel>> {
        return Pager(
            config = PagingConfig(PAGE_SIZE, enablePlaceholders = false),
            pagingSourceFactory = { imagePagingSource }
        ).liveData
    }
}
