import java.util.ArrayList;

public class Klonen {

	private ArrayList<AlgoDaten> source;
	private ArrayList<AlgoDaten> target;
	private int[] bestmatches;

	public ArrayList<AlgoDaten> getKlonlist(ArrayList<AlgoDaten> source, int[] bestmatches, int klone) {
		this.source = source;
		this.bestmatches = bestmatches;
		target = new ArrayList<AlgoDaten>();
		for (int l = 0; l <= klone; l++) {
			for (int i = 0; i < bestmatches.length; i++) {
				klon(i);
			}
		}
		return target;
	}

	private void klon(int i) {
		AlgoDaten born = source.get(bestmatches[i]);
		target.add(new AlgoDaten(born));
	}

	public ArrayList<AlgoDaten> getfirstKlonlist(ArrayList<AlgoDaten> source, int klone) {
		this.source = source;
		target = new ArrayList<AlgoDaten>();
		for (int l = 0; l <= klone; l++) {
			for (int i = 0; i < source.size(); i++) {
				firstklon(i);
			}
		}
		return target;
	}

	private void firstklon(int i) {
		AlgoDaten born = source.get(i);
		target.add(new AlgoDaten(born));
	}
}