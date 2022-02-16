import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;

public class Mover {

	public ImagePlus move(ImagePlus source, int xway, int yway) {
		ImageProcessor ipSource = source.getProcessor();
		ImagePlus target = IJ.createImage("grayvalue image", "8-bit", ipSource.getWidth(), ipSource.getHeight(), 1);
		ImageProcessor ipTarget = target.getProcessor();
		for (int h = 0; h < source.getHeight(); h++) {
			for (int w = 0; w < source.getWidth(); w++) {
				ipTarget.putPixel(w, h, 0);
			}
		}
		for (int h = yway; h < source.getHeight(); h++) {
			for (int w = xway; w < source.getWidth(); w++) {
				int pix = ipSource.getPixel(w, h);
				ipTarget.putPixel(w, h, pix);
			}
		}
		return target;
	}

}
