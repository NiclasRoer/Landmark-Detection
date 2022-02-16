import java.util.ArrayList;

public class GenAlgi {
	private static ArrayList<Datensatz> base_lib;
	private static Datensatz prüf;
	private static ArrayList<AlgoDaten> algo_lib;
	private static int[] steuerarray;

	public static ArrayList<int[]> the_force(ArrayList<Datensatz> baseData, Datensatz prüfData, int[] sa) {
		base_lib = baseData;
		prüf = prüfData;
		steuerarray = sa;
		algo_lib = The_first_time.translate(base_lib);
		if (steuerarray[4] != 0) {
			Klonen kl = new Klonen();
			Mutation mu = new Mutation();
			algo_lib = kl.getfirstKlonlist(algo_lib, steuerarray[7]);
			mu.get_Mutants(algo_lib, base_lib.size(), steuerarray[4]);
		}
		int grade = steuerarray[3];
		boolean finish = true;
		int count = 1;// zur anzeige für Konsolenausgabe
		while (finish) {
			Evaluation eva = new Evaluation();
			Selektion sel = new Selektion();
			Klonen klo = new Klonen();
			Mutation mut = new Mutation();

			int[] matchlist = eva.getMatchlist(algo_lib, prüf, steuerarray);

			if (steuerarray[10] == 1) {
				System.out.println("GenAlgi Durchlauf " + count);
				for (int i = 0; i < matchlist.length; i++) {
					AlgoDaten d = algo_lib.get(i);
					System.out.println("Matchlistwert" + i + ": " + matchlist[i] + " Rotationsgrad: " + d.getGrade());
				}
				System.out.println(" ");
			}

			int[] bestmatches = sel.getSelektion(matchlist, steuerarray[6]);

			algo_lib = klo.getKlonlist(algo_lib, bestmatches, steuerarray[7]);

			if (grade < 2) {
				finish = false;
				break;
			}
			count++;

			mut.get_Mutants(algo_lib, bestmatches.length, grade);
			grade = Math.round(grade / 2);
		}
		AlgoDaten d = algo_lib.get(0);
		int n = d.getName();
		int g = d.getGrade();
		if (steuerarray[10] == 1) {
			System.out.println("Bestes Match ist Datensatz: " + n + " bei " + g + " Grad");
			System.out.println(" ");
		}
		// Datensatz dd = base_lib.get(n);
		// Zeichnen.zeichnen2(dd,prüf);
		int[] result = new int[2];
		result[0] = n;
		result[1] = g;
		ArrayList<int[]> res = new ArrayList<int[]>();
		for (int o = 0; o < prüf.getLandmark_size(); o++) {
			res.add(result);
		}
		return res;
	}
}
