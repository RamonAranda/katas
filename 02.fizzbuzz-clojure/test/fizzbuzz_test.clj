(ns fizzbuzz_test
  (:require [clojure.test :refer [are deftest testing]]
            [fizzbuzz :refer [fizzbuzz-algorithm]]))

(deftest stage1
  (testing "Numbers that are non divisible by 3 and 5 return the number as is"
    (are [number] (= number (fizzbuzz-algorithm number))
                  1
                  2
                  4
                  7
                  8))
  (testing "Numbers that are divisible by 3 return Fizz"
    (are [number] (= "Fizz" (fizzbuzz-algorithm number))
                  3
                  6
                  9
                  12))
  (testing "Numbers that are divisible by 5 return Buzz"
    (are [number] (= "Buzz" (fizzbuzz-algorithm number))
                  5
                  10
                  20))
  (testing "Numbers that are divisible by 3 and 5 return FizzBuzz"
    (are [number] (= "FizzBuzz" (fizzbuzz-algorithm number))
                  15
                  30)))