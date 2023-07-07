package com.project.aplikasistory.presentation.register

import androidx.lifecycle.ViewModel
import com.project.aplikasistory.data.StoryRepository

class RegisterViewModel constructor(private val repository: StoryRepository) : ViewModel() {
    fun registerUser(name: String, email: String, password: String) = repository.registerUser(name, email, password)
}
