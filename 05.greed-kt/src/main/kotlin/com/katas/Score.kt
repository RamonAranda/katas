package com.katas

@JvmInline
value class Score(private val value: Int) {
    operator fun plus(other: Score): Score {
        return Score(value + other.value)
    }
}