package org.example.test1

enum class Platform {
    Android,
    Ios,
    Web
}

expect fun getPlatform(): Platform