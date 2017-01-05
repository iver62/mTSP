package tests;

import java.util.ArrayList;
import java.util.List;

import algorithms.Scalar;
import filters.OffLineFilter;
import models.Instance;
import models.Solution;
import utils.MyFileReader;
import utils.MyFileWriter;

public class MainScalar {
	
	public static int z = 8;

	public static void main(String[] args) {
		int[][] mA = MyFileReader.read("data/randomA100.tsp", 100);
		int[][] mB = MyFileReader.read("data/randomB100.tsp", 100);
		Instance randomAB100 = new Instance(mA, mB);
		List<Solution> archive = new ArrayList<Solution>();
		OffLineFilter offLine = new OffLineFilter();
		Scalar scalar = new Scalar(z);
		
		for (int i = 0; i < 500; i++) {
			Solution randomSol = randomAB100.randomSolution();
			randomSol.eval();
			archive.addAll(scalar.run(randomSol));
			System.out.println(i+1 + " " + randomSol.objectives[0] + " " + randomSol.objectives[1]);
		}
		
		MyFileWriter.writeData("res/scalar/randomABNonFiltered.tsp", archive);
		MyFileWriter.writeData("res/scalar/randomABOffLineFiltered.tsp", offLine.filter(archive));

	}

}
