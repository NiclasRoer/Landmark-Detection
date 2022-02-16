import java.util.ArrayList;

public class Auswertung {

	public static double get_Wert(ArrayList<int[]> marks, Datensatz testdata, int[] steuerarray) {
		Zeichnen.zeichnen3(marks, testdata.getbin_n_cut_Pic());
		ArrayList<Integer> alteX = testdata.getganzeneueLandmarkenX();
		ArrayList<Integer> alteY = testdata.getganzeneueLandmarkenY();
		double count = 0;
		for (int i = 0; i < marks.size(); i++) {
			int[] neueMark = marks.get(i);
			int abX = neueMark[0] - alteX.get(i);
			int abY = neueMark[1] - alteY.get(i);
			double wurzel = Math.pow(abX, 2) + Math.pow(abY, 2);
			double ergebnis = Math.sqrt(wurzel);
			if (steuerarray[10] == 1) {
				System.out.println((i + 1) + ". Landmarke, länge der Abweichung: " + ergebnis);
			}
			count = count + ergebnis;
		}
		count = count / marks.size();
		return count;
	}
	
	public static double get_Wert2(Datensatz marks, Datensatz testdata, int[] steuerarray) {
		Zeichnen.zeichnen2(marks, testdata);
		ArrayList<Integer> neueX = marks.getganzeneueLandmarkenX();
		ArrayList<Integer> neueY = marks.getganzeneueLandmarkenY();
		ArrayList<Integer> alteX = testdata.getganzeneueLandmarkenX();
		ArrayList<Integer> alteY = testdata.getganzeneueLandmarkenY();
		double count = 0;
		for (int i = 0; i < testdata.getLandmark_size(); i++) {
			int abX = neueX.get(i) - alteX.get(i);
			int abY = neueY.get(i) - alteY.get(i);
			double wurzel = Math.pow(abX, 2) + Math.pow(abY, 2);
			double ergebnis = Math.sqrt(wurzel);
			if (steuerarray[10] == 1) {
				System.out.println((i + 1) + ". Landmarke, länge der Abweichung: " + ergebnis);
			}
			count = count + ergebnis;
		}
		count = count / testdata.getLandmark_size() ;
		return count;
	}
}
