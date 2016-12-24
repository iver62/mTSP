package tests;

import java.util.ArrayList;
import java.util.List;

import filters.OffLineFilter;
import models.Instance;
import models.Solution;
import utils.MyFileReader;
import utils.MyFileWriter;

public class MainOffLine {
	
	public static void main(String[] args) {
		int[][] mA = MyFileReader.read("data/randomA100.tsp", 100);
		int[][] mB = MyFileReader.read("data/randomB100.tsp", 100);
		int[][] mC = MyFileReader.read("data/randomC100.tsp", 100);
		int[][] mD = MyFileReader.read("data/randomD100.tsp", 100);
		int[][] mE = MyFileReader.read("data/randomE100.tsp", 100);
		int[][] mF = MyFileReader.read("data/randomF100.tsp", 100);
		List<Solution> solutions = new ArrayList<Solution>();
		Instance randomAB100 = new Instance(mA, mB);
		Instance randomCD100 = new Instance(mC, mD);
		Instance randomEF100 = new Instance(mE, mF);
		
		for (int i = 0; i < 500; i++) {
			Solution randSol = randomAB100.randomSolution();
			solutions.add(randSol);
			randSol.eval();
			System.out.println(i+1 + " " + randSol.objectives[0] + " " + randSol.objectives[1]);
		}
		
		MyFileWriter.writeData("res/offline/randomABNonFiltered.tsp", solutions);
		OffLineFilter off = new OffLineFilter();
		MyFileWriter.writeData("res/offline/randomABOffLineFiltered.tsp", off.filter(solutions));
		
		solutions.clear();
		for (int i = 0; i < 500; i++) {
			Solution randSol = randomCD100.randomSolution();
			solutions.add(randSol);
			randSol.eval();
			System.out.println(i+1 + " " + randSol.objectives[0] + " " + randSol.objectives[1]);
		}
		
		MyFileWriter.writeData("res/offline/randomCDNonFiltered.tsp", solutions);
		off = new OffLineFilter();
		MyFileWriter.writeData("res/offline/randomCDOffLineFiltered.tsp", off.filter(solutions));
		
		solutions.clear();
		for (int i = 0; i < 500; i++) {
			Solution randSol = randomEF100.randomSolution();
			solutions.add(randSol);
			randSol.eval();
			System.out.println(i+1 + " " + randSol.objectives[0] + " " + randSol.objectives[1]);
		}
		
		MyFileWriter.writeData("res/offline/randomEFNonFiltered.tsp", solutions);
		off = new OffLineFilter();
		MyFileWriter.writeData("res/offline/randomEFOffLineFiltered.tsp", off.filter(solutions));

	}

}
