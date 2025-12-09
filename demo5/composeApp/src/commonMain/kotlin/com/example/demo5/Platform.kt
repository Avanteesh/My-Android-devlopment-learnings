package com.example.demo5

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform