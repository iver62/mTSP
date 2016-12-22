package tests;

import utils.MyFileReader;

public class MainInstanceReader {

	public static void main(String[] args) {
		int[][] mA = MyFileReader.read("data/randomA100.tsp", 100);
		print(mA);
		int[][] mB = MyFileReader.read("data/randomC100.tsp", 100);

	}
	
	public static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

}
