package neighborhood;

import models.Solution;
import models.WeightVector;

public class TwoOpt {
	
	/**
	 * Recherche le meilleur voisin d'une solution selon l'operateur de voisinage 2-opt. Le vecteur de poids
	 * sert a transformer un probleme a 2 objectifs en un probleme mono-objectif.
	 * @param sol la solution a ameliorer
	 * @param v le vecteur de poids
	 * @return le meilleur voisin
	 */
	public static Solution run(Solution sol, WeightVector v) {
		Solution res = new Solution(sol.instance, sol.list); // au debut le meilleur voisin est la solution initiale
		res.eval();
		int n = sol.size(); // la taille de la solution (le nombre de villes)
		
		for (int i = 0; i < n-1; i++) {
			for (int j = i+1; j < n; j++) {
				sol.kopt(i, j);
				sol.eval();
//				if (res.isDominated(sol)) {
				if (sol.objectives[0]*v.w1 + sol.objectives[1]*v.w2 < res.objectives[0]*v.w1 + res.objectives[1]*v.w2) { // si la somme ponderee des objectifs de la solution candidate est meilleure que la somme ponderee des objectifs de la meilleure solution courante
					res = new Solution(sol.instance, sol.list); // la solution candidate devient la meilleure solution
					res.eval();
				}
				sol.kopt(i, j);
				sol.eval();
			}
		}
		
		return res;
	}

}
