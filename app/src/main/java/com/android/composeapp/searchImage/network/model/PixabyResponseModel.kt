package com.android.composeapp.searchImage.network.model

data class PixabyResponseModel(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)