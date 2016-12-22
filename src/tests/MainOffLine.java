package tests;

import java.util.ArrayList;
import java.util.List;

import filters.OffLine;
import models.Instance;
import models.Solution;
import utils.MyFileReader;
import utils.MyFileWriter;

public class MainOffLine {
	
	public static void main(String[] args) {
		int[][] mA = MyFileReader.read("data/randomA100.tsp", 100);
		int[][] mB = MyFileReader.read("data/randomC100.tsp", 100);
		List<Solution> solutions = new ArrayList<Solution>();
		Instance randomAB100 = new Instance(mA, mB);
		
		for (int i = 0; i < 500; i++) {
			Solution randSol = randomAB100.randomSolution();
			solutions.add(randSol);
			randSol.eval();
			System.out.println(i+1 + " " + randSol.getObj1() + " " + randSol.getObj2());
		}
		
		MyFileWriter.writeData("randomABNonFiltered.tsp", solutions);
		
		OffLine off = new OffLine();
		MyFileWriter.writeData("randomABOffLineFiltered.tsp", off.run(solutions));					
	}

}
