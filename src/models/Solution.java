package models;

import java.util.List;

public class Solution {
	
	private int obj1, obj2;
	private Instance inst;
	private List<Integer> sol;

	public Solution(Instance inst, List<Integer> sol) {
		this.inst = inst;
		this.sol = sol;
	}
	
	public void eval() {
		for (int i = 0; i < sol.size()-1; i++) {
			int a = sol.get(i);
			int b = sol.get(i+1);
			obj1 += inst.matrix1[a][b];
			obj2 += inst.matrix2[a][b];
		}
	}
	
	public boolean isDominated(List<Solution> solutions) {
		for (Solution sol : solutions) {
			if (sol.getObj1() < obj1 && sol.getObj2() < obj2) {
				return true;
			}
		}
		return false;
	}
	
	public int get(int i) {
		return sol.get(i);
	}

	public List<Integer> getSol() {
		return sol;
	}

	public int getObj1() {
		return obj1;
	}

	public int getObj2() {
		return obj2;
	}
	

}
