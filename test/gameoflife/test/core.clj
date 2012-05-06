(ns gameoflife.test.core
  (:use [gameoflife.core])
  (:use [clojure.test]))

(deftest can-find-the-neighbours-of-a-cell-at-edge
  (is (= [{:x 1 :y 0} {:x 0 :y 1} {:x 1 :y 1} ] (neighbours [] {:x 0 :y 0}))))
