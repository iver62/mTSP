package tests;

import filters.OnLineFilter;
import models.Instance;
import models.Solution;
import utils.MyFileReader;
import utils.MyFileWriter;

public class MainOnLine {
	
	public static int maxP = 500;
	
	public static void main(String[] args) {
		int[][] mA = MyFileReader.read("data/randomA100.tsp", 100);
		int[][] mB = MyFileReader.read("data/randomB100.tsp", 100);
		int[][] mC = MyFileReader.read("data/randomC100.tsp", 100);
		int[][] mD = MyFileReader.read("data/randomD100.tsp", 100);
		int[][] mE = MyFileReader.read("data/randomE100.tsp", 100);
		int[][] mF = MyFileReader.read("data/randomF100.tsp", 100);
		Instance randomAB100 = new Instance(mA, mB);
		Instance randomCD100 = new Instance(mC, mD);
		Instance randomEF100 = new Instance(mE, mF);
		
		OnLineFilter on;
		
		int cptP = 0, cpt = 0;
		int[] tabP = new int[maxP];
		long[] times = new long[maxP];
		for (int p = 1; p <= maxP; p++) {
			on = new OnLineFilter();
			long d = System.currentTimeMillis();
			for (int i = 0; i < p; i++) {
				Solution randSol = randomAB100.randomSolution();
				randSol.eval();
				on.filter(randSol);
			}
			long time = System.currentTimeMillis() - d;
			tabP[cptP++] = p; times[cpt++] = time;
			MyFileWriter.writeData("res/online/randomABOnLineFiltered.tsp", on.getArchive());
		}
		MyFileWriter.writeData("res/online/randomABOnLineFilteredComp.txt", tabP, times);
		
		on = new OnLineFilter();
		for (int i = 0; i < maxP; i++) {
			Solution randSol = randomCD100.randomSolution();
			randSol.eval();
			on.filter(randSol);
		}
		MyFileWriter.writeData("res/online/randomCDOnLineFiltered.tsp", on.getArchive());
		
		on = new OnLineFilter();
		for (int i = 0; i < maxP; i++) {
			Solution randSol = randomEF100.randomSolution();
			randSol.eval();
			on.filter(randSol);
		}
		MyFileWriter.writeData("res/online/randomEFOnLineFiltered.tsp", on.getArchive());
	}

}
