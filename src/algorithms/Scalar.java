package algorithms;

import java.util.ArrayList;
import java.util.List;

import models.Solution;
import models.WeightVector;

public class Scalar {

	/**
	 * Approche scalaire : pour chaque vecteur de poids on retourne une solution grace a un algorithme
	 * de recherche locale de type HillClimbing. A la fin la liste contenant toutes les solutions est 
	 * retournee, soit z+1 solutions pour un probleme a 2 objectifs.
	 * @param randomSol une solution aleatoire 
	 * @param z parametre qui determine le nombre de vecteurs de poids
	 * @return liste des solutions
	 */
	public static List<Solution> run(Solution randomSol, int z) {
		List<Solution> allSolutions = new ArrayList<Solution>();
//		OffLineFilter off = new OffLineFilter();
		for (int i = 0; i <= z; i++) { // pour chaque vecteur de poids
			double w1 = (double)i/z;
			double w2 = 1-w1;
//			System.out.println(w1 + " " + w2);
			WeightVector v = new WeightVector(w1, w2);
			Solution s = LocalSearch.run(randomSol, v); // recherche locale sur la solution aleatoire par rapport a un vecteur de poids
//			System.out.println("solution" + i + " : " + " " + s.objectives[0] + " " + s.objectives[1]);
			allSolutions.add(s); // ajout de la solution a la liste, au final la liste contiendra z+1 solutions pour un probleme a 2 objectifs
		}
//		off.filter(list); // filtrage de la liste
		return allSolutions; // renvoi de la liste avec que des solutions non dominees
	}

}
