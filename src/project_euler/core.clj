(ns project-euler.core
  (:gen-class))

(defn problem_1
	"https://projecteuler.net/problem=1"
	[]
	(loop [sum 0 i 0]
		(if (>= i 1000)
			sum
			(if (or (= (mod i 5) 0) (= (mod i 3) 0))
				(recur (+ sum i) (inc i))
				(recur sum (inc i))))))

(defn problem_2
	"https://projecteuler.net/problem=2"
	[]
	(loop [m 1 n 1 sum 0]
		(let [r (+ m n)]
			(if (> r 4000000)
				sum
				(if (= (mod r 2) 0)
					(recur n r (+ sum r))
					(recur n r sum))))))

(defn problem_3
	"https://projecteuler.net/problem=3"
	[]
	(loop [n 600851475143 p 2 factors []]
		(if (= n 1)
			(last factors)
			(if (= (mod n p) 0)
				(recur (/ n p) p (conj factors p))
				(recur n (+ p 1) factors)))))

(defn problem_4
	"https://projecteuler.net/problem=4"
	[]
	(letfn [(palindrome? [n]
		(and
			(=
				(mod (count n) 2) 0)
				(let [mid (/ (count n) 2)]
					(=
						(subs n 0 mid)
						(clojure.string/reverse (subs n mid))))
				))]
		(last (sort (filter
			(fn [x] (palindrome? (str x)))
			(for [x (reverse (range 1000)) y (reverse (range 1000))] (* x y)))))))

(defn -main
  "Project Euler"
  [& args]
  (when (not (nil? args))
		(println (eval (read-string (format "(time (project-euler.core/problem_%s))" (nth args 0)))))))
