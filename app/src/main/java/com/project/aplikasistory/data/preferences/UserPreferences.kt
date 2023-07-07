package com.project.aplikasistory.data.preferences


import android.content.Context
import com.project.aplikasistory.domain.User

internal class UserPreferences(context: Context) {
    private val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun saveUser(value: User){
        val edit = preferences.edit()
        edit.putString(TOKEN, value.token)
        edit.apply()
    }

    fun getUser(): User {
        val model = User()
        model.token = preferences.getString(TOKEN, "")
        return model
    }

    fun clearToken() {
        val edit = preferences.edit()
        edit.remove(TOKEN)
        edit.apply()
    }



    companion object {
        private const val PREFS_NAME = "user_pref"
        private const val TOKEN = "token"
    }
}