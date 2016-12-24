package algorithms;

import java.util.ArrayList;
import java.util.List;

import models.Solution;

public class LocalSearch {
	
	public static Solution run(Solution sol, int obj) {
		Solution res = sol;
//		System.out.println(sol);
		int n = res.size();
		boolean improved = true;
		
		while (improved) {
			improved = false;
			for (int i = 0; i < n-1; i++) {
				for (int j = i+1; j < n; j++) {
					res = twoOptSwap(sol, i, j);
					res.eval();
					if (res.objectives[obj] < sol.objectives[obj]) {
//						System.out.println(sol.objectives[obj] + " -> " + res.objectives[obj]);
						sol = res;
						improved = true;
					}
				}
			}
		}
//		System.out.println(sol);
//		System.out.println(sol.objectives[0]);
		return sol;
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
