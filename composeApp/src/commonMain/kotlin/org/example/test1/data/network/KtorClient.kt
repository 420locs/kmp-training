package org.example.test1.data.network

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.test1.Platform
import org.example.test1.getPlatform

object KtorClient {
    operator fun invoke() = when (getPlatform()) {
        Platform.Android -> HttpClient(engineFactory = CIO, block = getKtorClientSetting())
        else -> HttpClient(block = getKtorClientSetting())
    }

    private fun getKtorClientSetting(): HttpClientConfig<*>.() -> Unit = {
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.d(tag = "Ktor log\n", message = message)
                }
            }
        }.also { Napier.base(DebugAntilog()) }
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }
}