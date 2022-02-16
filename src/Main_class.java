
import java.util.ArrayList;

import ij.ImagePlus;
import ij.process.ImageProcessor;
import imagelib.ImageUtil;

public class Main_class {

	public static void main(String[] args) throws Exception {
		//Ergebnisse.ergebnisse();
		int[] sa = Steuerarry.get_array();
		ArrayList<Datensatz> trainingsdaten = Dateneinlesen.einlesen("./lib/Source/Lands.txt", "./lib/Source/", ".png");
		ArrayList<Datensatz> testdaten = Dateneinlesen.einlesen("./lib/Target/Landt.txt", "./lib/Target/", ".png");
		Bin_n_Cut.bin_cut(trainingsdaten, sa);
		Bin_n_Cut.bin_cut(testdaten, sa);
		double auswertung = 1337;
		long zstVorher = 0;
		long zstNachher = 0;
		if (sa[19] == 1) {
			zstVorher = System.currentTimeMillis();
			ArrayList<int[]> re = GenAlgi.the_force(trainingsdaten, testdaten.get(sa[20]), sa);
			Datensatz d = Translate.trans(re, trainingsdaten, sa);
			ArrayList<int[]> marks = PostFixGenAlgi.the_dark_force(testdaten.get(sa[20]), d, sa);
			auswertung = Auswertung.get_Wert(marks, testdaten.get(sa[20]), sa);
			ArrayList<int[]> mar = Back_Transformation.bt2(marks, testdaten.get(sa[20]));
			Datensatz dd = testdaten.get(sa[20]);
			Zeichnen.zeichnen3(mar, dd.getori_Pic());
			zstNachher = System.currentTimeMillis();
			System.out.println("Zeit benötigt: " + ((zstNachher - zstVorher) / 1000) + " sec");
		}
		if (sa[19] == 2) {
			zstVorher = System.currentTimeMillis();
			ArrayList<int[]> re = GenAlgi.the_force(trainingsdaten, testdaten.get(sa[20]), sa);
			Datensatz d = Translate.trans(re, trainingsdaten, sa);
			auswertung = Auswertung.get_Wert2(d, testdaten.get(sa[20]), sa);
			ArrayList<int[]> mar = Back_Transformation.bt(d, testdaten.get(sa[20]));
			Datensatz dd = testdaten.get(sa[20]);
			Zeichnen.zeichnen3(mar, dd.getori_Pic());
			zstNachher = System.currentTimeMillis();
			System.out.println("Zeit benötigt: " + ((zstNachher - zstVorher) / 1000) + " sec");
		}
		if (sa[19] == 3) {
			zstVorher = System.currentTimeMillis();
			ArrayList<int[]> re = PreFixGenAlgi.the_light_force(trainingsdaten, testdaten.get(sa[20]), sa);
			Datensatz d = Translate.trans(re, trainingsdaten, sa);
			ArrayList<int[]> marks = PostFixGenAlgi.the_dark_force(testdaten.get(sa[20]), d, sa);
			auswertung = Auswertung.get_Wert(marks, testdaten.get(sa[20]), sa);
			ArrayList<int[]> mar = Back_Transformation.bt2(marks, testdaten.get(sa[20]));
			Datensatz dd = testdaten.get(sa[20]);
			Zeichnen.zeichnen3(mar, dd.getori_Pic());
			zstNachher = System.currentTimeMillis();
			System.out.println("Zeit benötigt: " + ((zstNachher - zstVorher) / 1000) + " sec");
		}
		if (sa[19] == 4) {
			zstVorher = System.currentTimeMillis();
			ArrayList<int[]> re = PreFixGenAlgi.the_light_force(trainingsdaten, testdaten.get(sa[20]), sa);
			Datensatz d = Translate.trans(re, trainingsdaten, sa);
			auswertung = Auswertung.get_Wert2(d, testdaten.get(sa[20]), sa);
			ArrayList<int[]> mar = Back_Transformation.bt(d, testdaten.get(sa[20]));
			Datensatz dd = testdaten.get(sa[20]);
			Zeichnen.zeichnen3(mar, dd.getori_Pic());
			zstNachher = System.currentTimeMillis();
			System.out.println("Zeit benötigt: " + ((zstNachher - zstVorher) / 1000) + " sec");
		}

		if (sa[10] == 1) {
			System.out.println(" ");
		}
		System.out.println("Durchschnittliche Abweichung: " + auswertung + " Zeit benötigt: "
				+ ((zstNachher - zstVorher) / 1000) + " sec");
		// Zeichnen.zeichnen1(trainingsdaten.get(20));
	}
}