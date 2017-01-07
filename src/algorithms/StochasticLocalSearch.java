package algorithms;

import java.util.Random;

import models.Solution;
import models.WeightVector;
import neighborhood.TwoOpt;

public class StochasticLocalSearch {
	
//	public static Solution run(Solution sol, WeightVector v) {
//		Solution cand = sol;
////		List<Solution> list = new ArrayList<>();
////		System.out.println(sol);
//		int n = cand.size();
//		boolean improved = true;
//		
//		while (improved) {
//			improved = false;
//			for (int i = 0; i < n-1; i++) {
//				for (int j = i+1; j < n; j++) {
//					cand = twoOptSwap(sol, i, j);
//					cand.eval();
//					if (cand.objectives[0]*v.w1 + cand.objectives[1]*v.w2 < sol.objectives[0]*v.w1 + sol.objectives[1]*v.w2) {
////						System.out.println(sol.objectives[obj] + " -> " + res.objectives[obj]);
//						sol = cand;
////						list.add(res);
//						improved = true;
//					}
//				}
//			}
//		}
////		System.out.println(sol);
////		System.out.println(sol.objectives[0]);
//		return sol;
////		return list;
//	}
	
	public static Solution run(Solution sol, WeightVector v) {
		int nbIterations = 0;
		Random rand = new Random();
		Solution res = sol;
		
		while (nbIterations <= 100) {
			int i = 0, j = 0;
			while (i == j) {
				i = rand.nextInt(sol.size());
			    j = rand.nextInt(sol.size());
			}
			
			Solution cand = TwoOpt.run(res, v);

			double cost1 = cand.objectives[0]*v.w1 + cand.objectives[1]*v.w2; // new cost
			double cost2 = res.objectives[0]*v.w1 + res.objectives[1]*v.w2; // old cost
			if (cost1 < cost2) {
				res = cand;
				nbIterations = 0;
			}
			else {
				nbIterations++;
			}
		}
			
		return res;
	}
	
//	public static Solution twoOpt(Solution sol, WeightVector v) {
//		Solution cand = sol;
////		List<Solution> list = new ArrayList<>();
////		System.out.println(sol);
//		int n = cand.size();
//		boolean improved = true;
//		
//		while (improved) {
//			improved = false;
//			for (int i = 0; i < n-1; i++) {
//				for (int j = i+1; j < n; j++) {
//					cand = twoOptSwap(sol, i, j);
//					cand.eval();
//					if (cand.objectives[0]*v.w1 + cand.objectives[1]*v.w2 < sol.objectives[0]*v.w1 + sol.objectives[1]*v.w2) {
////						System.out.println(sol.objectives[obj] + " -> " + res.objectives[obj]);
//						sol = cand;
////						list.add(res);
//						improved = true;
//					}
//				}
//			}
//		}
////		System.out.println(sol);
////		System.out.println(sol.objectives[0]);
//		return sol;
////		return list;
//	}
//	
//	/**
//	 * Permute les 2 villes aux positions i et j
//	 * @param sol la solution ou il faut permuter les villes
//	 * @param i l'entier a la position i
//	 * @param j l'entier a la position j
//	 * @return la solution avec les villes permutees
//	 */
//	public static Solution twoOptSwap(Solution sol, int i, int j) {
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
