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
		
		if (args.length == 4) {
			String filename1 = args[0];
			String filename2 = args[1];
			int z = Integer.valueOf(args[2]);
			int nbSolutions = Integer.valueOf(args[3]);
			
			int[][] mX = MyFileReader.read("data/"+filename1, 100);
			int[][] mY = MyFileReader.read("data/"+filename2, 100);
			Instance randomXY100 = new Instance(mX, mY); 
			List<Solution> archive = new ArrayList<Solution>();
			List<Solution> randomSolutions = new ArrayList<Solution>();
			
			System.out.println("Running...");
			
			for (int i = 0; i < nbSolutions; i++) {
				Solution randomSol = randomXY100.randomSolution();
				randomSolutions.add(randomSol);
				randomSol.eval();
				archive.addAll(Scalar.run(randomSol, z));
				System.out.println(i+1+"/"+nbSolutions);
			}
			
			String target_path = new String("random"+filename1.charAt(6)+filename2.charAt(6));
			MyFileWriter.writeData("res/scalar/"+target_path+"_OffLineFiltered_z="+z+"_nb="+nbSolutions+".tsp", OffLineFilter.filter(archive));
			
			System.out.println("Done");
		}
		
		else {
			System.out.println("Usage : \n\t java -jar scalar.jar <instance1> <instance2> <z> <nombre de solutions aleatoires>");
		}

	}

}
