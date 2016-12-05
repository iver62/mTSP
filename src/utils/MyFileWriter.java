package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import models.Instance;
import models.Solution;

public class MyFileWriter {
	
	public static void writeData(String filename, Instance inst, List<Solution> solutions) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			for (Solution s : solutions) {
				bw.write(inst.eval(s)[0] + " " + inst.eval(s)[1]);
				bw.newLine();
			}
			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeData(String filename, int a, int b, Boolean bool) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			bw.write(a + " " + b);
			bw.newLine();
			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
