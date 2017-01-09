set terminal png
set output "ef_online.png"
set title "randomEF"
plot "randomEFNonFiltered.tsp" using 1:2 title "non filtered" pointtype 7 linecolor 6, "randomEFOnLineFiltered.tsp" using 1:2 title "on-line filtered" pointtype 6 pointsize 2 linecolor 7
