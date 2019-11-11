(ns ld4)
(require '[clojure.string :as str])

;; Map of students and marks
(def students {"Inese" 10 "Vasja" 8 "Petja" 4 "Natasha" 7 "Anja" 10 "Lauris" 6 "Sandra" 8 "Krišjanis" 9})
(println "List of students: " students)

;; Function counts average mark
(defn average [num] (float  (/ (reduce + num) (count num))))

;; Function filters students and calls another function to calculate average mark
(defn avg [students]
(average
  (for [[x y] (filter (fn [[k v]] (str/ends-with? k "a")) students)] y)
))

;; Output result
(println "Average of the given students' marks, for the students, whose names end in 'a' is: " (avg students))
