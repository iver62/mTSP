package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MyFileReader {
	
	public static int[][] read(String filename, int size) {
		int[][] matrix = new int[size][size];
		
		try {
			File f = new File (filename);
			FileReader fr = new FileReader(f);
			Scanner sc = new Scanner(fr);
			
			int i = -1, j = 0;
			int n;
			
			while (sc.hasNextInt()) {
				n = sc.nextInt();
				
				if (n == 0) {
					i++;
					j = i;
				}
				
				matrix[i][j] = n;
				matrix[j][i] = n;
				
				j++;
			}
			
			sc.close();
		}
		
		catch (FileNotFoundException exception) {
		    System.out.println("Le fichier n'a pas ete trouve");
		}
		return matrix;
	}

}
