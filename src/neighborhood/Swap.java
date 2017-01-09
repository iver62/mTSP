package neighborhood;

import java.util.ArrayList;

import models.Solution;

public class Swap {
	
	/**
	 * Retourne le meilleur voisin d'un ordonnancement selon la methode des permutations.
	 * La strategie est BEST_IMPROVEMENT, on retourne donc le meilleur voisin parmi tous les voisins.
	 * @param sol : une solution a ameliorer
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
			for (int j = i+1; j < n; j++) {
				sol.swap(i, j); // permutation de la ieme et la jieme tache
				sol.eval();
				if (sol.objectives[0] < obj1 && sol.objectives[1] < obj2) {
					res = new Solution(sol.instance, new ArrayList<Integer>(sol.list));
					res.eval();
					obj1 = res.objectives[0];
					obj2 = res.objectives[1];
//					System.out.println(res.objectives[0] + " " + res.objectives[1]);
				}
				sol.swap(j, i);
			}
		}
		return sol;
	}

	@Override
	public String toString() {
		return "SWAP";
	}

}
