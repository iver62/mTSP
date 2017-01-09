set terminal png
set output "comp.png"
set title "temps de calcul selon le nombre de solutions aléatoires avec le iltre on-line"
set xlabel "nombre de solutions aléatoires"
set ylabel "temps (ms)"
plot "randomABOnLineFilteredComp.txt" using 1:2 with lines title ""
