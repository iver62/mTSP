package neighborhood;

import java.util.ArrayList;

import models.Solution;

public class Insert extends Neighborhood {
	
	/**
	 * Retourne le meilleur voisin d'un ordonnancement selon la methode des insertions. 
	 * La strategie est BEST_IMPROVEMENT, on retourne donc le meilleur voisin parmi tous les voisins.
	 * @param sol une solution a ameliorer
	 * @return le meilleur voisin
	 */
	public Solution run(Solution sol) {
		int n = sol.size(); // le nombre de villes de la solution
		sol.eval(); // evaluation de la solution initiale
		
		int obj1 = sol.objectives[0];
		int obj2 = sol.objectives[1];
//		System.out.println(obj1 + " " + obj2);
		Solution res = new Solution(sol.instance, new ArrayList<Integer>(sol.list)); // au debut le meilleur voisin correspond a la solution initiale
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					sol.insert(i, j);
					sol.eval();
					if (sol.objectives[0] < obj1 && sol.objectives[1] < obj2) {
						res = new Solution(sol.instance, new ArrayList<Integer>(sol.list));
						res.eval();
						obj1 = res.objectives[0];
						obj2 = res.objectives[1];
//						System.out.println(res.objectives[0] + " " + res.objectives[1]);
					}
					sol.insert(j, i);
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
