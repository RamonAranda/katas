(ns rock-paper-scissors-test
  (:require [clojure.test :refer [are deftest testing]]
            [rock-paper-scissors :refer [rock-paper-scissors-game]]))

(deftest rock-paper-scissors-game-test
  (testing "Players draw if they play the same shape"
    (are [player1 player2] (= "Draw!" (rock-paper-scissors-game player1 player2))
                  "Scissors" "Scissors"
                  "Paper" "Paper"
                  "Rock" "Rock"))
  (testing "Player 1 beats Player 2"
    (are [player1 player2] (= "Player 1 wins!" (rock-paper-scissors-game player1 player2))
                  "Scissors" "Paper"
                  "Paper" "Rock"
                  "Rock" "Scissors"))
  (testing "Player 2 beats Player 1"
    (are [player1 player2] (= "Player 2 wins!" (rock-paper-scissors-game player1 player2))
                  "Paper" "Scissors"
                  "Rock" "Paper"
                  "Scissors" "Rock")))