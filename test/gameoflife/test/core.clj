(ns gameoflife.test.core
  (:use [gameoflife.core])
  (:use [clojure.test]))

(deftest can-find-the-neighbours-of-a-cell-at-edge
  (is (= [{:x 1 :y 0}
          {:x 0 :y 1}
          {:x 1 :y 1}] (neighbours [] {:x 0 :y 0}))))

(deftest can-find-the-neighbours-of-a-cell
  (is (= [{:x 2, :y 1}
          {:x 3, :y 2}
          {:x 1, :y 2}
          {:x 2, :y 3}
          {:x 3, :y 1}
          {:x 1, :y 1}
          {:x 3, :y 3}
          {:x 1, :y 3}] (neighbours [] {:x 2 :y 2}))))

(deftest can-identify-cells-that-are-living
  (is (alive? [[:alive :alive]
               [:alive :alive]] {:x 0 :y 0})))

(deftest can-identify-cells-that-are-dead
  (is (not (alive? [[:dead :alive]
                    [:alive :alive]] {:x 0 :y 0}))))
