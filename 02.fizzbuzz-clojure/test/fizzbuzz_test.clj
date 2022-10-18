(ns fizzbuzz_test
  (:require [clojure.test :refer [are deftest testing]]
            [fizzbuzz :refer [fizzbuzz-algorithm]]))

(deftest stage1
  (testing "Sample test"
    (are [number] (= number (fizzbuzz-algorithm number))
                  1)))