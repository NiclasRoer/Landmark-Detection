import java.util.ArrayList;

import ij.ImagePlus;

public class PreFixGenAlgi {
	private static ArrayList<Datensatz> base_lib;
	private static Datensatz prüf;
	private static ArrayList<AlgoDaten> algo_lib;
	private static ArrayList<AlgoDaten> prüf_lib;
	private static int[] steuerarray;
	
	public static ArrayList<int[]> the_light_force(ArrayList<Datensatz> baseData, Datensatz prüfData, int[] sa) {
		base_lib = baseData;
		prüf = new Datensatz(prüfData);
		steuerarray = sa;
	
		ArrayList<int[]> finalresult = new ArrayList<int[]>();
		
		for (int p = 0; p < prüf.getLandmark_size(); p++) {
			prüf_lib = new ArrayList<AlgoDaten>();
			algo_lib = The_first_time.translate(base_lib);
			prüf_lib.add(new AlgoDaten(prüf,0));
			
			if (steuerarray[15] != 0) {
				Light_Klonen kl = new Light_Klonen();
				Light_Mutation mu = new Light_Mutation();
				prüf_lib = kl.getfirstKlonlist(prüf_lib, steuerarray[7]);
				mu.get_rotierte_Mutants(prüf_lib, 1, steuerarray[15]);
				prüf_lib = kl.getfirstKlonlist(prüf_lib, steuerarray[14]);
				mu.get_moved_Mutants(prüf_lib, (1 * (steuerarray[7] + 1)), steuerarray[15]);
			}
			int grade = steuerarray[16];
			if (steuerarray[10] == 1) {
				System.out.println("Landmarke Nr.: " + (p + 1));
			}
			boolean finish = true;
			int count = 1;// zur anzeige für Konsolenausgabe
			while (finish) {
				Light_Evaluation eva = new Light_Evaluation();
				Light_Selektion sel = new Light_Selektion();
				Light_Klonen klo = new Light_Klonen();
				Light_Mutation mut = new Light_Mutation();

				ArrayList<MatchData> matchlist = eva.getMatchlist(algo_lib, prüf_lib, steuerarray, p);

//				if (steuerarray[10] == 1) {
//					System.out.println("GenAlgi Durchlauf " + count);
//					for (int i = 0; i < matchlist.length; i++) {
//						AlgoDaten d = algo_lib.get(i);
//						System.out.println("Matchlistwert" + i + ": " + matchlist[i] + " Rotationsgrad: " + d.getGrade()
//								+ " Xway: " + d.getXway() + " Yway: " + d.getYway());
//					}
//					System.out.println(" ");
//				}

				ArrayList<MatchData> bestmatches = sel.getSelektion(matchlist, steuerarray[17]);
//				if (steuerarray[10] == 1) {
//					System.out.println("GenAlgi Durchlauf " + count);
//					for (int i = 0; i < bestmatches.length; i++) {
//						AlgoDaten d = algo_lib.get(bestmatches[i]);
//						System.out.println("Matchlistwert" + i + ": " + matchlist[bestmatches[i]] + " Rotationsgrad: " + d.getGrade()
//								+ " Xway: " + d.getXway() + " Yway: " + d.getYway());
//					}
//					System.out.println(" ");
//				}

				prüf_lib = klo.getKlonlist(prüf_lib, bestmatches, steuerarray[7]);
				if (grade < 2) {
					finish = false;
					break;
				}
				count++;

				prüf_lib = mut.get_rotierte_Mutants(prüf_lib, bestmatches.size(), grade);

				prüf_lib = klo.getfirstKlonlist(prüf_lib, steuerarray[14]);

				prüf_lib = mut.get_moved_Mutants(prüf_lib, ((steuerarray[7] + 1) * bestmatches.size()), grade);

				grade = Math.round(grade / 2);
			}
			AlgoDaten d = prüf_lib.get(0);
			int[] res = new int[5];
			res[0] = d.getName();
			res[1] = d.getGrade();
			res[2] = d.getXway();
			res[3] = d.getYway();
			res[4] = p;
			finalresult.add(res);
			if (steuerarray[10] == 1) {
				System.out.println("Bestes Match ist Datensatz: " + res[0] + " bei " + res[1] + " Grad");
				System.out.println("Xway: " + res[2] + " Yway: " + res[3] + " LM nr.: " + res[4]);
			}
			// Datensatz dd = base_lib.get(n);
			// Zeichnen.zeichnen2(dd,prüf);

		}
		return finalresult;
	}
}
