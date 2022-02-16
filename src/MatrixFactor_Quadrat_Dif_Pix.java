import ij.ImagePlus;
import ij.process.ImageProcessor;

public class MatrixFactor_Quadrat_Dif_Pix {

	public static int matchpic(ImagePlus sourceA, ImagePlus sourceB, int size) {
		ImageProcessor ipSourceA = sourceA.getProcessor();
		ImageProcessor ipSourceB = sourceB.getProcessor();
		double count = 2147400000;

		for (int h = size; h < (sourceA.getHeight() - size); h = h + (size * 2 + 1)) {
			for (int w = size; w < (sourceB.getWidth() - size); w = w + (size * 2 + 1)) {
				double pixcount = 0;
				for (int i = (h - size); i < (h + size); i++) {
					for (int l = (w - size); l < (w + size); l++) {
						pixcount = (pixcount + Math.abs(ipSourceA.getPixel(l, i) - ipSourceB.getPixel(l, i)));
					}
				}
				pixcount = Math.pow(pixcount, 2);
				count = (count - (int) pixcount);
			}
		}
		//System.out.println(count);
		return (int) count;
	}

}
