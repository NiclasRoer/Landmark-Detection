
import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;

public class Cuting {

	/**
	 * Datenfelder der Klasse
	 */
	private int[] cut; // 0= obere ; 1=linke ; 2=untere ; 3=rechte ; die werte sind die zeilen mit dem
						// ersten weißen pixel
	private ImageProcessor ipsource_bin;
	private ImagePlus source_bin;
	private ImageProcessor ipsource_ori;
	private ImagePlus source_ori;
	private ImageProcessor iptarget;
	private ImagePlus target;

	/**
	 * Übergeordnete Startmethode
	 */
	public ImagePlus cut(ImagePlus newImage) {
		source_bin = newImage;
		ipsource_bin = source_bin.getProcessor();
		cut = new int[4];

		/*
		 * Setzen der Grenzen bis wohin schwarz reicht
		 */
		set_upper_border();
		set_left_border();
		set_down_border();
		set_right_border();

		/*
		 * Ausrechen der neuen Höhe und Breite führs Zielbild
		 */
		int newWidth = ipsource_bin.getWidth() - (cut[1] + (ipsource_bin.getWidth() - cut[3]) - 1);
		int newHeight = ipsource_bin.getHeight() - (cut[0] + (ipsource_bin.getHeight() - cut[2]) - 1);

		/*
		 * Erstellen des neuen Bildes
		 */
		target = IJ.createImage("grayvalue image", "8-bit", newWidth, newHeight, 1);
		iptarget = target.getProcessor();

		/*
		 * Durchläuft alle Pixel des Sourcebildes ohne die schwarzen Ränder und lässt
		 * diese ins Targetbild schreiben
		 */
		int htarget = 0;
		for (int h = cut[0]; h <= cut[2]; h++) {
			int wtarget = 0;
			for (int w = cut[1]; w <= cut[3]; w++) {
				set_target_Pixel_bin(htarget, h, wtarget, w);
				wtarget++;
			}
			htarget++;
		}
		return target;
	}

	/**
	 * Übergeordnete Startmethode2 arbeitet mit originalbild
	 */
	public ImagePlus cut2(ImagePlus newImage_bin, ImagePlus newImage_ori) {
		source_bin = newImage_bin;
		ipsource_bin = source_bin.getProcessor();
		source_ori = newImage_ori;
		ipsource_ori = source_ori.getProcessor();
		cut = new int[4];

		/*
		 * Setzen der Grenzen bis wohin schwarz reicht
		 */
		set_upper_border();
		set_left_border();
		set_down_border();
		set_right_border();

		/*
		 * Ausrechen der neuen Höhe und Breite führs Zielbild
		 */
		int newWidth = ipsource_bin.getWidth() - (cut[1] + (ipsource_bin.getWidth() - cut[3]) - 1);
		int newHeight = ipsource_bin.getHeight() - (cut[0] + (ipsource_bin.getHeight() - cut[2]) - 1);

		/*
		 * Erstellen des neuen Bildes
		 */
		target = IJ.createImage("grayvalue image", "8-bit", newWidth, newHeight, 1);
		iptarget = target.getProcessor();

		/*
		 * Durchläuft alle Pixel des Sourcebildes ohne die schwarzen Ränder und lässt
		 * diese ins Targetbild schreiben
		 */
		int htarget = 0;
		for (int h = cut[0]; h <= cut[2]; h++) {
			int wtarget = 0;
			for (int w = cut[1]; w <= cut[3]; w++) {
				set_target_Pixel_ori(htarget, h, wtarget, w);
				wtarget++;
			}
			htarget++;
		}
		return target;
	}

	/**
	 * Nimmt Pixel aus Source_bin und schreibt sie in Target
	 */
	private void set_target_Pixel_bin(int htarget, int h, int wtarget, int w) {
		int pix = ipsource_bin.getPixel(w, h);
		iptarget.putPixel(wtarget, htarget, pix);
	}

	/**
	 * Nimmt Pixel aus Source_ori und schreibt sie in Target
	 */
	private void set_target_Pixel_ori(int htarget, int h, int wtarget, int w) {
		int pix = ipsource_ori.getPixel(w, h);
		iptarget.putPixel(wtarget, htarget, pix);
	}

	/**
	 * Sucht den rechten Startwert des Bildes ohne schwarzen Rand
	 */
	private void set_right_border() {
		for (int w = ipsource_bin.getWidth(); w > 0; w--) {
			for (int h = 0; h < ipsource_bin.getHeight(); h++) {
				int pix = ipsource_bin.getPixel(w, h);
				if (pix > 128) {
					cut[3] = w;
					break;
				}
			}
			if (cut[3] != 0) {
				break;
			}
		}
	}

	/**
	 * Sucht den unteren Startwert des Bildes ohne schwarzen Rand
	 */
	private void set_down_border() {
		for (int h = ipsource_bin.getHeight(); h > 0; h--) {
			for (int w = 0; w < ipsource_bin.getWidth(); w++) {
				int pix = ipsource_bin.getPixel(w, h);
				if (pix > 128) {
					cut[2] = h;
					break;
				}
			}
			if (cut[2] != 0) {
				break;
			}
		}
	}

	/**
	 * Sucht den linken Startwert des Bildes ohne schwarzen Rand
	 */
	private void set_left_border() {
		for (int w = 0; w < ipsource_bin.getWidth(); w++) {
			for (int h = 0; h < ipsource_bin.getHeight(); h++) {
				int pix = ipsource_bin.getPixel(w, h);
				if (pix > 128) {
					cut[1] = w;
					break;
				}
			}
			if (cut[1] != 0) {
				break;
			}
		}
	}

	/**
	 * Sucht den oberen Startwert des Bildes ohne schwarzen Rand
	 */
	private void set_upper_border() {
		for (int h = 0; h < ipsource_bin.getHeight(); h++) {
			for (int w = 0; w < ipsource_bin.getWidth(); w++) {
				int pix = ipsource_bin.getPixel(w, h);
				if (pix > 128) {
					cut[0] = h;
					break;
				}
			}
			if (cut[0] != 0) {
				break;
			}
		}
	}

	/*
	 * Getter für das Array in dem die Grenzen abgespeichert werden
	 */
	public int[] get_borders() {
		return cut;
	}
}