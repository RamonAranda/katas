(ns rock-paper-scissors)

(defn rock-paper-scissors-game
  [player1 player2]
  (cond
    (= player1 player2) "Draw!"
    (and (= player1 "Scissors") (= player2 "Paper")) "Player 1 wins!"
    (and (= player1 "Rock") (= player2 "Scissors")) "Player 1 wins!"
    (and (= player1 "Paper") (= player2 "Rock")) "Player 1 wins!"
    :else "Player 2 wins!"
    ))