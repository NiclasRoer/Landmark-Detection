import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;

public class Rotation {
	
	public ImagePlus turn(ImagePlus source, int grade) {
		ImageProcessor ipSource = source.getProcessor();
		ImagePlus target = IJ.createImage("grayvalue image", "8-bit", ipSource.getWidth(), ipSource.getHeight(), 1);
		ImageProcessor ipTarget = target.getProcessor();
		for(int h = 0; h < source.getHeight(); h++) {
			for(int w = 0; w < source.getWidth(); w++) {
				int pix = ipSource.getPixel(w,h);
				ipTarget.putPixel(w, h, pix);
			}
		}
		ipTarget.rotate(grade);
		for(int h = 0; h < target.getHeight(); h++) {
			for(int w = 0; w < target.getWidth(); w++) {
				if(ipTarget.getPixel(w, h)>=128) {
					ipTarget.putPixel(w, h, 0);
				}
				else {
					break;
				}
			}
		}
		for(int h = 0; h < target.getHeight(); h++) {
			for(int w = target.getWidth()-1; w > 0; w--) {
				if(ipTarget.getPixel(w, h)>=128) {
					ipTarget.putPixel(w, h, 0);
				}
				else {
					break;
				}
			}
		}
		return target;
	}
}