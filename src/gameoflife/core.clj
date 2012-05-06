(ns gameoflife.core)


(defn number-of-live-neighbours
  [grid cell]
  )

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






