package com.project.aplikasistory.presentation.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.project.aplikasistory.data.remote.response.Story
import com.project.aplikasistory.databinding.ActivityDetailBinding

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        detailStory()

    }
    private fun detailStory(){
        val story = intent.getParcelableExtra<Story>(EXTRA_STORY) as Story
        with(binding){
            tvUsername.text = story.name
            tvDescription.text = story.description
            tvDate.text = story.createdAt
            Glide.with(this@DetailActivity)
                .load(story.photoUrl)
                .into(ivDetailImage)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
    companion object {
        const val EXTRA_STORY = "extra_story"
    }
}