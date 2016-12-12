package filters;

import java.util.ArrayList;
import java.util.List;

import models.Solution;

public class OffLine {
	
	public OffLine() { }
	
	public List<Solution> run(List<Solution> solutions) {
		List<Solution> res = new ArrayList<Solution>();
		for (Solution s : solutions) {
			if (!s.isDominated(solutions)) {
				res.add(s);
			}
		}
		return res;
	}

}
