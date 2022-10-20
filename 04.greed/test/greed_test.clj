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
                 [2 3 4 1 6 5]))
  (testing "Scores tripletes for any number from 1 to 6"
    (are [dices expected-score] (= (greed-game dices) expected-score)
                 [1 1 1 3 3 2] 1000
                 [2 2 2 3 3 4] 200
                 [3 3 3 4 4 2] 300
                 [4 4 4 3 3 2] 400
                 [5 5 5 3 3 2] 500
                 [6 6 6 3 3 2] 600))
  (testing "Scores multiples tripletes"
    (are [dices expected-score] (= (greed-game dices) expected-score)
                 [1 1 1 1 1 1] 2000
                 [2 2 2 2 2 2] 400
                 [3 3 3 3 3 3] 600
                 [4 4 4 4 4 4] 800
                 [5 5 5 5 5 5] 1000
                 [6 6 6 6 6 6] 1200))
  (testing "Scores multiples tripletes and some extra numbers"
    (are [dices expected-score] (= (greed-game dices) expected-score)
                 [1 1 1 1 2 3] 1100
                 [1 1 1 1 2 5] 1150)))