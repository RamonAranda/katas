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
  (testing "Scores 6 equal numbers"
    (are [dices expected-score] (= (greed-game dices) expected-score)
                                [1 1 1 1 1 1] 8000
                                [2 2 2 2 2 2] 1600
                                [3 3 3 3 3 3] 2400
                                [4 4 4 4 4 4] 3200
                                [5 5 5 5 5 5] 4000
                                [6 6 6 6 6 6] 4800))
  (testing "Scores 5 equal numbers"
    (are [dices expected-score] (= (greed-game dices) expected-score)
                                [1 1 1 1 1 2] 4000
                                [2 2 2 2 2 3] 800
                                [3 3 3 3 3 2] 1200
                                [4 4 4 4 4 2] 1600
                                [5 5 5 5 5 2] 2000
                                [6 6 6 6 6 2] 2400))
  (testing "Scores 5 equal numbers plus some extra number"
    (are [dices expected-score] (= (greed-game dices) expected-score)
                                [1 1 1 1 1 5] 4050
                                [2 2 2 2 2 5] 850
                                [3 3 3 3 3 5] 1250
                                [4 4 4 4 4 5] 1650
                                [5 5 5 5 5 1] 2100
                                [6 6 6 6 6 5] 2450))
  (testing "Scores 4 equal numbers"
    (are [dices expected-score] (= (greed-game dices) expected-score)
                                [1 1 1 1 2 2] 2000
                                [2 2 2 2 3 3] 400
                                [3 3 3 3 2 2] 600
                                [4 4 4 4 2 2] 800
                                [5 5 5 5 2 2] 1000
                                [6 6 6 6 2 2] 1200))
  (testing "Scores 4 equal numbers plus some extra number"
    (are [dices expected-score] (= (greed-game dices) expected-score)
                                [1 1 1 1 2 5] 2050
                                [2 2 2 2 3 5] 450
                                [3 3 3 3 2 5] 650
                                [4 4 4 4 2 5] 850
                                [5 5 5 5 2 1] 1100
                                [6 6 6 6 2 5] 1250))
  (testing "Scores three pairs"
    (are [dices] (= (greed-game dices) 800)
                 [1 1 2 2 3 3]
                 [2 2 3 3 4 4]
                 [5 5 6 6 1 1]))
  (testing "Scores straight"
    (are [dices] (= (greed-game dices) 1200)
                 [1 2 3 4 5 6]
                 [2 3 4 5 6]
                 [3 4 5 6]
                 [4 5 6])))