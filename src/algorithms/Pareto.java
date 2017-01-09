package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import filters.OnLineFilter;
import models.Solution;
import models.WeightVector;
import neighborhood.TwoOpt;

public class Pareto {
	
	public static List<Solution> run(int nbMin, List<Solution> allSolutions, int z) {
		OnLineFilter onLine = new OnLineFilter();
		onLine.setArchive(allSolutions);
		Random rand = new Random();
		List<WeightVector> vectors = new ArrayList<WeightVector>();
		
		for (int i = 0; i <= z; i++) { // pour chaque vecteur de poids
			double w1 = (double)i/z;
			double w2 = 1-w1;
			vectors.add(new WeightVector(w1, w2));
		}
			
		long deb = System.currentTimeMillis();		
		
		while (System.currentTimeMillis() - deb < nbMin * 60000) {
			int i = rand.nextInt(allSolutions.size());
			WeightVector v = vectors.get(rand.nextInt(vectors.size()));
			Solution best = TwoOpt.run(allSolutions.get(i), v);
			onLine.filter(best);
		}
		
		return onLine.getArchive();
	}

}
