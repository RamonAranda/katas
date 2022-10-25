package com.katas

private fun List<Score>.sum(): Score =
    if (isNotEmpty())
        this.reduce { acc, score -> return acc + score }
    else
        Scores.noScore

private fun calculateNOfAKindScore(dices: Map<Dice, Int>): Score =
    dices.filterValues { it >= 3 }
        .map { Scores.tripletScoreFor(it.key) * Scores.multiplierForNOfAKind(it.value) }
        .sum()

private fun calculateSingleValueScore(dices: Map<Dice, Int>): Score =
    dices.filterValues { it < 3 }
        .map { Scores.singleScoreFor(it.key) }
        .sum()

private fun calculatePairScore(dices: Map<Dice, Int>): Score {
    val amountOfPairs = dices.filterValues { it == 2 }.count()
    return if (amountOfPairs == 3) Scores.pairScore else Scores.noScore
}

fun greedGame(dices: List<Dice>): Score {
    val groupedDicesByValue = dices.groupBy { it }.mapValues { it.value.count() }
    val tripletScore = calculateNOfAKindScore(groupedDicesByValue)
    val singleValueScore = calculateSingleValueScore(groupedDicesByValue)
    val pairScore = calculatePairScore(groupedDicesByValue)
    return when {
        pairScore != Scores.noScore -> pairScore
        else -> tripletScore + singleValueScore
    }
}
