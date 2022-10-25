package com.katas

private fun List<Score>.sum(): Score {
    return if (isNotEmpty()) this.reduce { acc, score -> return acc + score } else Score(0)
}

private fun calculateTripletScore(dices: Map<Dice, Int>): Score {
    return dices.filterValues { it >= 3 }
        .map { Scores.tripletScoreFor(it.key) }
        .sum()
}

private fun calculateSingleValueScore(dices: Map<Dice, Int>): Score {
    return dices.filterValues { it < 3 }
        .map { Scores.singleScoreFor(it.key) }
        .sum()
}

fun greedGame(dices: List<Int>): Score {
    val groupedDicesByValue = dices.map { Dice(it) }
        .groupBy { it }
        .mapValues { it.value.count() }
    val tripletScore = calculateTripletScore(groupedDicesByValue)
    val singleValueScore = calculateSingleValueScore(groupedDicesByValue)
    return tripletScore + singleValueScore
}