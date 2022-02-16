
public class Selektion {

	private int[] matchlist;

	public int[] getSelektion(int[] matches, int percent) {
		matchlist = matches;
		int selektionsgrad = Math.round(matchlist.length / (100 / percent));
		if (selektionsgrad == 0) {
			selektionsgrad = 1;
		}
		int[] bestmatches = new int[selektionsgrad];
		for (int i = 0; i < bestmatches.length; i++) {
			bestmatches[i] = delete_best_match();
		}
		return bestmatches;
	}

	private int delete_best_match() {
		int matchindex = find_best_match();
		matchlist[matchindex] = 0;
		return matchindex;
	}

	private int find_best_match() {
		int match = 0;
		int matchindex = 0;
		for (int i = 0; i < matchlist.length; i++) {
			if (matchlist[i] > match) {
				match = matchlist[i];
				matchindex = i;
			}
		}
		return matchindex;
	}
}
