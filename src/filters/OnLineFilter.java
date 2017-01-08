package filters;

import java.util.ArrayList;
import java.util.List;

import models.Solution;

public class OnLineFilter {
	
	private List<Solution> archive;
	
	public OnLineFilter() {
		archive = new ArrayList<Solution>();
	}
	
	/**
	 * Filtre les solutions de l'archive strategie on-line. A partir d'une solution donnee en parametre,
	 * verifie si cette solution n'est dominee par aucune solution de l'archive. Si elle n'est pas dominee
	 * alors cette solution est ajoutee a l'archive puis mise a jour de l'archive pour enlever les
	 * eventuelles solutions dominees.
	 * @param sol une solution
	 */
	public void filter(Solution sol) {
		List<Solution> copy = new ArrayList<Solution>(archive);
		if (copy.size() > 0) { // si l'archive est vide
			if (!sol.isDominated(copy)) { // si la solution n'est dominee par aucune solution de l'archive
				for (Solution s : copy) { // chaque solution de l'archive
					if (s.isDominated(sol)) { // si elle est dominee par la nouvelle solution
						archive.remove(s); // on l'enleve de l"archive
					}
				}
				archive.add(sol); // ajout de la solution a l'archive
			}
		}
		else { // si l'archive est vide
			archive.add(sol); // ajout de la solution a l'archive
		}
	}

	public List<Solution> getArchive() {
		return archive;
	}
	
	/**
	 * Efface le contenu de l'archive.
	 */
	public void clear() {
		archive.clear();
	}

}
