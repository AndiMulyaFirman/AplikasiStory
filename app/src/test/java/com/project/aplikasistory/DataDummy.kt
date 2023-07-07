package com.project.aplikasistory

import com.project.aplikasistory.data.remote.response.PostStoryResponse
import com.project.aplikasistory.data.remote.response.Story

object DummyData {
    fun generateDummyDataResponse():List<Story>{
        val items: MutableList<Story> = arrayListOf()
        for (i in 0..10){
            val story = Story(
                id = "$i",
                name = "Andi",
                description = "Andi $i",
                photoUrl = "https://story-api.dicoding.dev/images/stories/photos-1684247289450_9X9l92So.jpg",
                createdAt = "2023-01-12T11:01:05.963Z",
                lat = 11.12,
                lon = 11.31
            )
            items.add(story)
        }
        return items
    }
    fun getTokenDummy():String {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJ1c2VyLUZaSmlvQ1c3NE0tNm5zSUwiLCJpYXQiOjE2ODQyNDc2MjZ9.1sV_YLqOZyNBgdtKiIoQrFyHM20ImWOoNz9azchpOxQ"
    }
    fun generateDummyDataStory(): PostStoryResponse {
        return PostStoryResponse(
            false,
            "success"
        )
    }
}