package tests;

import models.Instance;
import models.Solution;
import models.WeightVector;
import neighborhood.TwoOpt;
import utils.MyFileReader;

public class Main2Opt {

	public static void main(String[] args) {
		int[][] mA = MyFileReader.read("data/randomA100.tsp", 100);
		int[][] mB = MyFileReader.read("data/randomB100.tsp", 100);
		Instance randomAB100 = new Instance(mA, mB);
		Solution randomSol = randomAB100.randomSolution();
		randomSol.eval();
		System.out.println(randomSol.objectives[0] + " " + randomSol.objectives[1]);
		Solution res = TwoOpt.run(randomSol, new WeightVector(0.1, 0.9));
		System.out.println(res.objectives[0] + " " + res.objectives[1]);
	}

}
