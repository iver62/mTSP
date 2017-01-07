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
	
	public static void main(String[] args) {
		
		if (args.length == 3) {
			String path1 = "data/"+args[0];
			String path2 = "data/"+args[1];
			int z = Integer.valueOf(args[2]);
			
			int[][] mA = MyFileReader.read(path1, 100);
			int[][] mB = MyFileReader.read(path2, 100);
			Instance randomAB100 = new Instance(mA, mB); 
			List<Solution> archive = new ArrayList<Solution>();
			OffLineFilter offLine = new OffLineFilter();
			
			System.out.println("Running...");
			
			for (int i = 0; i < 500; i++) {
				Solution randomSol = randomAB100.randomSolution();
				randomSol.eval();
//				System.out.println(i+1 + " " + randomSol.objectives[0] + " " + randomSol.objectives[1]);
				archive.addAll(Scalar.run(randomSol, z));
				System.out.println(i+1 + "/500");
//				System.out.println(i+1 + " " + randomSol.objectives[0] + " " + randomSol.objectives[1]);
			}
			
			MyFileWriter.writeData("res/scalar/randomABNonFiltered.tsp", archive); 
			MyFileWriter.writeData("res/scalar/randomABOffLineFiltered.tsp", offLine.filter(archive));
			
			System.out.println("Done");
		}
		
		else {
			System.out.println("Usage : \n\t java -jar scalar.jar <instance1> <instance2> <z>");
		}

	}

}
