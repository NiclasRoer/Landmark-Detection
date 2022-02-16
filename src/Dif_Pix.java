import ij.ImagePlus;
import ij.process.ImageProcessor;

public class Dif_Pix {

	public static int matchpic(ImagePlus sourceA, ImagePlus sourceB) {
		ImageProcessor ipSourceA = sourceA.getProcessor();
		ImageProcessor ipSourceB = sourceB.getProcessor();
		int count = 100000000;
		for (int h = 0; h < sourceA.getHeight(); h++) {
			for (int w = 0; w < sourceB.getWidth(); w++) {
				count = count - Math.abs(ipSourceA.getPixel(w, h) - ipSourceB.getPixel(w, h));
			}
		}
		return count;
	}

}
