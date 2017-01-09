package tests;

import filters.OnLineFilter;
import models.Instance;
import models.Solution;
import utils.MyFileReader;
import utils.MyFileWriter;

public class MainOnLineComparator {

	public static void main(String[] args) {
		
		if (args.length == 3) {
			String filename1 = args[0];
			String filename2 = args[1];
			int nbSolutions = Integer.valueOf(args[2]);
			
			int[][] mX = MyFileReader.read("data/"+filename1, 100);
			int[][] mY = MyFileReader.read("data/"+filename2, 100);
			Instance randomXY100 = new Instance(mX, mY);
			OnLineFilter online = new OnLineFilter();
			
			int cptP = 0, cpt = 0;
			int[] tabP = new int[nbSolutions/10];
			long[] times = new long[nbSolutions/10];
			for (int p = 10; p <= nbSolutions; p+=10) {
				long d = System.currentTimeMillis();
				for (int i = 0; i < p; i++) {
					Solution randSol = randomXY100.randomSolution();
					randSol.eval();
					online.filter(randSol);
				}
				long time = System.currentTimeMillis() - d;
				tabP[cptP++] = p; times[cpt++] = time;
				online.clear();
			}
			
			String target_path = new String("random"+filename1.charAt(6)+filename2.charAt(6));
			MyFileWriter.writeData("res/online/"+target_path+"OnLineFilteredComp.txt", tabP, times);
		}
		
		else {
			System.out.println("Usage : \n\t java -jar online_comp.jar <instance1> <instance2> <nombre de solutions aleatoires>");
		}

	}

}
