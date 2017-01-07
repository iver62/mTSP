package neighborhood;

import models.Solution;
import models.WeightVector;

public class TwoOpt {
	
	public static Solution run(Solution initSol, WeightVector v) {
		Solution res = initSol; // au debut le meilleur voisin est la solution initiale
//		List<Solution> list = new ArrayList<>();
//		System.out.println(sol);
		int n = res.size();
		boolean improved = true;
		
		while (improved) {
			improved = false;
			for (int i = 0; i < n-1; i++) {
				for (int j = i+1; j < n; j++) {
					Solution cand = new Solution(res.instance, res.list);
					cand.kopt(i, j);
					cand.eval();
					if (cand.objectives[0]*v.w1 + cand.objectives[1]*v.w2 < res.objectives[0]*v.w1 + res.objectives[1]*v.w2) {
//						System.out.println(sol.objectives[obj] + " -> " + res.objectives[obj]);
						res = cand;
//						list.add(res);
						improved = true;
					}
				}
			}
		}
//		System.out.println(sol);
//		System.out.println(sol.objectives[0]);
		return res;
//		return list;
	}
	
//	/**
//	 * Permute les 2 villes aux positions i et j
//	 * @param sol la solution ou il faut permuter les villes
//	 * @param i l'entier a la position i
//	 * @param j l'entier a la position j
//	 * @return la solution avec les villes permutees
//	 */
//	private static Solution swap(Solution sol, int i, int j) {
////		List<Integer> list = new ArrayList<Integer>();
//		List<Integer> list = sol.list;
//		for (int k = 0; k < i; k++) {
//			list.add(sol.get(k));
//		}
//		for (int k = j; k >= i; k--) {
//			list.add(sol.get(k));
//		}
//		for (int k = j+1; k < sol.size(); k++) {
//			list.add(sol.get(k));
//		}
//		Solution res = new Solution(sol.instance, list);
//		return res;
//	}

}
