package algorithms;

import java.util.ArrayList;
import java.util.List;

import models.Solution;
import models.WeightVector;

public class LocalSearch {
	
	public static Solution run(Solution sol, WeightVector v) {
		Solution cand = sol;
//		List<Solution> list = new ArrayList<>();
//		System.out.println(sol);
		int n = cand.size();
		boolean improved = true;
		
		while (improved) {
			improved = false;
			for (int i = 0; i < n-1; i++) {
				for (int j = i+1; j < n; j++) {
					cand = twoOptSwap(sol, i, j);
					cand.eval();
					if (cand.objectives[obj] < sol.objectives[obj]) {
//						System.out.println(sol.objectives[obj] + " -> " + res.objectives[obj]);
						sol = cand;
//						list.add(res);
						improved = true;
					}
				}
			}
		}
//		System.out.println(sol);
//		System.out.println(sol.objectives[0]);
		return sol;
//		return list;
	}
	
	/**
	 * Permute les 2 entiers d'indices i et j
	 * @param i l'entier a la position i
	 * @param j l'entier a la position j
	 */
	public static Solution twoOptSwap(Solution sol, int i, int j) {
		List<Integer> list = new ArrayList<Integer>();
		for (int k = 0; k < i; k++) {
			list.add(sol.get(k));
		}
		for (int k = j; k >= i; k--) {
			list.add(sol.get(k));
		}
		for (int k = j+1; k < sol.size(); k++) {
			list.add(sol.get(k));
		}
		Solution cand = new Solution(sol.instance, list);
		return cand;
	}

}
