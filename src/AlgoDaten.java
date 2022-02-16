import java.util.ArrayList;

import ij.ImagePlus;

public class AlgoDaten {

	/*
	 * Datenfelder der Klasse
	 */

	private ImagePlus bin_n_cut_Pic;
	private ArrayList<Integer> new_x_Landmark = new ArrayList<Integer>();
	private ArrayList<Integer> new_y_Landmark = new ArrayList<Integer>();
	private int name;
	private int grade;
	private int xway;

	private int yway;

	/**
	 * Copy-Konstruktoren
	 */

	// Copy-Konstruktor für Datensatz
	public AlgoDaten(Datensatz datensatz, int name) {
		this.bin_n_cut_Pic = datensatz.getbin_n_cut_Pic();
		this.new_x_Landmark = datensatz.getganzeneueLandmarkenX();
		this.new_y_Landmark = datensatz.getganzeneueLandmarkenY();
		this.name = name;
		grade = 0;
		xway = 0;
		yway = 0;
	}
	
	// Copy-Konstruktor für Datensatz
		public AlgoDaten(Datensatz datensatz, int name, int grade) {
			this.bin_n_cut_Pic = datensatz.getbin_n_cut_Pic();
			this.new_x_Landmark = datensatz.getganzeneueLandmarkenX();
			this.new_y_Landmark = datensatz.getganzeneueLandmarkenY();
			this.name = name;
			this.grade = grade;
			xway = 0;
			yway = 0;
		}

	// Copy-Konstruktor für Algodaten
	public AlgoDaten(AlgoDaten datensatz) {
		this.bin_n_cut_Pic = datensatz.bin_n_cut_Pic;
		this.new_x_Landmark = datensatz.new_x_Landmark;
		this.new_y_Landmark = datensatz.new_y_Landmark;
		this.name = datensatz.name;
		this.grade = datensatz.grade;
		this.xway = datensatz.xway;
		this.yway = datensatz.yway;
	}

	// Copy-Konstruktor für Algodaten
//	public AlgoDaten(AlgoDaten datensatz, ImagePlus pic, int newgrade) {
//		bin_n_cut_Pic = pic;
//		this.new_x_Landmark = datensatz.new_x_Landmark;
//		this.new_y_Landmark = datensatz.new_y_Landmark;
//		this.name = datensatz.name;
//		grade = grade + newgrade;
//	}

	/**
	 * Getter und Setter für X und Y Way
	 */

	public int getXway() {
		return xway;
	}

	public void setXway(int xw) {
		xway = xway + xw;
	}

	public int getYway() {
		return yway;
	}

	public void setYway(int yw) {
		yway = yway + yw;
	}

	/**
	 * Getter und Setter für Landmarken
	 */

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

	// Festlegung der X oder Y Landmarken für bearbeitete Bilder
	public void setnewLandmark(int wert, int index) {
		if (index == 1)
			new_x_Landmark.add(wert);
		if (index == 2)
			new_y_Landmark.add(wert);
	}

	// Ausgabe der kompletten Arraylist von neuen X_Landmarken
	public ArrayList<Integer> getganzeneueLandmarkenX() {
		return new_x_Landmark;
	}

	// Ausgabe der kompletten Arraylist von neuen Y_Landmarken
	public ArrayList<Integer> getganzeneueLandmarkenY() {
		return new_y_Landmark;
	}

	// Bestimmung der Landmarkenanzahl
	public int getLandmark_size() {
		return new_x_Landmark.size();
	}

	/*
	 * Getter und Setter für bearbeitetes Bild
	 */

	// Ausgeben des bearbeiteten Bildes
	public ImagePlus getbin_n_cut_Pic() {
		return bin_n_cut_Pic;
	}

	// Festlegen des bearbeiteten Bildes
	public void setbin_n_cut_Pic(ImagePlus bin_Pic) {
		this.bin_n_cut_Pic = bin_Pic;
	}

	/*
	 * Getter und Setter für den Platz in der kompletten Datenbasis
	 */

	// Ausgeben des Namen
	public int getName() {
		return name;
	}

	// Festlegen des Namen
	public void setName(int name) {
		this.name = name;
	}

	/*
	 * Getter und Setter für die Grad um die das Bild rotiert ist
	 */

	// Ausgeben des Grades der Rotation
	public int getGrade() {
		return grade;
	}

	// Festlegen des Grades der Rotation
	public void setGrade(int newgrade) {
		grade = grade + newgrade;
	}
}