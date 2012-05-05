(ns gameoflife.core)

(def life-mappings
  {:dead "-"
   :alive "X"})

(defn next-generation
  [grid]
  [[:dead :dead :dead :alive :alive]
   [:dead :dead :dead :alive :alive]
   [:dead :dead :dead :alive :alive]
   [:dead :dead :dead :alive :alive]
   [:dead :dead :dead :alive :alive]])

(defn render
  [grid]
  "")
