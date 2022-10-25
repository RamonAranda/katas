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

    private val multipliersForNOfAKind = mapOf(
        4 to 2,
        5 to 4,
        6 to 8
    )

    fun multiplierForNOfAKind(amount: Int) = multipliersForNOfAKind.getOrElse(amount) { return 1 }

    val pair = Score(800)
    val straight = Score(1200)
    val noScore = Score(0)
}
