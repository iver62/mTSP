package algorithms;

import java.util.ArrayList;
import java.util.List;

import filters.OffLineFilter;
import models.Solution;

public class Scalar {
	
	public List<Solution> run(int nbObj, Solution randomSol) {
		List<Solution> archive = new ArrayList<Solution>();
		OffLineFilter off = new OffLineFilter();
		for (int i = 0; i < nbObj; i++) {
			Solution s = LocalSearch.run(randomSol, i);
			archive.add(s);
		}
		off.filter(archive);
		return archive;
	}

}
