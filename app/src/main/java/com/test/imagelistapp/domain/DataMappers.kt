package com.test.imagelistapp.domain

import com.test.imagelistapp.data.imageList.remote.model.ImageDataModel
import com.test.imagelistapp.data.login.repo.model.LoginResponse
import com.test.imagelistapp.data.login.repo.model.SignUpResponse
import com.test.imagelistapp.domain.home.HomeViewModel
import com.test.imagelistapp.domain.login.LoginViewModel
import com.test.imagelistapp.domain.login.SignUpViewModel

// Mappers for data layer model to UI layer models

fun LoginResponse.toLoginViewData() = LoginViewModel
    .LoginViewData(isSuccess, loginError, passwordError)

fun SignUpResponse.toSignUpViewData() =
    SignUpViewModel.SignUpViewData(isSuccess, loginError, passwordError, ageError)

fun ImageDataModel.toImageViewData() = ImageViewData(
    previewURL,
    largeImageURL,
    imageSize,
    type,
    tags,
    user,
    views,
    likes,
    comments,
    downloads,
    collections
)
