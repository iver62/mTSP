set terminal png
set output "cd_offline.png"
set title "randomCD"
plot "randomCDNonFiltered.tsp" using 1:2 title "non filtered" pointtype 7 linecolor 6, "randomCDOffLineFiltered.tsp" using 1:2 title "off-line filtered" pointtype 6 pointsize 2 linecolor 7
