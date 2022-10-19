(ns greed-test
  (:require [clojure.test :refer [are deftest testing]]
            [greed :refer [greed-game]]))

(deftest greed-game-test
  (testing "Scores no point"
    (are [dices] (= (greed-game dices) 0)
                 [2 3 4 2 6]
                 [2 3 4 6]
                 [2 3 4 6]))
  (testing "Scores a single one"
    (are [dices] (= (greed-game dices) 100)
                 [1 2 3 4 2 6]
                 [2 3 1 4 6]
                 [2 3 4 6 1]))
  (testing "Scores a single five"
    (are [dices] (= (greed-game dices) 50)
                 [5 2 3 4 6]
                 [2 3 5 4 6]
                 [2 3 4 6 5]))
  (testing "Score is accumulated for a one and a five"
    (are [dices] (= (greed-game dices) 150)
                 [1 5 2 3 4 6]
                 [1 2 3 5 4 6]
                 [1 2 3 4 6 5]
                 [2 3 4 1 6 5])))