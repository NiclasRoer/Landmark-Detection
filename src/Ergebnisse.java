import java.io.IOException;
import java.util.ArrayList;

public class Ergebnisse {

	public static void ergebnisse() throws NumberFormatException, IOException {
		int[] sa = Steuerarry.get_array();
		ArrayList<Datensatz> trainingsdaten = Dateneinlesen.einlesen("./lib/Source/Lands.txt", "./lib/Source/", ".png");
		ArrayList<Datensatz> testdaten = Dateneinlesen.einlesen("./lib/Target/Landt.txt", "./lib/Target/", ".png");
		
		double auswertung = 1337;
		long zstVorher = 0;
		long zstNachher = 0;

		for (int o = 2; o < 3; o++) {
			sa[20] = o;
			for (int i = 0; i < 4; i++) {
				sa[13] = i;
			
				for (int p = 0; p < 2; p++) {
					sa[21] = p;
					for (int k = 0; k < 2; k++) {
						sa[2] = k;
						
						Bin_n_Cut.bin_cut(trainingsdaten, sa);
						Bin_n_Cut.bin_cut(testdaten, sa);

						if (sa[19] == 1) {
							zstVorher = System.currentTimeMillis();
							ArrayList<int[]> re = GenAlgi.the_force(trainingsdaten, testdaten.get(sa[20]), sa);
							Datensatz d = Translate.trans(re, trainingsdaten, sa);
							ArrayList<int[]> marks = PostFixGenAlgi.the_dark_force(testdaten.get(sa[20]), d, sa);
							auswertung = Auswertung.get_Wert(marks, testdaten.get(sa[20]), sa);
							// ArrayList<int[]> mar = Back_Transformation.bt2(marks, testdaten.get(sa[20]));
							// Datensatz dd = testdaten.get(sa[20]);
							// Zeichnen.zeichnen3(mar, dd.getori_Pic());
							zstNachher = System.currentTimeMillis();
						}
						if (sa[19] == 2) {
							zstVorher = System.currentTimeMillis();
							ArrayList<int[]> re = GenAlgi.the_force(trainingsdaten, testdaten.get(sa[20]), sa);
							Datensatz d = Translate.trans(re, trainingsdaten, sa);
							auswertung = Auswertung.get_Wert2(d, testdaten.get(sa[20]), sa);
							// ArrayList<int[]> mar = Back_Transformation.bt(d, testdaten.get(sa[20]));
							// Datensatz dd = testdaten.get(sa[20]);
							// Zeichnen.zeichnen3(mar, dd.getori_Pic());
							zstNachher = System.currentTimeMillis();
						}
						if (sa[19] == 3) {
							zstVorher = System.currentTimeMillis();
							ArrayList<int[]> re = PreFixGenAlgi.the_light_force(trainingsdaten, testdaten.get(sa[20]),
									sa);
							Datensatz d = Translate.trans(re, trainingsdaten, sa);
							ArrayList<int[]> marks = PostFixGenAlgi.the_dark_force(testdaten.get(sa[20]), d, sa);
							auswertung = Auswertung.get_Wert(marks, testdaten.get(sa[20]), sa);
							// ArrayList<int[]> mar = Back_Transformation.bt2(marks, testdaten.get(sa[20]));
							// Datensatz dd = testdaten.get(sa[20]);
							// Zeichnen.zeichnen3(mar, dd.getori_Pic());
							zstNachher = System.currentTimeMillis();
						}
						if (sa[19] == 4) {
							zstVorher = System.currentTimeMillis();
							ArrayList<int[]> re = PreFixGenAlgi.the_light_force(trainingsdaten, testdaten.get(sa[20]),
									sa);
							Datensatz d = Translate.trans(re, trainingsdaten, sa);
							auswertung = Auswertung.get_Wert2(d, testdaten.get(sa[20]), sa);
							// ArrayList<int[]> mar = Back_Transformation.bt(d, testdaten.get(sa[20]));
							// Datensatz dd = testdaten.get(sa[20]);
							// Zeichnen.zeichnen3(mar, dd.getori_Pic());
							zstNachher = System.currentTimeMillis();
						}
						System.out.println("Abweichung: " + auswertung + " Zeit: " + (zstNachher - zstVorher)
								+" msec TDS:" + o + " Eva:" + i +  " Skaliert:" + p + " Bild:" + k);
					}
				}
			}
		}
	}

}
