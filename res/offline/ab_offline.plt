set terminal png
set output "ab_offline.png"
set title "randomAB"
plot "randomABNonFiltered.tsp" using 1:2 title "non filtered" pointtype 7 linecolor 6, "randomABOffLineFiltered.tsp" using 1:2 title "off-line filtered" pointtype 6 pointsize 2 linecolor 7
