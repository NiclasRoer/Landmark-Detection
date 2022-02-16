import java.util.ArrayList;

import ij.ImagePlus;
import ij.process.ImageProcessor;

public class Landmark_Part_Pix {

	public static int matchpic(ImagePlus sourceA, ImagePlus sourceB, ArrayList<Integer> xMark, ArrayList<Integer> yMark,
			int range) {
		ImageProcessor ipSourceA = sourceA.getProcessor();
		ImageProcessor ipSourceB = sourceB.getProcessor();
		int count = 100000000;
		for (int i = 0; i < xMark.size(); i++) {
			for (int h = (-range); h <= range; h++) {
				for (int w = (-range); w <= range; w++) {
					count = count - Math.abs(ipSourceA.getPixel(w + xMark.get(i), h + yMark.get(i))
							- ipSourceB.getPixel(w + xMark.get(i), h + yMark.get(i)));
				}
			}
		}
		return count;
	}

}
