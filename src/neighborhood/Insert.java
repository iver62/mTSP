package neighborhood;

import models.Solution;
import models.WeightVector;

public class Insert {
	
	/**
	 * Retourne le meilleur voisin d'un ordonnancement selon la methode des insertions. 
	 * La strategie est BEST_IMPROVEMENT, on retourne donc le meilleur voisin parmi tous les voisins.
	 * @param sol une solution a ameliorer
	 * @return le meilleur voisin
	 */
	public static Solution run(Solution sol, WeightVector v) {
		Solution res = new Solution(sol.instance, sol.list); // au debut le meilleur voisin est la solution initiale
		res.eval();
		int n = sol.size(); // le nombre de villes de la solution
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					sol.insert(i, j);
					sol.eval();
					if (sol.objectives[0]*v.w1 + sol.objectives[1]*v.w2 < res.objectives[0]*v.w1 + res.objectives[1]*v.w2) {
						res = new Solution(sol.instance, sol.list);
						res.eval();
					}
					sol.insert(j, i);
					sol.eval();
				}
			}
		}
		return res;
	}

	@Override
	public String toString() {
		return "INSERT";
	}

}
