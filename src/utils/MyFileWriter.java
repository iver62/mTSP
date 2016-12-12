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
				bw.write(s.getObj1() + " " + s.getObj2());
				bw.newLine();
			}
			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
