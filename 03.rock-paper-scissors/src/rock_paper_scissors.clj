(ns rock-paper-scissors)

(defn rock-paper-scissors-game
  [player1 player2]
  (let [shape-pair-win-options #{["Scissors" "Paper"] ["Rock" "Scissors"] ["Paper" "Rock"]}
        shape-pair [player1 player2]]
    (cond
      (= player1 player2) "Draw!"
      (contains? shape-pair-win-options shape-pair) "Player 1 won!"
      :else "Player 2 won!"
      ))
  )