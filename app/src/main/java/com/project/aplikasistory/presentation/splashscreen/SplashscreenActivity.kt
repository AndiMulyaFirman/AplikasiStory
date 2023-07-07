package com.project.aplikasistory.presentation.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import com.project.aplikasistory.R
import com.project.aplikasistory.data.preferences.UserPreferences
import com.project.aplikasistory.domain.User
import com.project.aplikasistory.presentation.login.LoginActivity
import com.project.aplikasistory.presentation.main.MainActivity

@SuppressLint("CustomSplashScreen")
@Suppress("DEPRECATION")
class SplashscreenActivity : AppCompatActivity() {

    private lateinit var userModel: User
    private lateinit var userPreferences: UserPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        userPreferences = UserPreferences(this)
        userModel = userPreferences.getUser()

        Handler(Looper.getMainLooper()).postDelayed({
            if (userModel.token == "") {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            finish()
        }, DELAY.toLong())

    }
    companion object{
        const val DELAY = 2000
    }
}