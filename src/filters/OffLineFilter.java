package filters;

import java.util.ArrayList;
import java.util.List;

import models.Solution;

public class OffLineFilter {
	
	/**
	 * Filtre les solutions de la liste donnee en parametre selon la strategie off-line,
	 * c'est a dire renvoie une liste avec les solutions non dominees.
	 * @param solution liste de solutions a filtrer
	 * @return une autre liste avec uniquement les solutions non dominees
	 */
	public static List<Solution> filter(List<Solution> solution) {
		List<Solution> res = new ArrayList<Solution>(); // liste qui contiendra les solutions non dominees
		for (Solution s : solution) { // pour chaque solution de la liste
			if (!s.isDominated(solution)) { // si elle n'est dominee par aucune solution de la liste
				res.add(s); // ajout a la liste des solutions non dominees
			}
		}
		return res; // renvoi de la liste des solutions non dominees
	}

}