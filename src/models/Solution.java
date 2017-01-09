package models;

import java.util.ArrayList;
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
		objectives[0] = 0;
		objectives[1] = 0;
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
	 * @param sol une solution
	 * @return vrai si la solution est dominee, faux sinon
	 */
	public boolean isDominated(Solution sol) {
		if (sol.objectives[0] < objectives[0] && sol.objectives[1] < objectives[1]) {
			return true;
		}
		return false;
	}
	
	/**
	 * Insere la ieme ville a la position j
	 * @param i : la ieme ville
	 * @param j : l'indice ou inserer la ieme ville
	 */
	public void insert(int i, int j) {
		int t = list.get(i);
		list.remove(i);
		list.add(j, t);
	}
	
	/**
	 * Permute deux villes aux positions i et j
	 * @param i : l'indice de la 1ere ville
	 * @param j : l'indice de la 2eme ville
	 */
	public void swap(int i, int j) {
		int t1 = list.get(i);
		int t2 = list.get(j);
		list.remove(j);
		list.add(j, t1);
		list.remove(i);
		list.add(i, t2);
	}
	
	public void kopt(int i, int j) {
		List<Integer> newList = new ArrayList<Integer>();
		for (int k = 0; k < i; k++) {
			newList.add(get(k));
		}
		for (int k = j; k >= i; k--) {
			newList.add(get(k));
		}
		for (int k = j+1; k < size(); k++) {
			newList.add(get(k));
		}
		setList(newList);
	}
	
	public int size() {
		return list.size();
	}
	
	public String toString() {
		return list.toString();
	}
	
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
	
	public void setList(List<Integer> newList) {
		this.list = newList;
	}

}
