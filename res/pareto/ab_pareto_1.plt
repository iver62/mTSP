set terminal png
set output "ab_pareto_1.png"
set title "randomAB approche Pareto"
plot "randomAB_OnLineFiltered_time=1_nb=500.tsp" using 1:2 title "pareto 1 min" pointtype 7 linecolor 6, "../../data/best.randomAB100.tsp" using 1:2 title "best" pointtype 7 linecolor 7
