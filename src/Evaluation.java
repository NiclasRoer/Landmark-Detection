import java.util.ArrayList;

public class Evaluation {

	private ArrayList<AlgoDaten> base_lib;
	private Datensatz prüf;
	private int[] steuerarray;

	public int[] getMatchlist(ArrayList<AlgoDaten> baseData, Datensatz prüfData, int[] sa) {
		base_lib = baseData;
		prüf = prüfData;
		steuerarray = sa;
		int[] matchlist = new int[base_lib.size()];
		for (int i = 0; i < base_lib.size(); i++) {
			matchlist[i] = match_finder(i);
		}
		return matchlist;
	}

	private int match_finder(int i) {
		AlgoDaten base = base_lib.get(i);
		int match = 0;
		if (steuerarray[5] == 0) {
			match = Dif_Pix.matchpic(prüf.getbin_n_cut_Pic(), base.getbin_n_cut_Pic());
		}
		if (steuerarray[5] == 1) {
			match = SamePix.matchpic(prüf.getbin_n_cut_Pic(), base.getbin_n_cut_Pic());
		}
		if (steuerarray[5] == 2) {
			match = Landmark_Part_Pix.matchpic(prüf.getbin_n_cut_Pic(), base.getbin_n_cut_Pic(),base.getganzeneueLandmarkenX(),base.getganzeneueLandmarkenY(),steuerarray[11]);
		}
		if (steuerarray[5] == 3) {
			match = Dif_Quadrat_Pix.matchpic(prüf.getbin_n_cut_Pic(), base.getbin_n_cut_Pic());
		}
		if (steuerarray[5] == 4) {
			match = MatrixFactor_Quadrat_Dif_Pix.matchpic(prüf.getbin_n_cut_Pic(), base.getbin_n_cut_Pic(), steuerarray[18]);
		}
		return match;
	}

}
