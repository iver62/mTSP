package models;

import java.util.List;

public class Solution {
	
	public int[] objectives;
	public Instance instance;
	public List<Integer> list;

	public Solution(Instance instance, List<Integer> list) {
		this.instance = instance;
		this.list = list;
		objectives = new int[2];
	}
	
	public void eval() {
		for (int i = 0; i < list.size()-1; i++) {
			int a = list.get(i);
			int b = list.get(i+1);
			objectives[0] += instance.matrix1[a][b];
			objectives[1] += instance.matrix2[a][b];
		}
		objectives[0] += instance.matrix1[list.size()-1][list.get(0)];
		objectives[1] += instance.matrix2[list.size()-1][list.get(0)];
	}
	
	/**
	 * Teste si la solution est dominee par une des solutions de la liste
	 * @param solutions une liste de solutions
	 * @return true si la solution est dominee, faux sinon
	 */
	public boolean isDominated(List<Solution> solutions) {
		for (Solution sol : solutions) {
			if (isDominated(sol)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Teste si la solution est dominee par une autre solution
	 * @param sol une slution
	 * @return vrai si la solution est dominee, faux sinon
	 */
	public boolean isDominated(Solution sol) {
		if (sol.objectives[0] < objectives[0] && sol.objectives[1] < objectives[1]) {
			return true;
		}
		return false;
	}
	
	public int size() {
		return list.size();
	}
	
	public String toString() {
		return list.toString();
	}
	
//	/**
//	 * Supprime l'element  a l'indice i
//	 * @param i l'indice
//	 */
//	public void remove(int i) {
//		sol.remove(i);
//	}
//	
//	/**
//	 * Ajoute l'entier x a l'indice i
//	 * @param i l'indice
//	 * @param x l'entier a ajouter
//	 */
//	public void add(int i, int x) {
//		sol.add(i, x);
//	}
	
	/**
	 * Remplace l'entier a l'indice i par l'entier x
	 * @param i l'indice
	 * @param x l'entier
	 */
	public void set(int i, int x) {
		list.set(i, x);
	}
	
	public int get(int i) {
		return list.get(i);
	}

//	public List<Integer> getSol() {
//		return list;
//	}

//	public int getObj1() {
//		return obj1;
//	}
//
//	public int getObj2() {
//		return obj2;
//	}

//	public Instance getInstance() {
//		return instance;
//	}

}
