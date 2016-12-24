set title "temps de calcul selon le nombre de solutions aléatoires"
set xlabel "nombre de solutions aléatoires"
set ylabel "temps (ms)"
plot "randomABOnLineFilteredComp.txt" using 1:2 with lines