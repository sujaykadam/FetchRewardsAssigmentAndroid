package com.example.fetchrewardsassigmentandroid.data.api
import com.example.fetchrewardsassigmentandroid.data.model.Item
import retrofit2.http.GET

interface ApiService {
    @GET("hiring.json")
    suspend fun getItems(): List<Item>
}