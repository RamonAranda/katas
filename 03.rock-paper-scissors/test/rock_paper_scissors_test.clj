(ns rock-paper-scissors_test
  (:require [clojure.test :refer [are deftest testing]]
            [rock-paper-scissors :refer [rock-paper-scissors-game]]))

(deftest RockScissorsPaperGame
  (testing "foo"
    (are [player1 player2] (= "Draw!" (rock-paper-scissors-game player1 player2))
                  "Scissors" "Scissors")))