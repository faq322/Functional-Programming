(require '[clojure.string :as str])

(defn modul [n]
  (max n (- n))
  )

(defn remove-spaces [text]
  (str/replace text #" " "_")
  )

(defn to-array [rows]
  (vec
    (repeat rows [])
    )
  )

(defn row-by-index [rows index]
  (-
    (- rows 1)
    (modul
      (-
        (- rows 1)
        (mod
          index
          (* 2 (- rows 1))
          )
        )
      )
    )
  )

(defn get-key-value [text key]
  (map-indexed
    (fn [index itm]
      [(row-by-index key index) itm index]
      ) text
    )
  )

(defn encrypt [text key]
  (let [vec (to-array key)]
    (str/join
      (map str/join
           (reduce
             (fn [carry item]
               (let [index (get item 0) char (get item 1)]
                 (assoc carry index (conj (get carry index) char))
                 )
               ) (to-array 3)
             (get-key-value (remove-spaces text) key)
             )
           )
      )
    )
  )

(defn decrypt [text key]
  (let [vec (to-array key)]
    (str/join
      (map-indexed
        (fn [index itm]
          (.charAt text
                      (.indexOf
                        (flatten
                          (reduce
                            (fn [carry item]
                              (let [index (get item 0) char (get item 1)]
                                (assoc carry index (conj (get carry index) (get item 2)))
                                )
                              ) (to-array 3)
                            (get-key-value (remove-spaces text) key)
                            )
                          )
                        index
                        )
                      )
          )
        text)
      )
    )
  )
;;TESTING
(println "TEXT:")
(def text (read-line))
(println "KEY:")
(def key (Integer. (read-line)))
(def encrypted_text (encrypt text key))
(println "ENCRYPTED:" encrypted_text)
(def decrypted_text (decrypt encrypted_text key))
(println "DECRYPTED:" decrypted_text)


