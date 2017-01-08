package tests;

import java.util.ArrayList;
import java.util.List;

import algorithms.Pareto;
import models.Instance;
import models.Solution;
import utils.MyFileReader;
import utils.MyFileWriter;

public class MainPareto {

	public static void main(String[] args) {
		
		if (args.length == 4) {
			String filename1 = args[0];
			String filename2 = args[1];
			int nbMin = Integer.valueOf(args[2]);
			int nbSolutions = Integer.valueOf(args[3]);
			
			int[][] mX = MyFileReader.read("data/"+filename1, 100);
			int[][] mY = MyFileReader.read("data/"+filename2, 100);
			Instance randomXY100 = new Instance(mX, mY); 
			List<Solution> solutions = new ArrayList<Solution>();
			
			System.out.println("Running...");
			
			for (int i = 0; i < nbSolutions; i++) {
				Solution randomSol = randomXY100.randomSolution();
				randomSol.eval();
				solutions.add(randomSol);
			}
			
			String target_path = new String("random"+filename1.charAt(6)+filename2.charAt(6));
//			MyFileWriter.writeData("res/pareto/"+target_path+"_NonFiltered_nb="+nbSolutions+".tsp", archive);
			MyFileWriter.writeData("res/scalar/"+target_path+"_OnLineFiltered_time="+nbMin+"_nb="+nbSolutions+".tsp", Pareto.run(nbMin, solutions));
			
			System.out.println("Done");
		}
		
		else {
			System.out.println("Usage : \n\t java -jar scalar.jar <instance1> <instance2> <nombre de minutes> <nombre de solutions aleatoires>");
		}

	}

}
