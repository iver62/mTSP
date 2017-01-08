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
		
		if (args.length == 3) {
			String filename1 = args[0];
			String filename2 = args[1];
			int nbSolutions = Integer.valueOf(args[2]);
			int[][] mX = MyFileReader.read("data/"+filename1, 100);
			int[][] mY = MyFileReader.read("data/"+filename2, 100);
			List<Solution> solutions = new ArrayList<Solution>();
			Instance randomXY100 = new Instance(mX, mY);

			for (int i = 0; i < nbSolutions; i++) {
				Solution randSol = randomXY100.randomSolution();
				solutions.add(randSol);
				randSol.eval();
			}
			
			String target_path = new String("random"+filename1.charAt(6)+filename2.charAt(6));
			MyFileWriter.writeData("res/offline/"+target_path+"NonFiltered.tsp", solutions);
			MyFileWriter.writeData("res/offline/"+target_path+"OffLineFiltered.tsp", OffLineFilter.filter(solutions));
		}
		
		else {
			System.out.println("Usage : \n\t java -jar offline.jar <instance1> <instance2> <nombre de solutions aleatoires>");
		}

	}

}
