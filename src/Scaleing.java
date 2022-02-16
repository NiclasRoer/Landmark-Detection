import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;

public class Scaleing {

	/*
	 * Datenfelder der Kalsse
	 */
	private ImagePlus source;
	private ImageProcessor ipsource;
	private ImagePlus target;
	private ImageProcessor iptarget;
	private double scaleY;
	private double scaleX;
	private int widthset;
	private int heightset;
	private int[] steuerarray;

	/*
	 * Startmethode, übernimmt Bild, neue Größe und Gränzen die eigefügt werden
	 * sollen, koodiniert initialisieren von Bildern, des Maßstabs und der
	 * bildgränzen ohne Rand sowie das setzen der Pixel in Targetbild
	 */
	public ImagePlus scale(ImagePlus newImage, int[] sa) {
		steuerarray = sa;
		source = newImage;
		ipsource = source.getProcessor();
		set_scale(steuerarray[0] - (2 * steuerarray[1]));
		set_Imagestart(steuerarray[1]);
		target = IJ.createImage("grayvalue image", "8-bit", steuerarray[0], steuerarray[0], 1);
		iptarget = target.getProcessor();
		paint_black();
		for (int h = heightset; h < (target.getHeight() - heightset); h++) {
			for (int w = widthset; w < (target.getWidth() - widthset); w++) {
				set_pixels(h, w);
			}
		}
		return target;
	}

	/*
	 * Setzt einen Pixel von Source nach Target
	 */
	private void set_pixels(int h, int w) {
		int pix = ipsource.getPixel(((int) Math.round((w - widthset) / scaleY)),
				((int) Math.round((h - heightset) / scaleX)));
		iptarget.putPixel(w, h, pix);
	}

	/*
	 * Bemalt das ganze Targetbild Schwarz um nachher keine weißen Ränder zu haben
	 */
	private void paint_black() {
		for (int h = 0; h < target.getHeight(); h++) {
			for (int w = 0; w < target.getWidth(); w++) {
				iptarget.putPixel(w, h, 1);
			}
		}
	}

	/*
	 * Legt den Maßstab fest in dem Skaliert wird
	 */
	private void set_scale(int newsize) {
		int height = source.getHeight();
		int width = source.getWidth();
		if (width > height && steuerarray[21] == 0) {
			scaleX = (((double) newsize) / ((double) width));
			scaleY = (((double) newsize) / ((double) width));
		}
		if (height > width && steuerarray[21] == 0) {
			scaleX = (((double) newsize) / ((double) height));
			scaleY = (((double) newsize) / ((double) height));
		}
		if (height == width || steuerarray[21] == 1) {
			scaleX = (((double) newsize) / ((double) height));
			scaleY = (((double) newsize) / ((double) width));
		}
	}

	/*
	 * Setzt die Werte wo das Bildeingefügt wird, bildet also den Rand so das es am
	 * ende quadratisch ist
	 */
	private void set_Imagestart(int border) {
		int height = source.getHeight();
		int width = source.getWidth();
		if (width > height && steuerarray[21] == 0) {
			heightset = (int) Math.round((((width - height) / 2) * scaleX) + border);
			widthset = border;
		}
		if (height > width && steuerarray[21] == 0) {
			widthset = (int) Math.round((((height - width) / 2) * scaleX) + border);
			heightset = border;
		}
		if (height == width || steuerarray[21] == 1) {
			widthset = border;
			heightset = border;
		}
	}

	public int[] getScalediff() {
		int height = source.getHeight();
		int width = source.getWidth();
		int[] scalediff = new int[2];
		if (width > height && steuerarray[21] == 0) {
			scalediff[0] = (int) Math.round(((width - height) / 2) * scaleX);
			scalediff[1] = 0;
		}
		if (height > width && steuerarray[21] == 0) {
			scalediff[1] = (int) Math.round(((height - width) / 2) * scaleX);
			scalediff[0] = 0;
		}
		if (height == width || steuerarray[21] == 1) {
			scalediff[1] = 0;
			scalediff[0] = 0;
		}
		return scalediff;
	}

	/*
	 * Getter des Skaliermaßstabs
	 */
	public double getScaleX() {
		return scaleX;
	}
	
	public double getScaleY() {
		return scaleY;
	}
}