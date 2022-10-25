package com.katas

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe


class GreedTest : StringSpec({
    "Accepts any amount of dices from 1 to 6" {
        greedGame(listOf(2)) shouldBe 0
        greedGame(listOf(2, 2)) shouldBe 0
        greedGame(listOf(2, 2, 2)) shouldBe 0
        greedGame(listOf(2, 2, 2, 2)) shouldBe 0
        greedGame(listOf(2, 2, 2, 2, 2)) shouldBe 0
        greedGame(listOf(2, 2, 2, 2, 2, 2)) shouldBe 0
    }
    "Scores 50 if any dice is a 5" {
        greedGame(listOf(5)) shouldBe 50
        greedGame(listOf(5, 2, 3, 4, 6)) shouldBe 50
    }
    "Scores 100 if any dice is a 1" {
        greedGame(listOf(1)) shouldBe 100
        greedGame(listOf(1, 2, 3, 4, 6)) shouldBe 100
    }
})