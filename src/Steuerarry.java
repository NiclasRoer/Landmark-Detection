
public class Steuerarry {
	public static int[] sa;
	
	public static int[] get_array() {
		sa = new int[30];
		sa[0] = 1000; //Bildgröße
		sa[1] = 125; //Neuer Rand
		sa[3] = 8; //Setzt grade startwert fest
		sa[4] = 16; //Vorabhinzufügen von gedrehten Bildern,0= aus, >0 ein, sa[4] legt grade für erste Rotation fest
		sa[6] = 25; //Prozenangabe wieviel behalten werden soll bei Selektion
		sa[7] = 2; //Anzahl der erstellten Klone im rotier Gen
		sa[10] = 0; //Kontroll-Konsolenausgabe; 0 = aus; 1 = ein
		sa[14] = 8; //Anzahl der erstellten Klone im move Gen
		sa[15] = 16; //im Pre_Fix; Vorabhinzufügen von gedrehten Bildern,0= aus, >0 ein, sa[15] legt grade für erste Rotation fest
		sa[16] = 8; //Setzt im Pre_Fix grade startwert fest
		sa[17] = 10; //im Pre_Fix wieviel behalten werden soll bei Selektion
		
			sa[18] = 4; //Filterradius für MatrixFactor
			
			sa[12] = 50; //Radius für einzelLandmarkenüberprüfung PreFix
			
			sa[8] = 100; // Grenzwert für Kantendetektor
			
			sa[9] = 0; //Bin Grenzwert, 0= automatische zuweisung, >0 bei sa9 wird getrennt
			
		sa[13] = 0; //Art der Light_Evaluation
		sa[5] = 0; //Art der Evaluation, 0 = Differenz der Pixel, 1 = Vergleich der Pixel, 2 = Differenz der Pixel im Bereich der Landmarken
		sa[11] = 50; //Range für Landmark_Part_Pix; sa5 = 2
		
		sa[19] = 4; // legt algorythmus fest und stellt Postfix an und aus
		
		sa[20] = 2; //setzt wert aus Testdaten
		
		sa[21] = 0; // Skaliert bilder von X*Y zu X*X
		
		sa[2] = 1; //0= Algorithmen arbeiten mit Bin_Bild, 1 = Ori_Bild
		return sa;
	}

}
