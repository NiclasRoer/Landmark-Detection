import java.util.ArrayList;
import ij.ImagePlus;

public class Bin_n_Cut {

	/*
	 * Datenfelder der Kasse
	 */
	private static ArrayList<Datensatz> trainingsdaten;
	private static int[] steuerarray;

	/*
	 * Startmethode die alle Datensätze nacheinander Aufruft
	 */
	public static ArrayList<Datensatz> bin_cut(ArrayList<Datensatz> trainingsdaten2, int[] sa) {
		trainingsdaten = trainingsdaten2;
		steuerarray = sa;
		for (int i = 0; i < trainingsdaten.size(); i++) {
			magic(i);
		}
		return trainingsdaten;
	}

	private static void magic(int i) {
		Datensatz d = trainingsdaten.get(i);
		Binary_Pic bp = new Binary_Pic();
		Scaleing sc = new Scaleing();
		Cuting ct = new Cuting();
		New_Landmark_fix nl = new New_Landmark_fix();
		ImagePlus binimg = bp.binpic(d.getori_Pic(), steuerarray[9]);
		d.setBorder(bp.getBorder());
		ImagePlus cutimg;
		if (steuerarray[2] == 0) {
			cutimg = ct.cut(binimg);
		} else {
			cutimg = ct.cut2(binimg, d.getori_Pic());
		}
		d.setBorders(ct.get_borders());
		ImagePlus scalimg = sc.scale(cutimg, steuerarray);
		d.setScaleX(sc.getScaleX());
		d.setScaleY(sc.getScaleY());
		d.setbin_n_cut_Pic(scalimg);
		d.setScalediff(sc.getScalediff());
		d.setNew_border(steuerarray[1]);
		nl.fix_landmark(d);
		trainingsdaten.set(i, d);
	}
}