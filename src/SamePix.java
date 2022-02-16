import ij.ImagePlus;
import ij.process.ImageProcessor;

public class SamePix {

	public static int matchpic(ImagePlus sourceA, ImagePlus sourceB) {
		ImageProcessor ipSourceA = sourceA.getProcessor();
		ImageProcessor ipSourceB = sourceB.getProcessor();
		int count = 0;
		for (int h = 0; h < sourceA.getHeight(); h++) {
			for (int w = 0; w < sourceB.getWidth(); w++) {
				if (ipSourceA.getPixel(w, h) == ipSourceB.getPixel(w, h))
					count++;
			}
		}
		return count;
	}
}