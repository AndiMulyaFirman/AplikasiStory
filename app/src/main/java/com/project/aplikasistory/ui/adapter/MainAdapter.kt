package com.project.aplikasistory.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.project.aplikasistory.databinding.ItemStoryBinding
import com.project.aplikasistory.presentation.detail.DetailActivity
import com.bumptech.glide.Glide
import com.project.aplikasistory.data.remote.response.Story


class MainAdapter : PagingDataAdapter<Story, MainAdapter.StoryViewHolder>(DiffCallback) {

    private lateinit var onItemClickCallback: OnItemClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = StoryViewHolder(
        ItemStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val story = getItem(position)
        if (story != null) {
            holder.bind(story)
            holder.itemView.setOnClickListener{
                onItemClickCallback.onItemClicked(story)
            }
            holder.itemView.setOnClickListener{
                val intent = Intent(holder.itemView.context, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_STORY, story)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    class StoryViewHolder(private val binding: ItemStoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(listStory: Story) {
            with(binding) {
                Glide.with(binding.root.context)
                    .load(listStory.photoUrl)
                    .into(ivStory)
                tvName.text = listStory.name
                tvDescription.text = listStory.description
            }
        }
    }

    interface OnItemClickCallback{
        fun onItemClicked(listStory: Story)
    }
    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<Story>() {
            override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean {
                return oldItem == newItem
            }
        }
    }

}