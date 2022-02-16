import java.util.ArrayList;

import ij.IJ;
import ij.ImagePlus;
import ij.process.ImageProcessor;

public class Translate {

	public static Datensatz trans(ArrayList<int[]> werte, ArrayList<Datensatz> baseData, int[] sa) {
		Datensatz target = new Datensatz();
		for (int i = 0; i < werte.size(); i++) {
			int[] wert = werte.get(i);
			Datensatz d = baseData.get(wert[0]);
			int x = (int) d.getnewLandmark(i, 1);
			int y = (int) d.getnewLandmark(i, 2);
			if(sa[19] == 3||sa[19]==4) {
			x = x + wert[2];
			y = y + wert[3];
			}
			if (wert[1] != 0) {
				ImagePlus img = IJ.createImage("grayvalue image", "8-bit", sa[0], sa[0], 1);
				ImageProcessor ipimg = img.getProcessor();
				ipimg.putPixel(x, y, 0);
				ipimg.rotate(-wert[1]);
				for (int h = 0; h < sa[0]; h++) {
					for (int w = 0; w < sa[0]; w++) {
						if (ipimg.getPixel(w, h) < 128) {
							target.setnewLandmark(w, 1);
							target.setnewLandmark(h, 2);
							target.setLandmark(2, 1);
						}
					}
				}
			} else { 
				
			target.setnewLandmark(x, 1);
			target.setnewLandmark(y, 2);
			target.setLandmark(1, 1);
			}
		}
		return target;
	}

}
