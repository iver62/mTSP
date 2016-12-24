package filters;

import java.util.ArrayList;
import java.util.List;

import models.Solution;

public class OffLineFilter {
	
	private List<Solution> res;
	
	public OffLineFilter() {
		res = new ArrayList<Solution>();
	}
	
	public List<Solution> filter(List<Solution> solution) {
		
		for (Solution s : solution) {
			if (!s.isDominated(solution)) {
				res.add(s);
			}
		}
		return res;
	}

}