package algorithms;

import models.Solution;
import neighborhood.Insert;

public class HillClimbing {
	
	/**
	 * Lance l'algorithme Hill-Climbing selon différents paramètres : la strategie de selection, le voisinage et la solution initiale.
	 * @return l'optimum local
	 */
	public Solution run(Solution sol, int obj) {
		
		boolean improve = true;
		
		while (improve) { // tant qu'on ameliore la solution

			Solution cand = new Insert().run(sol); // le meilleur voisin de la solution courante selon la strategie
			cand.eval();
//			if (cand.eval() >= sol.eval()) { // si la solution candidate n'est pas meilleure
//				improve = false; // pas d'amelioration
//			}
//			else { // sinon
//				sol = cand; // la solution candidate devient la solution
//			}
			if (cand.objectives[obj] < sol.objectives[obj]) {
				sol = cand;
			}
			else {
				improve = false;
			}
			
		}
				
		return sol;
	}

}
