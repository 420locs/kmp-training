package org.example.test1.data.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class SamplePlaceholderApi(private val httpClient: HttpClient = KtorClient()){
    private val baseUrl = "https://jsonplaceholder.typicode.com"

    suspend fun getTodos() = httpClient.get("${baseUrl}/todos")
}