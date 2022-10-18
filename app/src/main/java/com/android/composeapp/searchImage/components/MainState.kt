package com.android.composeapp.searchImage.components

import com.android.composeapp.searchImage.network.model.Hit

data class MainState(
    val isLoading:Boolean=false,
    val data:List<Hit> = emptyList(),
    val error:String=""
)