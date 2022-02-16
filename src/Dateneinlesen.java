
	import java.io.BufferedReader;
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.StringTokenizer;

import ij.ImagePlus;
import imagelib.ImageUtil;
	// Klasse zum Einlesen der Textdateien
	public class Dateneinlesen {

		private static ArrayList<Datensatz> datenbank;
		
		public static ArrayList<Datensatz> einlesen(String datName, String picPfad, String picTyp) throws NumberFormatException, IOException {
			BufferedReader in = new BufferedReader(new FileReader(datName));
			String line = null;
			datenbank = new ArrayList<Datensatz>();
			while ((line = in.readLine()) != null) {
				datenbank.add(fromLine(line));
			}
			in.close();
			bild_einlesen(picPfad, picTyp);
			return datenbank;
		}

		private static Datensatz fromLine(String line) {
			StringTokenizer st = new StringTokenizer(line, " ");
			Datensatz splitt_line = new Datensatz();
			// Speichern der Klasse und Konvertieren von String zu Double??
				for (int k = 0; k < 19; k++) {
					for (int i = 1; i < 3; i++) {
						splitt_line.setLandmark(Integer.parseInt(st.nextToken()), i);
					}
				}
			return splitt_line;
		}
		private static void bild_einlesen(String picPfad, String picTyp) {
			
			try {
				for(int i = 1; i<=datenbank.size(); i++) {
					ImagePlus image = ImageUtil.loadGrayscale(picPfad+i+picTyp);
					Datensatz data = datenbank.get(i-1);
					data.setori_Pic(image);  
					datenbank.set(i-1, data);
				}
				
			} catch (Exception e) {	
				e.printStackTrace();
			}
		}
	}