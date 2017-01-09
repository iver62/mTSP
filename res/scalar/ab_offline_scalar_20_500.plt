set terminal png
set output "ab_offline_10_500.png"
set title "randomAB approche scalaire pour 500 solutions aléatoires et z = 20"
plot "randomAB_OffLineFiltered_z=20_nb=500.tsp" using 1:2 title "scalar" pointtype 7 linecolor 6, "../../data/best.randomAB100.tsp" using 1:2 title "best" pointtype 7 linecolor 7
