(ns greed)

; See frequencies
;(defn group_by_count
;  [values]
;  (->>
;    (group-by identity values)
;    (map (fn [[key values]] [key (count values)]))
;    (into {})
;    )
;  )

(def triplet-rewards
  {1 1000
   2 200
   3 300
   4 400
   5 500
   6 600})

(defn single-number-score
  [number]
  (cond
    (== number 1) 100
    (== number 5) 50
    :else 0))

(defn reduce-score
  [number amount accumulated]
  (if (>= amount 3)
    (->>
      (get triplet-rewards number)
      (+ accumulated)
      (reduce-score number (- amount 3)))
    (->>
      amount
      (* (single-number-score number))
      (+ accumulated))))

(defn greed-game
  [dices]
  (->>
    (frequencies dices)
    (map (fn [[key value]] (reduce-score key value 0)))
    (reduce +)
    ))
