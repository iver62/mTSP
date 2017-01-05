package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Solution;
import neighborhood.Insert;
import neighborhood.Interchange;
import neighborhood.Neighborhood;
import neighborhood.Swap;

public class ILS {
	
	private List<Neighborhood> neighbors;
	private VND vnd;
	
	public ILS() {
		neighbors = new ArrayList<Neighborhood>();
		neighbors.add(new Interchange());
		neighbors.add(new Swap());
		neighbors.add(new Insert());
		vnd = new VND(neighbors);
	}

	public Solution run(Solution sol, int obj) {
		Solution tmp = vnd.run(sol, obj);
		System.out.println(tmp.objectives[0] + tmp.objectives[1]);
		int j, k;
		Random rand = new Random();
		Solution res = null;
		int nbIter = 1000;

		while (nbIter > 0) {
			// Perturbation
			k = rand.nextInt(sol.size());
			j = rand.nextInt(sol.size());

			tmp.kopt(j, k);
			tmp.eval();

			// Local Search
			res = vnd.run(tmp, obj);
			res.eval();

			if (res.objectives[obj] < tmp.objectives[obj]) {
				res = tmp;
				nbIter = 1000;
			}
			else {
				nbIter--;
			}
		}
		System.out.println(tmp.objectives[0] + tmp.objectives[1]);
		return res;
	}

}
