package algorithms;

import java.util.List;

import models.Solution;
import neighborhood.Neighborhood;

public class VND {
	
	private List<Neighborhood> voisinages; // liste des voisinages
	
	public VND(List<Neighborhood> voisinages) {
		this.voisinages = voisinages;
	}
	
	/**
	 * Lance l'algorithme VND
	 * @param sol la solution sur laquelle l'algorithme est lance
	 * @return l'optimum local des k voisinages 
	 */
	public Solution run(Solution sol, int obj) {
		int k = 0, i = 0;
		Solution cand = null;
		int bestObj = sol.objectives[obj];
				
		while (k < sol.size()) { // on sort de la boucle si on a effectue nombre_de_villes iterations sans amelioration
			Neighborhood ngb = voisinages.get(i); // le voisinage courant
			cand = ngb.run(sol); // le meilleur voisin de la solution courante dans le voisinage courant
			cand.eval();
			 
			System.out.println(cand.objectives[0] + " " + cand.objectives[1]);
			
			if (cand.objectives[obj] < bestObj) {
				sol = cand; // nouvel optimum local dans le voisinage courant
				bestObj = cand.objectives[0];
				k = 0; // une meilleure solution a ete trouvee k est reinitialise
				i = 0; // on revient au premier voisinage
			}
			
			else {
				i = (++i < voisinages.size()) ? i : 0; // on passe au voisinage suivant
				k++; // pas d'amelioration k est incremente
			}
			
		}
		return cand;
	}

}
