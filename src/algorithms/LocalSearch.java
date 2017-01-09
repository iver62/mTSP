package algorithms;

import models.Solution;
import models.WeightVector;
//import neighborhood.Insert;
import neighborhood.TwoOpt;

public class LocalSearch {
	
	/**
	 * Lance une rcherche locale de type Hill-Climbing pour une solution initiale. Le vecteur de poids 
	 * sert a transformer un probleme a 2 objectifs en un probleme mono-objectif.
	 * @param sol la solution initiale
	 * @param v le vecteur de poids
	 * @return l'optimum local
	 */
	public static Solution run(Solution sol, WeightVector v) {
		boolean improve = true;
		
		while (improve) { // tant que l'on ameliore la meilleure solution courante		
			Solution cand = TwoOpt.run(sol, v); // le meilleur voisin de la meilleure solution courante
			double weightCand = cand.objectives[0]*v.w1 + cand.objectives[1]*v.w2; // somme ponderee de la solution candidate
			double weigthSol = sol.objectives[0]*v.w1 + sol.objectives[1]*v.w2; // somme ponderee de la meilleure solution courante
			if (weightCand < weigthSol) { // si la somme ponderee de la solution candidate est meilleure
				sol = cand; // la solution candidate devient la meilleure solution courante
				sol.eval();
				improve = true;
			}
			else {
				improve = false; 
			}
		}
		
		return sol;
	}

}
