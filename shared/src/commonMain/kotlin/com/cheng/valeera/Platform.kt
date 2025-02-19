package com.cheng.valeera

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform