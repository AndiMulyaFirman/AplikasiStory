package com.project.aplikasistory.di

import android.content.Context
import com.project.aplikasistory.data.StoryRepository
import com.project.aplikasistory.data.local.database.StoryDatabase
import com.project.aplikasistory.data.remote.network.ApiConfig

object Injection {
    fun provideRepository(context: Context) : StoryRepository {
        val apiService = ApiConfig.getApiService()
        val database = StoryDatabase.getDatabase(context)
        return StoryRepository(apiService, database)
    }
}