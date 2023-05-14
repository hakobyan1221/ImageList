package com.test.imagelistapp.data.imageList.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.test.imagelistapp.data.imageList.remote.model.ImageDataModel
import com.test.imagelistapp.di.imageList.ImageListScope
import javax.inject.Inject

class ImagePagingSource @Inject constructor(
    @ImageListScope private val pixabayApi: PixabayApi
) : PagingSource<Int, ImageDataModel>() {
    override fun getRefreshKey(state: PagingState<Int, ImageDataModel>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImageDataModel> {
        return try {
            val page = params.key ?: 1
            val response = pixabayApi.loadImages(page = page)
            LoadResult.Page(
                data = response.hits,
                prevKey = null,
                nextKey = (page + 1).takeIf { it * PAGE_SIZE <= response.totalHits }
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        const val PAGE_SIZE = 20
    }
}
