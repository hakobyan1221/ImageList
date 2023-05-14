package com.test.imagelistapp.domain.home

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.test.imagelistapp.data.imageList.remote.ImageRepository
import com.test.imagelistapp.data.imageList.remote.model.ImageDataModel
import com.test.imagelistapp.di.imageList.ImageListScope
import com.test.imagelistapp.domain.ImageViewData
import com.test.imagelistapp.domain.toImageViewData
import kotlinx.coroutines.launch
import java.io.Serializable
import javax.inject.Inject

class HomeViewModel @Inject constructor(@ImageListScope private val imageListRepository: ImageRepository) :
    ViewModel() {

    suspend fun getImageList(): LiveData<PagingData<ImageViewData>> {
        return imageListRepository.getImageList()
            .map { it.map { it.toImageViewData() } }
            .cachedIn(viewModelScope)
    }
}
