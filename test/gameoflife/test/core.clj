(ns gameoflife.test.core
  (:use [gameoflife.core])
  (:use [clojure.test]))

(deftest can-find-the-neighbours-of-a-cell-at-edge
  (is (= [{:x 1 :y 0}
          {:x 0 :y 1}
          {:x 1 :y 1}] (neighbours [[:alive :dead :alive]
                                    [:alive :dead :alive]
                                    [:alive :dead :alive]] {:x 0 :y 0}))))

(deftest can-find-the-neighbours-of-a-cell
  (is (= [{:x 2, :y 1}
          {:x 1, :y 2}
          {:x 1, :y 1}] (neighbours [[:alive :dead :alive]
                                     [:alive :dead :alive]
                                     [:alive :dead :alive]] {:x 2 :y 2}))))

(deftest can-identify-cells-that-are-living
  (is (alive? [[:alive :alive]
               [:alive :alive]] {:x 0 :y 0})))

(deftest can-identify-cells-that-are-dead
  (is (not (alive? [[:dead :alive]
                    [:alive :alive]] {:x 0 :y 0}))))

(deftest can-find-the-number-of-living-neighbours
  (is (= 3 (number-of-living-neighbours [[:alive :alive]
                                         [:alive :alive]] {:x 0 :y 0})))
  (is (= 0 (number-of-living-neighbours [[:alive :dead]
                                         [:dead  :dead]] {:x 0 :y 0})))

  (is (= 2 (number-of-living-neighbours [[:alive :alive]
                                         [:dead :alive]] {:x 1 :y 0})))

  (is (= 1 (number-of-living-neighbours [[:alive :dead :alive]
                                         [:alive :dead :alive]
                                         [:alive :dead :alive]] {:x 2 :y 2}))))                      
