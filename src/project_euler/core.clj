(ns project-euler.core
  (:gen-class))

(defn problem_1
	"https://projecteuler.net/problem=1"
	[]
	(loop [sum 0 i 0]
		(if (> i 1000)
			sum
			(if (or (= (mod i 5) 0) (= (mod i 3) 0))
				(recur (+ sum i) (inc i))
				(recur sum (inc i))))))

(defn -main
  "Project Euler"
  [& args]
  (when (not (nil? args))
  	(println (eval (read-string (format "(project-euler.core/problem_%s)" (nth args 0)))))))
