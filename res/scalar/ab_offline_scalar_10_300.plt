set terminal png
set output "ab_offline_10_300.png"
set title "randomAB approche scalaire pour 300 solutions aléatoires et z = 10"
plot "randomAB_OffLineFiltered_z=10_nb=300.tsp" using 1:2 title "scalar" pointtype 7 linecolor 6, "../../data/best.randomAB100.tsp" using 1:2 title "best" pointtype 7 linecolor 7
