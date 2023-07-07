package com.project.aplikasistory.data.remote.response

import com.google.gson.annotations.SerializedName

data class PostStoryResponse(
    @field:SerializedName("message")
    val message: Boolean,
    @field:SerializedName("error")
    val error: String
)