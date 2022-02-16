import ij.ImagePlus;
import ij.process.ImageProcessor;

public class Kantendetektor {

	public static int kandendetektion(ImagePlus source, int[] mark) {
		ImageProcessor ipSource = source.getProcessor();
		int[] matrix = new int[9];
		int count = 0;
		for (int h = -1; h < 2; h++) {
			for (int w = -1; w < 2; w++) {
				int pix = ipSource.getPixel(mark[0] + w, mark[1] + h);
				matrix[count] = pix;
				count++;
			}
		}
		int[] prepmatrix = filterprep(matrix);
		int summe = 0;
		for (int i = 0; i < prepmatrix.length; i++) {
			summe = summe + prepmatrix[i];
		}
		return summe;
	}

	private static int[] filterprep(int[] matrix) {
		matrix[0] = matrix[0] * (-1);
		matrix[1] = matrix[1] * (-1);
		matrix[2] = matrix[2] * (-1);
		matrix[3] = matrix[3] * (-1);
		matrix[4] = matrix[4] * (8);
		matrix[5] = matrix[5] * (-1);
		matrix[6] = matrix[6] * (-1);
		matrix[7] = matrix[7] * (-1);
		matrix[8] = matrix[8] * (-1);
		return matrix;
	}
}
