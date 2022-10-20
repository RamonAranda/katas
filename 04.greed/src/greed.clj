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

(def rewards
  {:1        100
   :5        50
   :straight 1200
   :pairs    800
   :no-score 0
   })

(def triplet-rewards
  {1 1000
   2 200
   3 300
   4 400
   5 500
   6 600})

(def reward-multipliers
  {3 1
   4 2
   5 4
   6 8})

(defn single-number-score
  [number]
  (cond
    (== number 1) (get rewards :1)
    (== number 5) (get rewards :5)
    :else (get rewards :no-score)))

(defn calculate-score-for-number
  [number amount]
  (if (>= amount 3)
    (->>
      (get triplet-rewards number)
      (* (get reward-multipliers amount)))
    (* (single-number-score number) amount)))

(defn calculate-scores-for-all-numbers
  [grouped-numbers]
  (->>
    grouped-numbers
    (map (fn [[key value]] (calculate-score-for-number key value)))
    (reduce +)))

(defn amount-of-pairs
  [grouped-numbers]
  (->>
    (vals grouped-numbers)
    (filter #(= % 2))
    (count)
    ))

(defn calculate-pair-score
  [grouped-numbers]
  (if (= (amount-of-pairs grouped-numbers) 3) (get rewards :pairs) (get rewards :no-score)))


(defn is-straight
  [dices]
  (let [dice-count (count dices)
        first-value (first dices)
        straight (doall (range first-value (+ first-value dice-count)))]
    (= dices straight)))

(defn calculate-straight-score
  [dices]
  (if (is-straight dices) (get rewards :straight) (get rewards :no-score)))

(defn greed-game
  [dices]
  (let [grouped-numbers (frequencies dices)
        single-number-scores (calculate-scores-for-all-numbers grouped-numbers)
        pair-score (calculate-pair-score grouped-numbers)
        straight-score (calculate-straight-score dices)]
    (cond
      (> pair-score 0) pair-score
      (> straight-score 0) straight-score
      :else single-number-scores))
  )
