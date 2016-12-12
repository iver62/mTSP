package tests;

import filters.OnLine;
import models.Instance;
import models.Solution;
import utils.MyFileReader;
import utils.MyFileWriter;

public class MainOnLine {
	
	public static int P = 500;
	
	public static void main(String[] args) {
		int[][] mA = MyFileReader.read("data/randomA100.tsp", 100);
		int[][] mB = MyFileReader.read("data/randomC100.tsp", 100);
		Instance randomAB100 = new Instance(mA, mB);
		
		OnLine on = new OnLine();
		
		for (int i = 0; i < P; i++) {
			Solution randSol = randomAB100.randomSolution();
			randSol.eval();
			on.run(randSol);
		}
		
		MyFileWriter.writeData("data/randomABFilteredOnLine.tsp", on.getArchive());
	}

}
