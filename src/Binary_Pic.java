import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;

public class Binary_Pic {
	
	/***
	 * Datenfelder der Klasse
	 */
	
	private ImagePlus image;
	private ImagePlus binimg;
	private ImageProcessor ip;
	private ImageProcessor ipbin;
	private int border;
	
	/***
	 * Übergeordnete Startmethode, erstellt neues Blid, lässt den Trennwert berechnen und
	 * ruft alle Pixel nacheinander auf um den Neuen wert eingeben zu lassen,
	 * gibt das neue Bild zurück.
	 */
	
	public ImagePlus binpic(ImagePlus img, int b) {
		
		image =  img;
		ip = image.getProcessor ();
		binimg = IJ.createImage("grayvalue image", "8-bit", ip.getWidth(), ip.getHeight(), 1);
		ipbin = binimg.getProcessor();
		if(b!=0) {
			border = b;
		}else {
		border = trenn_wert();
		}
		for(int h = 0; h<ip.getHeight();h++) {
			for(int w = 0; w<ip.getWidth(); w++) {
				black_white(w, h);
			}
		}
		return binimg;
	}

	/***
	 * Methode in der einem Pixel die schwarz oder weiß zugeordnet wird.
	 */
	
	private void black_white(int w, int h) {
		if(ip.getPixel(w, h) <= border) 
			ipbin.putPixel(w,h,0);
		
		else 
			ipbin.putPixel(w,h,255);
	}
	
	/***
	 * Getter für den Grenzwert
	 */
	
	public int getBorder() {
		return border;
	}

	/***
	 * Methode in der der Trennwert zwischen weiß und schwarz berechnet wird.
	 */
	
	private int trenn_wert() {
		int[] histogramm = new int[256];
		int lowborder=0;
		int highborder=0;
		int result;
		
		/**
		 * durchschnittliche helligkeit
		 */
		
//		for(int h = 0; h<ip.getHeight();h++) {
//			for(int w = 0; w<ip.getWidth(); w++) {
//				lowborder = lowborder + ip.getPixel(w, h);
//			}
//		}
//		result = lowborder / (ip.getHeight()*ip.getWidth());
		
		/**
		 * Mittelwert aus höchster und niedrigster durchschnittlich oft vorkommenden helligkeit
		 */
//		
//		for(int h = 0; h<ip.getHeight();h++) {
//			for(int w = 0; w<ip.getWidth(); w++) {
//				histogramm[ip.getPixel(w, h)]=histogramm[ip.getPixel(w, h)]+1;
//			}
//		}
//		for(int i = 1; i<220; i++) {
//			if(histogramm[i]> ((ip.getHeight()*ip.getWidth())/255)) {
//				lowborder = i;
//				break;
//			}
//		}
//		for(int i = 255; i>30; i--) {
//			if(histogramm[i]> ((ip.getHeight()*ip.getWidth())/255)) {
//				highborder = i;
//				break;
//			}
//		}
//		result = ((lowborder + highborder)/2)+35;
		
		/**
		 *  Durchnittswert aller überdurchschnittlich häuftigen farben die vorkommen
		 */
		
		/*
		 * Erstellt ein Histogramm als Array
		 */
		
		for(int h = 0; h<ip.getHeight();h++) {
			for(int w = 0; w<ip.getWidth(); w++) {
				histogramm[ip.getPixel(w, h)]=histogramm[ip.getPixel(w, h)]+1;
			}
		}
		
		/*
		 * Addiert in lowborder alle überdurchschnittlich oft vorkommenden Pixelhelligkeiten
		 * und in highborder die Anzahl, dann bildet es den Durchschnitt
		 */
		
		for(int j =0; j< histogramm.length;j++) {
			if (histogramm[j]>(ip.getHeight()*ip.getWidth())/255) {
				lowborder =lowborder + j;
				highborder ++;
			}
		}
		result = lowborder/highborder;
		
		return result;
	}
}