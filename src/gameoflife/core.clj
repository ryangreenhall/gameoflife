(ns gameoflife.core)

(defn number-of-living-neighbours
  [grid cell])


(defn alive?
  [grid cell]

  )

(defn neighbours
  [grid cell]

  (let [relative-positions [{:x  0  :y -1} ;above
                            {:x  1  :y  0} ;right
                            {:x -1  :y  0} ;left
                            {:x  0  :y  1} ;below
                            {:x  1  :y -1} ; above right diagonally
                            {:x -1  :y -1} ; above left diagnonally
                            {:x  1  :y  1} ; below right diagonally
                            {:x -1  :y  1} ; below left diagonally
                            ]]

    (defn inside-grid?
      [cell]
      (and (<= 0 (:x cell)) (<= 0 (:y cell))))

    (filter inside-grid? (map #(into {} {:x (+ (:x cell) (:x %))
                                         :y (+ (:y cell) (:y %))}) relative-positions))))



(defn next-generation
  "Produces the next generation based on the given generation.

  Rules (from Wikipedia):
  1. Any live cell with fewer than two live neighbours dies, as if caused by under-population.
  2. Any live cell with two or three live neighbours lives on to the next generation.
  3. Any live cell with more than three live neighbours dies, as if by overcrowding.
  4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
  "
  [grid]

  ; For each cell check rules above and update state accordingly.
  [[:dead :dead :dead :alive :alive]
   [:dead :dead :dead :alive :alive]
   [:dead :dead :dead :alive :alive]
   [:dead :dead :dead :alive :alive]
   [:dead :dead :dead :alive :alive]])

(defn do-it
  [grid]
  (loop [x 0
         items grid]
    (when items
      (loop [y 0
             cols (first items)]
        (when cols   
          (println x "," y)
          (recur (inc y) (next cols))))
      (recur (inc x) (next items)))))






