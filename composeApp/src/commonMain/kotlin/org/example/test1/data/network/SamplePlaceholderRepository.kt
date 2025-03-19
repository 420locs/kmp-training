package org.example.test1.data.network

import io.ktor.client.call.body
import io.ktor.http.HttpStatusCode

class SamplePlaceholderRepository(private val remoteApi: SamplePlaceholderApi = SamplePlaceholderApi()) {
    suspend fun getTodo(): List<SampleTodo> {
        val response = remoteApi.getTodos()

        when (response.status) {
            HttpStatusCode.OK -> {
                return checkNotNull(response.body<List<SampleTodo>?>())
            }

            else -> throw IllegalStateException("/todos api failed!")
        }
    }
}