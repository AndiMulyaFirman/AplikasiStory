package com.project.aplikasistory.data.remote.response

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "storyList")
data class Story(
    @PrimaryKey
    @field:SerializedName("id")
    val id: String,
    @field:SerializedName("createdAt")
    val createdAt: String,
    @field:SerializedName("description")
    val description: String,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("photoUrl")
    val photoUrl: String,
    @field:SerializedName("lon")
    val lon: Double,
    @field:SerializedName("lat")
    val lat: Double
): Parcelable