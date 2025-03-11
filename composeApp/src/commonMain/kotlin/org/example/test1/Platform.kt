package org.example.test1

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform