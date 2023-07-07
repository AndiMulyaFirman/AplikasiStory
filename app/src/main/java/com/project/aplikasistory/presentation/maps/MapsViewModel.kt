package com.project.aplikasistory.presentation.maps

import androidx.lifecycle.ViewModel
import com.project.aplikasistory.data.StoryRepository

class MapsViewModel(private val repository: StoryRepository): ViewModel() {
    fun getStoriesLocation(token: String) = repository.getStoriesMap(1,token)
}