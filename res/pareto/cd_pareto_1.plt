set terminal png
set output "cd_pareto_1.png"
set title "randomCD approche Pareto"
plot "randomCD_OnLineFiltered_time=1_nb=500.tsp" using 1:2 title "pareto 1 min" pointtype 7 linecolor 6, "../../data/best.randomCD100.tsp" using 1:2 title "best" pointtype 7 linecolor 7
