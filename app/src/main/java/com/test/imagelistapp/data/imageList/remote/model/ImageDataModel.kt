package com.test.imagelistapp.data.imageList.remote.model

data class ImageDataModel(
    val previewURL: String,
    val largeImageURL: String,
    val imageSize: Int,
    val type: String,
    val tags: String,
    val user: String,
    val views: Int,
    val likes: Int,
    val comments: Int,
    val downloads: Int,
    val collections: Int
)

data class ImageListDataModel(
    val total: Int,
    val totalHits: Int,
    val hits: List<ImageDataModel>
)
