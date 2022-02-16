import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;

public class Landmark_cut {

	public static ImagePlus cut(ImagePlus source, int x, int y, int r) {
		ImageProcessor ipsource = source.getProcessor();
		ImagePlus target = IJ.createImage("grayvalue image", "8-bit", ((r * 2) + 1), ((r * 2) + 1), 1);
		ImageProcessor iptarget = target.getProcessor();
		int hh=0;
		for (int h = (-r); h <= r; h++) {
			int ww = 0;
			for (int w = (-r); w <= r; w++) {
				int pix = ipsource.getPixel((x+w), (y+h));
				iptarget.putPixel(ww, hh, pix);
				ww++;
			}
			hh++;
		}
		return target;
	}

}
