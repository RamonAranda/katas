package com.katas


fun greedGame(dices: List<Int>): Int {
    val score = when {
        1 in dices -> 100
        5 in dices -> 50
        else -> 0
    }
    return score
}