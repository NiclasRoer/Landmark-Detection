import java.util.ArrayList;

public class Light_Selektion {
	
	private ArrayList<MatchData> matchlist;

	public ArrayList<MatchData> getSelektion(ArrayList<MatchData> matches, int percent) {
		matchlist = matches;
		int selektionsgrad = percent;
		if (selektionsgrad == 0) {
			selektionsgrad = 1;
		}
		
		ArrayList<MatchData> bestmatches = new ArrayList<MatchData>();
		for (int i = 0; i < selektionsgrad; i++) {
			int k = find_best_match();
			bestmatches.add(new MatchData(matchlist.get(k)));
			matchlist.remove(k);
		}
		return bestmatches;
	}

	

	private int find_best_match() {
		int match = 0;
		int matchindex = 0;
		for (int i = 0; i < matchlist.size(); i++) {
			MatchData m = matchlist.get(i);
			if (m.getMatch() > match) {
				match = m.getMatch();
				matchindex = i;
			}
		}
		return matchindex;
	}

}
