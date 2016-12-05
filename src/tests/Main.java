package tests;

import java.util.ArrayList;
import java.util.List;

import models.Instance;
import models.Solution;
import utils.MyFileReader;
import utils.MyFileWriter;

public class Main {

	public static void main(String[] args) {
		int[][] mA = MyFileReader.read("data/randomA100.tsp", 100);
		int[][] mB = MyFileReader.read("data/randomC100.tsp", 100);
		List<Solution> solutions = new ArrayList<Solution>();
		Instance randomAB100 = new Instance(mA, mB);
		
//		int[] res = new int[2];
		for (int i = 0; i < 500; i++) {
			Solution randSol = randomAB100.randomSolution();
			solutions.add(randSol);
			System.out.println(i+1 + " " + randomAB100.eval(randSol)[0] + " " + randomAB100.eval(randSol)[1]);
		}
		
		MyFileWriter.writeData("data/randomABnonFiltered", randomAB100, solutions);
		List<Solution> filteredSolutions = randomAB100.offLineFilter(solutions);
		MyFileWriter.writeData("data/randomABFiltered", randomAB100, filteredSolutions);
		
	}

}
