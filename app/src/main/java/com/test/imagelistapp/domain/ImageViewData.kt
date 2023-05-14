package com.test.imagelistapp.domain

import java.io.Serializable

/** This class is created to be passed from one fragment to another
I know that this kind of data should be stored in repository and
then got by another fragment from there
but since I want to enjoy my weekend
I will just pass it as serializable.Sorry :) **/
data class ImageViewData(
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
    val favorites:Int
) : Serializable
