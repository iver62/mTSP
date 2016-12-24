package tests;

import utils.MyFileReader;

public class MainInstanceReader {

	public static void main(String[] args) {
		int[][] mA = MyFileReader.read("data/randomA100.tsp", 100);
		int[][] mB = MyFileReader.read("data/randomB100.tsp", 100);
		int[][] mC = MyFileReader.read("data/randomC100.tsp", 100);
		int[][] mD = MyFileReader.read("data/randomD100.tsp", 100);
		int[][] mE = MyFileReader.read("data/randomE100.tsp", 100);
		int[][] mF = MyFileReader.read("data/randomF100.tsp", 100);
		
		print(mA);
		print(mB);
		print(mC);
		print(mD);
		print(mE);
		print(mF);
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
