package filters;

import java.util.ArrayList;
import java.util.List;

import models.Solution;

public class OnLine {
	
	private List<Solution> archive;
	
	public OnLine() {
		archive = new ArrayList<Solution>();
	}
	
	public void run(Solution sol) {
		if (archive.size() > 0) {
			if (!sol.isDominated(archive)) {
				archive.add(sol);
				for (Solution s : archive) {
					if (s.isDominated(archive)) {
						archive.remove(s);
					}
				}
			}
		}
		else {
			archive.add(sol);
		}
	}

	public List<Solution> getArchive() {
		return archive;
	}

}
