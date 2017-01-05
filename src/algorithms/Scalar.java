package algorithms;

import java.util.ArrayList;
import java.util.List;

import filters.OffLineFilter;
//import filters.OffLineFilter;
import models.Solution;
import models.WeightVector;

public class Scalar {
	
	private int z;
	
	public Scalar(int z) {
		this.z = z;
	}

	public List<Solution> run(Solution randomSol) {
		List<Solution> list = new ArrayList<Solution>();
		OffLineFilter off = new OffLineFilter();
		for (int i = 0; i <= z; i++) {
			WeightVector v = new WeightVector(i/z, z-i/z);
			Solution s = LocalSearch.run(randomSol, v);
			list.add(s);
		}
		off.filter(list);
		return list;
	}

}
