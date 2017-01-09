set terminal png
set output "ef_offline.png"
set title "randomEF"
plot "randomEFNonFiltered.tsp" using 1:2 title "non filtered" pointtype 7 linecolor 6, "randomEFOffLineFiltered.tsp" using 1:2 title "off-line filtered" pointtype 6 pointsize 2 linecolor 7
