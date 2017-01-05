package tests;

import java.util.ArrayList;
import java.util.List;

import algorithms.ILS;
import algorithms.VND;
import models.Instance;
import models.Solution;
import neighborhood.Insert;
import neighborhood.Interchange;
import neighborhood.Neighborhood;
import neighborhood.Swap;
import utils.MyFileReader;

public class MainILS {

	public static void main(String[] args) {
		int[][] mA = MyFileReader.read("data/randomA100.tsp", 100);
		int[][] mB = MyFileReader.read("data/randomB100.tsp", 100);
		Instance randomAB100 = new Instance(mA, mB);
		Solution sol = randomAB100.randomSolution();
		sol.eval();
		List<Neighborhood> voisinages = new ArrayList<>();
		voisinages.add(new Interchange());
		voisinages.add(new Swap());
		voisinages.add(new Insert());
		VND vnd = new VND(voisinages);
		System.out.println(sol.objectives[0] + " " + sol.objectives[1]);
		vnd.run(sol, 0);
	}

}
