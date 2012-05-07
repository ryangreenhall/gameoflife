(ns gameoflife.core)

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
      (and (and (<= 0 (:x cell)) (>= (dec (count grid)) (:x cell)))
           (and (<= 0 (:y cell)) (>= (dec (count grid)) (:y cell)))))

    (filter inside-grid? (map #(into {} {:x (+ (:x cell) (:x %))
                                         :y (+ (:y cell) (:y %))}) relative-positions))))

(defn alive?
  [grid cell]
  (= :alive (aget (to-array-2d grid) (:y cell) (:x cell))))

(defn number-of-living-neighbours
  [grid cell]
  (count (filter #(alive? grid %1) (neighbours grid cell))))

(defn state
  [grid cell]
  (aget (to-array-2d grid) (:y cell) (:x cell)))

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

(defn changes
  [grid]
  (let [change-set {}]
    (loop [x 0
           items grid]
      (when items
        (loop [y 0
               cols (first items)]
          (when cols   
            (println x "," y)
            (let [state (state grid {:x x :y y})]
              (when (= :alive state)
                (if (> (number-of-living-neighbours grid {:x x :y y}) 3)
                  (into {:x x :y y :state :dead} change-set))

                (if (< (number-of-living-neighbours grid {:x x :y y}) 2)
                  (into {:x x :y y :state :dead} change-set)))
              (when (= :dead state)
                (when (= 3 (number-of-living-neighbours grid {:x x :y y}))
                  (into {:x x :y y :state :alive}))))
            (recur (inc y) (next cols))))
        (recur (inc x) (next items))))
    change-set))






