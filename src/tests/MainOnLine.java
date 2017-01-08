package tests;

import java.util.ArrayList;
import java.util.List;

import filters.OnLineFilter;
import models.Instance;
import models.Solution;
import utils.MyFileReader;
import utils.MyFileWriter;

public class MainOnLine {
		
	public static void main(String[] args) {
		
		if (args.length == 3) {
			String filename1 = args[0];
			String filename2 = args[1];
			int nbSolutions = Integer.valueOf(args[2]);
			int[][] mX = MyFileReader.read("data/"+filename1, 100);
			int[][] mY = MyFileReader.read("data/"+filename2, 100);
			List<Solution> allSolutions = new ArrayList<Solution>();
			Instance randomXY100 = new Instance(mX, mY);
			OnLineFilter online = new OnLineFilter();
			
			for (int i = 0; i < nbSolutions; i++) {
				Solution randSol = randomXY100.randomSolution();
				randSol.eval();
				online.filter(randSol);
				allSolutions.add(randSol);
			}
			
			String target_path = new String("random"+filename1.charAt(6)+filename2.charAt(6));
			MyFileWriter.writeData("res/online/"+target_path+"NonFiltered.tsp", allSolutions);
			MyFileWriter.writeData("res/online/"+target_path+"OnLineFiltered.tsp", online.getArchive());
		}
		
		else {
			System.out.println("Usage : \n\t java -jar online.jar <instance1> <instance2> <nombre de solutions>");
		}
		
	}

}
