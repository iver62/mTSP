package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Instance {
	
	private int[][] matrix1;
	private int[][] matrix2;
	private int size;
	
	public Instance(int[][] matrix1, int[][] matrix2) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		size = matrix1.length;
	}

	public int[] eval(Solution sol) {
		int[] objectifs = new int[2];
		for (int i = 0; i < size-1; i++) {
			int a = sol.get(i);
			int b = sol.get(i+1);
			objectifs[0] += matrix1[a][b];
			objectifs[1] += matrix2[a][b];
		}
		return objectifs;
	}
	
	public Solution randomSolution() {
		List<Integer> randSol = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			randSol.add(i);
		}
		Collections.shuffle(randSol);
		return new Solution(randSol);
	}
	
	public List<Solution> offLineFilter(List<Solution> solutions) {
		List<Solution> res = new ArrayList<Solution>();
		for (Solution s : solutions) {
			if (!isDominated(s, solutions)) {
				res.add(s);
			}
		}
		return res;
	}

	private boolean isDominated(Solution s, List<Solution> solutions) {
		for (Solution sol : solutions) {
			if (eval(sol)[0] < eval(s)[0] && eval(sol)[1] < eval(s)[1]) {
				return true;
			}
		}
		return false;
	}

	public List<Solution> onLineFilter(Solution sol) {
		List<Solution> res = new ArrayList<Solution>();
		return res;
	}

}
