import java.util.ArrayList;

import ij.ImagePlus;

public class Datensatz {

	/*
	 * Datenfelder der Klasse
	 */

	private ImagePlus ori_Pic;
	private ImagePlus bin_n_cut_Pic;
	private double scaleX;
	private double scaleY;
	private ArrayList<Integer> x_Landmark = new ArrayList<Integer>();
	private ArrayList<Integer> y_Landmark = new ArrayList<Integer>();
	private ArrayList<Integer> new_x_Landmark = new ArrayList<Integer>();
	private ArrayList<Integer> new_y_Landmark = new ArrayList<Integer>();
	private int[] cutting_borders; // 0= obere ; 1=linke ; 2=untere ; 3=rechte ; die werte sind die zeilen mit dem ersten weißen pixel
	private int black_white_border; // Grenzwert für schwarz/weiß ; werte die der Grenze entsprechen werden schwarz
	private int artificial_border; // extra hinzugefügte grenze
	private int[] scalediff;// 0=X ; 1=Y

	/**
	 * Standart-Konstruktor
	 */

	public Datensatz() {

	}

	/**
	 * Copy-Konstruktor
	 */

	public Datensatz(Datensatz datensatz) {
		this.ori_Pic = datensatz.ori_Pic;
		this.bin_n_cut_Pic = datensatz.bin_n_cut_Pic;
		this.scaleX = datensatz.scaleX;
		this.scaleY = datensatz.scaleY;
		this.x_Landmark = datensatz.x_Landmark;
		this.y_Landmark = datensatz.y_Landmark;
		this.new_x_Landmark = datensatz.new_x_Landmark;
		this.new_y_Landmark = datensatz.new_y_Landmark;
		this.cutting_borders = datensatz.cutting_borders;
		this.black_white_border = datensatz.black_white_border;
		this.artificial_border = datensatz.artificial_border;
		this.scalediff = datensatz.scalediff;
	}

	/**
	 * Getter und Setter für die Höhen-Breitendifferenz beim Skallieren
	 */

	public int[] getScalediff() {
		return scalediff;
	}

	public void setScalediff(int[] scalediff) {
		this.scalediff = scalediff;
	}

	/**
	 * Getter und Setter der künstlich hinzugefügten Grenze
	 */

	public int getNew_border() {
		return artificial_border;
	}

	public void setNew_border(int new_border) {
		this.artificial_border = new_border;
	}

	/**
	 * Getter und Setter der SchwarzWeiß Aufspaltgrenze
	 */

	// Ausgeben der Grenze
	public int getBorder() {
		return black_white_border;
	}

	// Festlegen der Grenzen
	public void setBorder(int border) {
		this.black_white_border = border;
	}

	/**
	 * Getter und Setter des Grenzarray, Schneidewerte
	 */

	// Ausgeben der Grenzen
	public int[] getBorders() {
		return cutting_borders;
	}

	// Festlegen der Grenzen
	public void setBorders(int[] borders) {
		this.cutting_borders = borders;
	}

	/**
	 * Getter und Setter der Skalierung
	 */
	// Ausgeben der Skalierung
	public double getScaleY() {
		return scaleY;
	}

	// Festlegen der Skalierung
	public void setScaleY(double scaleY) {
		this.scaleY = scaleY;
	}

	// Ausgeben der Skalierung
	public double getScaleX() {
		return scaleX;
	}

	// Festlegen der Skalierung
	public void setScaleX(double scaleX) {
		this.scaleX = scaleX;
	}

	/**
	 * Getter und Setter der Bilder
	 */

	// Ausgeben des originalen Bildes
	public ImagePlus getori_Pic() {
		return ori_Pic;
	}

	// Festlegen des originalen Bildes
	public void setori_Pic(ImagePlus ori_Pic) {
		this.ori_Pic = ori_Pic;
	}

	// Ausgeben des bearbeiteten Bildes
	public ImagePlus getbin_n_cut_Pic() {
		return bin_n_cut_Pic;
	}

	// Festlegen des bearbeiteten Bildes
	public void setbin_n_cut_Pic(ImagePlus bin_Pic) {
		this.bin_n_cut_Pic = bin_Pic;
	}

	/*
	 * Getter und Setter der X oder Y Landmarken
	 */

	// Ausgabe der X oder Y Landmarken
	public double getLandmark(int index, int index2) {
		if (index2 == 1) {
			return x_Landmark.get(index);
		}
		if (index2 == 2) {
			return y_Landmark.get(index);
		} else {
			throw new IllegalArgumentException("Du musst dich entscheiden X oder Y!");
		}
	}

	// Festlegung der X oder Y Landmarken
	public void setLandmark(int wert, int index) {
		if (index == 1)
			x_Landmark.add(wert);
		if (index == 2)
			y_Landmark.add(wert);
	}

	// Ausgabe der X oder Y Landmarken für bearbeitete Bilder
	public double getnewLandmark(int index, int index2) {
		if (index2 == 1) {
			return new_x_Landmark.get(index);
		}
		if (index2 == 2) {
			return new_y_Landmark.get(index);
		} else {
			throw new IllegalArgumentException("Du musst dich entscheiden X oder Y!");
		}
	}

	// Ausgabe der kompletten Arraylist von neuen X_Landmarken
	public ArrayList<Integer> getganzeneueLandmarkenX() {
		return new_x_Landmark;
	}

	// Ausgabe der kompletten Arraylist von neuen Y_Landmarken
	public ArrayList<Integer> getganzeneueLandmarkenY() {
		return new_y_Landmark;
	}

	// Festlegung der X oder Y Landmarken für bearbeitete Bilder
	public void setnewLandmark(int wert, int index) {
		if (index == 1)
			new_x_Landmark.add(wert);
		if (index == 2)
			new_y_Landmark.add(wert);
	}

	// Bestimmung der Landmarkenanzahl
	public int getLandmark_size() {
		return x_Landmark.size();
	}
}