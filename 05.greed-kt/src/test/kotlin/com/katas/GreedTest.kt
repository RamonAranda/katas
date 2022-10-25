package com.katas

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe


class GreedTest : StringSpec({
    "Accepts any amount of dices from 1 to 6" {
        greedGame(listOf(2)) shouldBe Score(0)
        greedGame(listOf(2, 2)) shouldBe Score(0)
        greedGame(listOf(2, 2, 3)) shouldBe Score(0)
        greedGame(listOf(2, 2, 3, 3)) shouldBe Score(0)
        greedGame(listOf(2, 2, 3, 3, 4)) shouldBe Score(0)
        greedGame(listOf(2, 2, 3, 3, 4, 6)) shouldBe Score(0)
    }
    "Scores 50 if any dice is a 5" {
        greedGame(listOf(5)) shouldBe Score(50)
        greedGame(listOf(5, 2, 3, 4, 6)) shouldBe Score(50)
    }
    "Scores 100 if any dice is a 1" {
        greedGame(listOf(1)) shouldBe Score(100)
        greedGame(listOf(1, 2, 3, 4, 6)) shouldBe Score(100)
    }
    "Scores 1000 for a triplet of 1" {
        greedGame(listOf(1, 1, 1)) shouldBe Score(1000)
        greedGame(listOf(1, 1, 1, 2, 2, 3)) shouldBe Score(1000)
    }
    "Scores 200 for a triplet of 2" {
        greedGame(listOf(2, 2, 2)) shouldBe Score(200)
        greedGame(listOf(2, 2, 2, 3, 3, 4)) shouldBe Score(200)
    }
    "Scores 300 for a triplet of 3" {
        greedGame(listOf(3, 3, 3)) shouldBe Score(300)
        greedGame(listOf(3, 3, 3, 2, 2, 4)) shouldBe Score(300)
    }
    "Scores 400 for a triplet of 4" {
        greedGame(listOf(4, 4, 4)) shouldBe Score(400)
        greedGame(listOf(4, 4, 4, 2, 2, 3)) shouldBe Score(400)
    }
    "Scores 500 for a triplet of 5" {
        greedGame(listOf(5, 5, 5)) shouldBe Score(500)
        greedGame(listOf(5, 5, 5, 2, 2, 3)) shouldBe Score(500)
    }
    "Scores 600 for a triplet of 6" {
        greedGame(listOf(6, 6, 6)) shouldBe Score(600)
        greedGame(listOf(6, 6, 6, 2, 2, 3)) shouldBe Score(600)
    }
    "Scores a triplet plus an extra 1" {
        greedGame(listOf(2, 2, 2, 1)) shouldBe Score(300)
        greedGame(listOf(3, 3, 3, 1)) shouldBe Score(400)
        greedGame(listOf(4, 4, 4, 1)) shouldBe Score(500)
        greedGame(listOf(5, 5, 5, 1)) shouldBe Score(600)
        greedGame(listOf(6, 6, 6, 1)) shouldBe Score(700)
    }
    "Scores a triplet plus an extra 5" {
        greedGame(listOf(1, 1, 1, 5)) shouldBe Score(1050)
        greedGame(listOf(2, 2, 2, 5)) shouldBe Score(250)
        greedGame(listOf(3, 3, 3, 5)) shouldBe Score(350)
        greedGame(listOf(4, 4, 4, 5)) shouldBe Score(450)
        greedGame(listOf(6, 6, 6, 5)) shouldBe Score(650)
    }
})