set title "randomCD"
plot "randomCDNonFiltered.tsp" using 1:2 title "non filtered" linetype 7 linecolor 6, "randomCDOffLineFiltered.tsp" using 1:2 title "filtered" linetype 7 linecolor 7, "../../data/best.randomCD100.tsp" using 1:2 title "best" linetype 7 linecolor 1