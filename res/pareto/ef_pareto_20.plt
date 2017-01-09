set terminal png
set output "ef_pareto_20.png"
set title "randomEF approche Pareto"
plot "randomEF_OnLineFiltered_time=20_nb=500.tsp" using 1:2 title "pareto 20 min" pointtype 7 linecolor 6, "../../data/best.randomEF100.tsp" using 1:2 title "best" pointtype 7 linecolor 7
