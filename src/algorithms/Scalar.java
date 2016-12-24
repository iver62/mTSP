package algorithms;

import java.util.ArrayList;
import java.util.List;

//import filters.OffLineFilter;
import models.Solution;

public class Scalar {
	
	public static List<Solution> run(int nbObj, Solution randomSol) {
		List<Solution> list = new ArrayList<Solution>();
//		OffLineFilter off = new OffLineFilter();
		for (int i = 0; i < nbObj; i++) {
			Solution s = LocalSearch.run(randomSol, i);
			list.add(s);
		}
//		off.filter(archive);
		return list;
	}

}
