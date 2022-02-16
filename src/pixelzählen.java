import ij.ImagePlus;
import ij.process.ImageProcessor;

public class pixelzählen {
	
	public static int[] countpic(ImagePlus img) {
		ImagePlus image =  img;
		ImageProcessor ip = image.getProcessor ();
		
		int[] count = new int[2];
		
		for(int h = 0; h<ip.getHeight();h++) {
			for(int w = 0; w<ip.getWidth(); w++) {
				if(ip.getPixel(h, w)>128) {
					count[0]= count[0]+1;
				}
				else {
					count[1]=count[1]+1;
				}
			}
		}
		return count;
	}

}
