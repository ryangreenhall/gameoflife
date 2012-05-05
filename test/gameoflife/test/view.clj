(ns gameoflife.test.view
  (:use [gameoflife.view])
  (:use [clojure.test]))

(deftest grid-rendering
  (is (str "X-\n"
           "X-")
      (render [[:alive :dead]
               [:alive :dead]])))
