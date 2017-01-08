package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import filters.OnLineFilter;
import models.Solution;
import neighborhood.TwoOpt;

public class Pareto {
	
	public static List<Solution> run(int nbMin, List<Solution> allSolutions) {
		OnLineFilter onLine = new OnLineFilter();
		onLine.setArchive(allSolutions);
		Random rand = new Random();
		long deb = System.currentTimeMillis();
		
		while (System.currentTimeMillis() - deb < nbMin * 60000) {
			int i = rand.nextInt(allSolutions.size());
			Solution best = TwoOpt.run(allSolutions.get(i));
			onLine.filter(best);
		}
		
		return onLine.getArchive();
	}

}
