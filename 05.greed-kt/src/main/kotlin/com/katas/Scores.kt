package com.katas

object Scores {
    private val singleScore = mapOf(
        Dice(1) to Score(100),
        Dice(2) to Score(0),
        Dice(3) to Score(0),
        Dice(4) to Score(0),
        Dice(5) to Score(50),
        Dice(6) to Score(0)
    )

    fun singleScoreFor(value: Dice) = singleScore[value]!!

    private val tripletScore = mapOf(
        Dice(1) to Score(1000),
        Dice(2) to Score(200),
        Dice(3) to Score(300),
        Dice(4) to Score(400),
        Dice(5) to Score(500),
        Dice(6) to Score(600)
    )

    fun tripletScoreFor(value: Dice) = tripletScore[value]!!
}