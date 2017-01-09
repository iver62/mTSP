set terminal png
set output "ab_pareto_5.png"
set title "randomAB approche Pareto"
plot "randomAB_OnLineFiltered_time=5_nb=500.tsp" using 1:2 title "pareto 5 min" pointtype 7 linecolor 6, "../../data/best.randomAB100.tsp" using 1:2 title "best" pointtype 7 linecolor 7
