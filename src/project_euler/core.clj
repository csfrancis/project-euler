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

(defn problem_3
	"https://projecteuler.net/problem=3"
	[]
	(loop [n 600851475143 p 2 factors []]
		(if (= n 1)
			(last factors)
			(if (= (mod n p) 0)
				(recur (/ n p) p (conj factors p))
				(recur n (+ p 1) factors)))))


(defn -main
  "Project Euler"
  [& args]
  (when (not (nil? args))
  	(println (eval (read-string (format "(project-euler.core/problem_%s)" (nth args 0)))))))
