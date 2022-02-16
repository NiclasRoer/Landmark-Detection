
import java.util.ArrayList;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;
import imagelib.ImageUtil;

public class Zeichnen {

	public static void zeichnen1(Datensatz d) {
		ImagePlus img = d.getbin_n_cut_Pic();
		ImageProcessor ipimg = img.getProcessor();
		ImagePlus target = IJ.createImage("color target image", "RGB black", ipimg.getWidth(), ipimg.getHeight(), 1);
		ImageProcessor ipTarget = target.getProcessor();
		for (int w = 0; w < ipimg.getWidth(); w++) {
			for (int h = 0; h < ipimg.getHeight(); h++) {
				int[] newRgbValues = new int[3];
				for (int k = 0; k < 3; k++) {
					newRgbValues[k] = ipimg.getPixel(w, h);
				}
				ipTarget.putPixel(w, h, newRgbValues);
			}
		}
		for (int l = 0; l < d.getLandmark_size(); l++) {
			int[] newRgbValuesred = new int[3];
			newRgbValuesred[0] = 255;
			newRgbValuesred[1] = 0;
			newRgbValuesred[2] = 0;
			int x = (int) d.getnewLandmark(l, 1);
			int y = (int) d.getnewLandmark(l, 2);
			for (int ww = -1; ww < 2; ww++) {
				for (int hh = -1; hh < 2; hh++) {
					ipTarget.putPixel(x + hh, y + ww, newRgbValuesred);
				}
			}
		}
		ImageUtil.show(target);
	}

	public static void zeichnen2(Datensatz d, Datensatz dd) {
		ImagePlus img = dd.getbin_n_cut_Pic();
		ImageProcessor ipimg = img.getProcessor();
		ImagePlus target = IJ.createImage("color target image", "RGB black", ipimg.getWidth(), ipimg.getHeight(), 1);
		ImageProcessor ipTarget = target.getProcessor();
		for (int w = 0; w < ipimg.getWidth(); w++) {
			for (int h = 0; h < ipimg.getHeight(); h++) {
				int[] newRgbValues = new int[3];
				for (int k = 0; k < 3; k++) {
					newRgbValues[k] = ipimg.getPixel(w, h);
				}
				ipTarget.putPixel(w, h, newRgbValues);
			}
		}
		for (int l = 0; l < d.getLandmark_size(); l++) {
			int[] newRgbValuesred = new int[3];
			newRgbValuesred[0] = 255;
			newRgbValuesred[1] = 0;
			newRgbValuesred[2] = 0;
			int x = (int) d.getnewLandmark(l, 1);
			int y = (int) d.getnewLandmark(l, 2);
			for (int ww = -1; ww < 2; ww++) {
				for (int hh = -1; hh < 2; hh++) {
					ipTarget.putPixel(x + hh, y + ww, newRgbValuesred);
				}
			}
		}
		ImageUtil.show(target);
	}

	public static void zeichnen3(ArrayList<int[]> finalmarks, ImagePlus img) {
		ImageProcessor ipimg = img.getProcessor();
		ImagePlus target = IJ.createImage("color target image", "RGB black", ipimg.getWidth(), ipimg.getHeight(), 1);
		ImageProcessor ipTarget = target.getProcessor();

		for (int h = 0; h < ipimg.getHeight(); h++) {
			for (int w = 0; w < ipimg.getWidth(); w++) {
				int[] newRgbValues = new int[3];
				for (int k = 0; k < 3; k++) {
					newRgbValues[k] = ipimg.getPixel(w, h);
				}
				ipTarget.putPixel(w, h, newRgbValues);
			}
		}
		for (int l = 0; l < finalmarks.size(); l++) {
			int[] mark = finalmarks.get(l);
			int[] newRgbValuesred = new int[3];
			newRgbValuesred[0] = 255;
			newRgbValuesred[1] = 0;
			newRgbValuesred[2] = 0;
			int x = mark[0];
			int y = mark[1];
			for (int ww = -1; ww < 2; ww++) {
				for (int hh = -1; hh < 2; hh++) {
					ipTarget.putPixel(x + hh, y + ww, newRgbValuesred);
				}
			}
		}
		ImageUtil.show(target);
	}
}