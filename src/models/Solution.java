package models;

import java.util.List;

public class Solution {
	
	private List<Integer> sol;

	public Solution(List<Integer> sol) {
		this.sol = sol;
	}
	
	public int get(int i) {
		return sol.get(i);
	}

	public List<Integer> getSol() {
		return sol;
	}

}
