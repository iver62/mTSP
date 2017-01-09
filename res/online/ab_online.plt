set terminal png
set output "ab_online.png"
set title "randomAB"
plot "randomABNonFiltered.tsp" using 1:2 title "non filtered" pointtype 7 linecolor 6, "randomABOnLineFiltered.tsp" using 1:2 title "on-line filtered" pointtype 6 pointsize 2 linecolor 7
