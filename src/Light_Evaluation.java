import java.util.ArrayList;

import ij.ImagePlus;

public class Light_Evaluation {

	private ArrayList<AlgoDaten> base_lib;
	private ArrayList<AlgoDaten> prüf_lib;
	private int[] steuerarray;
	private int[] landmark;

	public ArrayList<MatchData> getMatchlist(ArrayList<AlgoDaten> baseData, ArrayList<AlgoDaten> prüfData, int[] sa, int p) {
		base_lib = baseData;
		prüf_lib = prüfData;
		steuerarray = sa;
		landmark = new int[2];
		ArrayList<MatchData> matchlist = new ArrayList<MatchData>();
		for (int l = 0; l < prüf_lib.size(); l++) {
			for (int i = 0; i < base_lib.size(); i++) {
				AlgoDaten d = base_lib.get(i);
				MatchData m = new MatchData();
				landmark[0] = (int) d.getnewLandmark(p, 1);
				landmark[1] = (int) d.getnewLandmark(p, 2);
				m.setMatch(match_finder(i,l));
				m.setBase(i);
				m.setPrüf(l);
				matchlist.add(m);
			}
		}
		return matchlist;
	}

	private int match_finder(int i, int l) {
		AlgoDaten base = base_lib.get(i);
		AlgoDaten prüf = prüf_lib.get(l);
		ImagePlus source = Landmark_cut.cut(base.getbin_n_cut_Pic(), landmark[0], landmark[1], steuerarray[12]);
		ImagePlus source2 = Landmark_cut.cut(prüf.getbin_n_cut_Pic(), landmark[0], landmark[1], steuerarray[12]);
		int match = 0;
		if (steuerarray[13] == 0) {
			match = Dif_Pix.matchpic(source, source2);
		}
		if (steuerarray[13] == 1) {
			match = SamePix.matchpic(source, source2);
		}
		if (steuerarray[13] == 2) {
			match = Dif_Quadrat_Pix.matchpic(source, source2);
		}
		if (steuerarray[13] == 3) {
			match = MatrixFactor_Quadrat_Dif_Pix.matchpic(source, source2, steuerarray[18]);
		}
		//System.out.println(match);
		return match;
	}

}
