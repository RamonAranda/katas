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

(defn greed-game
  [dices]
  (let [grouped-values (frequencies dices)
        contains-1 (contains? grouped-values 1)
        contains-5 (contains? grouped-values 5)]
    (cond
      (and contains-5 contains-1) 150
      contains-5 50
      contains-1 100
      :else 0)))
