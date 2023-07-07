package com.project.aplikasistory.data.remote.response

import com.google.gson.annotations.SerializedName

data class GetStoryResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("listStory")
    val listStory: List<Story>,
    @SerializedName("error")
    val error: Boolean
)