(ns greed-test
  (:require [clojure.test :refer [are deftest testing]]
            [greed :refer [greed-game]]))

(deftest greed-game-test
  (testing "Foo"
    (are [dices] (= (greed-game dices) 0)
                 0)))