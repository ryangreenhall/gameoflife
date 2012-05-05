(ns gameoflife.view)

(def life-mappings
  {:dead "-"
   :alive "X"})

(defn render-row
  [row]
  (apply str (map #(life-mappings %1) row)))

(defn render
  [grid]
  (reduce str (interpose "\n" (map #(render-row %1) grid))))
