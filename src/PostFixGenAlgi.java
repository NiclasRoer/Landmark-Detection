import java.util.ArrayList;

import ij.ImagePlus;

public class PostFixGenAlgi {

	public static ArrayList<int[]> the_dark_force(Datensatz prüfData, Datensatz matchData, int[] steuerarray) {
		ArrayList<int[]> finalmarks = new ArrayList<int[]>();
		ImagePlus source = prüfData.getbin_n_cut_Pic();
		for (int i = 0; i < matchData.getLandmark_size(); i++) {
			ArrayList<int[]> possiblemarks = new ArrayList<int[]>();
			int count = 0;
			boolean b = true;
			if (i == 14)
				b = false;
			if (b) {
				int[] mark = new int[2];
				mark[0] = (int) matchData.getnewLandmark(i, 1);
				mark[1] = (int) matchData.getnewLandmark(i, 2);
				possiblemarks.add(mark);

				boolean end = true;

				while (end) {
					Dark_Evaluation de = new Dark_Evaluation();
					Dark_Selektion ds = new Dark_Selektion();
					Dark_Klonen_n_Mutation dkm = new Dark_Klonen_n_Mutation();
					int[] result = de.auf_Kante(source, possiblemarks, steuerarray);
					if (result[2] == 1) {
						if (steuerarray[10] == 1) {
							System.out.println((i + 1) + ". Landmarke, Anzahl der Ringe: " + count + "; X-Wert: "
									+ result[0] + "; Y-Wert: " + result[1] + " " + result[2]);
						}
						finalmarks.add(result);
						end = false;
						break;
					} else {
						count++;
					}
					possiblemarks = ds.get_Dark_Selektion(possiblemarks);
					dkm.get_Dark_Klonelist(possiblemarks, count);
				}
			} else {
				int[] mark = new int[3];
				mark[2] = 0;
				mark[0] = (int) matchData.getnewLandmark(i, 1);
				mark[1] = (int) matchData.getnewLandmark(i, 2);
				finalmarks.add(mark);
				if (steuerarray[10] == 1) {
					System.out.println((i + 1) + ". Landmarke, Anzahl der Ringe: " + count + "; X-Wert: " + mark[0]
							+ "; Y-Wert: " + mark[1] + " " + mark[2]);
				}
			}
		}
		if (steuerarray[10] == 1) {
			System.out.println(" ");
		}
		return finalmarks;
	}
}
