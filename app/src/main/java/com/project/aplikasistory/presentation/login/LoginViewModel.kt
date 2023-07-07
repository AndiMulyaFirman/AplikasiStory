package com.project.aplikasistory.presentation.login

import androidx.lifecycle.ViewModel
import com.project.aplikasistory.data.StoryRepository

class LoginViewModel(private val Repository: StoryRepository):ViewModel() {
    fun login(email:String, password: String) = Repository.login(email, password)
}