package com.project.aplikasistory.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.aplikasistory.data.StoryRepository
import com.project.aplikasistory.di.Injection
import com.project.aplikasistory.presentation.add.AddStoryViewModel
import com.project.aplikasistory.presentation.login.LoginViewModel
import com.project.aplikasistory.presentation.main.MainViewModel
import com.project.aplikasistory.presentation.maps.MapsViewModel
import com.project.aplikasistory.presentation.register.RegisterViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(private val Repository: StoryRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(Repository) as T
            }
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(Repository) as T
            }
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(Repository) as T
            }
            modelClass.isAssignableFrom(AddStoryViewModel::class.java) -> {
                AddStoryViewModel(Repository) as T
            }
            modelClass.isAssignableFrom(MapsViewModel::class.java) -> {
                MapsViewModel(Repository) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null
        fun getInstance(Context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(Context))
            }.also { instance = it }
    }

}