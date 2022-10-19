(ns rock-paper-scissors-test
  (:require [clojure.test :refer [are deftest testing]]
            [rock-paper-scissors :refer [rock-paper-scissors-game]]))

(deftest rock-paper-scissors-game-test
  (testing "Players draw if they play the same shape"
    (are [player1 player2] (= (rock-paper-scissors-game player1 player2) "Draw!")
                           "Scissors" "Scissors"
                           "Paper" "Paper"
                           "Rock" "Rock"))
  (testing "Scissor beats Paper"
    (are [player1 player2 expected] (= (rock-paper-scissors-game player1 player2) expected)
                                    "Scissors" "Paper" "Player 1 won!"
                                    "Paper" "Scissors" "Player 2 won!"))
  (testing "Paper beats Rock"
    (are [player1 player2 expected] (= (rock-paper-scissors-game player1 player2) expected)
                                    "Paper" "Rock" "Player 1 won!"
                                    "Rock" "Paper" "Player 2 won!"))
  (testing "Rock beats Scissors"
    (are [player1 player2 expected] (= (rock-paper-scissors-game player1 player2) expected)
                                    "Rock" "Scissors" "Player 1 won!"
                                    "Scissors" "Rock" "Player 2 won!")))