(ns fizzbuzz)

(defn fizzbuzz-algorithm
  [number]
  (let [is-mod-3 (zero? (mod number 3))
        is-mod-5 (zero? (mod number 5))]
    (cond
      (and is-mod-3 is-mod-5) "FizzBuzz"
      is-mod-3 "Fizz"
      is-mod-5 "Buzz"
      :else number
      ))
  )