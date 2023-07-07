package com.project.aplikasistory.presentation.main

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.aplikasistory.R
import com.project.aplikasistory.data.StoryResult
import com.project.aplikasistory.data.preferences.UserPreferences
import com.project.aplikasistory.databinding.ActivityMainBinding
import com.project.aplikasistory.domain.User
import com.project.aplikasistory.presentation.add.AddStoryActivity
import com.project.aplikasistory.presentation.login.LoginActivity
import com.project.aplikasistory.presentation.maps.MapsActivity
import com.project.aplikasistory.ui.adapter.LoadingStateAdapter
import com.project.aplikasistory.ui.adapter.MainAdapter
import com.project.aplikasistory.utils.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userPreferences: UserPreferences
    private lateinit var mainAdapter: MainAdapter
    private lateinit var rvStory: RecyclerView
    private lateinit var mainViewModel: MainViewModel
    private var userModel: User = User()
    private var token: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        userPreferences = UserPreferences(this)
        userModel = userPreferences.getUser()
        token = userModel.token.toString()

        mainAdapter = MainAdapter()
        rvStory = binding.rvStory

        getStory(token)

        binding.fabAddStory.setOnClickListener{
            startActivity(Intent(this, AddStoryActivity::class.java))
            finish()
        }
    }

    private fun getStory(auth: String) {
        rvStory.adapter = mainAdapter
        mainAdapter.withLoadStateFooter(
            footer = LoadingStateAdapter{
                mainAdapter.retry()
            }
        )
        mainViewModel.isLoading.observe(this){
            showLoading(it)
        }
        mainViewModel.getStory(auth).observe(this){
            mainAdapter.submitData(lifecycle, it)
        }
        rvStory.layoutManager = LinearLayoutManager(this)

    }
    private fun showLoading(loading: Boolean) {
        binding.progressBar.visibility = if (loading) View.VISIBLE else View.GONE
    }
    private fun logout() {
        userModel.token = ""
        userPreferences.saveUser(userModel)
        userPreferences.clearToken()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                logout()

                true
            }
            R.id.settings -> {
                startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
                true
            }
            R.id.map -> {
                startActivity(Intent(this, MapsActivity::class.java))
                true
            }
            else -> true
        }
    }

}