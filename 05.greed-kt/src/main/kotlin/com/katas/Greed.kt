package com.katas

private fun List<Score>.sum(): Score =
    if (isNotEmpty())
        this.reduce { acc, score -> return acc + score }
    else
        Score(0)

private fun calculateNOfAKindScore(dices: Map<Dice, Int>): Score =
    dices.filterValues { it >= 3 }
        .map { Scores.tripletScoreFor(it.key) * Scores.multiplierForNOfAKind(it.value) }
        .sum()

private fun calculateSingleValueScore(dices: Map<Dice, Int>): Score =
    dices.filterValues { it < 3 }
        .map { Scores.singleScoreFor(it.key) }
        .sum()

fun greedGame(dices: List<Dice>): Score {
    val groupedDicesByValue = dices.groupBy { it }.mapValues { it.value.count() }
    val tripletScore = calculateNOfAKindScore(groupedDicesByValue)
    val singleValueScore = calculateSingleValueScore(groupedDicesByValue)
    return tripletScore + singleValueScore
}
