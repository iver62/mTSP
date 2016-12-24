set title "randomCD"
plot "randomCDOnLineFiltered.tsp" using 1:2 title "online filtered" linetype 7 linecolor 6, "../../data/best.randomCD100.tsp" using 1:2 title "best" linetype 7 linecolor 7