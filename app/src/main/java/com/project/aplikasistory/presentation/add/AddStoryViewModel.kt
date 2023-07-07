package com.project.aplikasistory.presentation.add

import androidx.lifecycle.ViewModel
import com.project.aplikasistory.data.StoryRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody

class AddStoryViewModel constructor(private val repository: StoryRepository): ViewModel(){
    fun uploadStory(auth: String, description: RequestBody, file: MultipartBody.Part, lat: Double?, lon: Double?) =
        repository.uploadStory(auth, description, file,lat,lon)
}