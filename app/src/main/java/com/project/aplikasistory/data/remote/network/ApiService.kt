package com.project.aplikasistory.data.remote.network

import com.project.aplikasistory.data.remote.response.GetStoryResponse
import com.project.aplikasistory.data.remote.response.LoginResponse
import com.project.aplikasistory.data.remote.response.PostStoryResponse
import com.project.aplikasistory.data.remote.response.SignUpResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): SignUpResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @Multipart
    @POST("stories")
    suspend fun uploadStories(
        @Header("Authorization") auth: String,
        @Part file: MultipartBody.Part,
        @Part("description") description: RequestBody,
        @Part("lat") lat: Double?,
        @Part("lon") lon: Double?
    ): PostStoryResponse

    @GET("stories")
    suspend fun getStoriesPaging(
        @Query("page") page: Int,
        @Query("size") size: Int,
        @Header("Authorization") auth: String
    ) : GetStoryResponse

    @GET("stories")
    suspend fun getStoriesLocation(
        @Query("location") loc: Int,
        @Header("Authorization") auth: String
    ) : GetStoryResponse

}