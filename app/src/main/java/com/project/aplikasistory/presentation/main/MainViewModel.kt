package com.project.aplikasistory.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.project.aplikasistory.data.StoryRepository
import com.project.aplikasistory.data.StoryResult
import com.project.aplikasistory.data.remote.response.GetStoryResponse
import com.project.aplikasistory.data.remote.response.Story

class MainViewModel constructor(private val repository: StoryRepository):ViewModel(){
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getStory(auth: String) : LiveData<PagingData<Story>> =
        repository.getStoriesPaging(auth).cachedIn(viewModelScope)
}