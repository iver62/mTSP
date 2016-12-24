package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import models.Solution;

public class MyFileWriter {
	
	public static void writeData(String filename, List<Solution> solutions) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			for (Solution s : solutions) {
				bw.write(s.objectives[0] + " " + s.objectives[1]);
				bw.newLine();
			}
			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeData(String filename, int[] nbSolutions, long[] times) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			for (int i = 0; i < nbSolutions.length; i++) {
				bw.write(nbSolutions[i] + " " + times[i]);
				bw.newLine();
			}
			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
