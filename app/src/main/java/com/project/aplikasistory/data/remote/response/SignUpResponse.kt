package com.project.aplikasistory.data.remote.response

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("error")
    val error: Boolean
)