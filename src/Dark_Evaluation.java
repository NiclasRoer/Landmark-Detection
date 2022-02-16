import java.util.ArrayList;

import ij.ImagePlus;

public class Dark_Evaluation {

	public int[] auf_Kante(ImagePlus source, ArrayList<int[]> mark, int[] steuerarray) {
		int[] result = new int[3];
		for (int i = 0; i < mark.size(); i++) {
			int[] m = mark.get(i);
			int k = Kantendetektor.kandendetektion(source, m);
			if (k > steuerarray[8]) {
				result[2] = 1;
				result[0] = m[0];
				result[1] = m[1];
				break;
			} else {
				result[2] = 0;
			}
		}
		return result;
	}
}
