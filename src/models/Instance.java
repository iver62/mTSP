package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Instance {
	
	public int[][] matrix1;
	public int[][] matrix2;
	private int size;
	
	public Instance(int[][] matrix1, int[][] matrix2) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		size = matrix1.length;
	}
	
	public Solution randomSolution() {
		List<Integer> randSol = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			randSol.add(i);
		}
		Collections.shuffle(randSol);
		return new Solution(this, randSol);
	}

}
