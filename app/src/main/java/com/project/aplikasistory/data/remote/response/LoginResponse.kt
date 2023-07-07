package com.project.aplikasistory.data.remote.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("loginResult")
    val loginResult: LoginResult,
    @SerializedName("error")
    val error: Boolean
)