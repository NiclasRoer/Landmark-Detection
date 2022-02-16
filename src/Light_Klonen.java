import java.util.ArrayList;

public class Light_Klonen {
	
	private ArrayList<AlgoDaten> source;
	private ArrayList<AlgoDaten> target;
	private ArrayList<MatchData> bestmatches;

	public ArrayList<AlgoDaten> getKlonlist(ArrayList<AlgoDaten> source, ArrayList<MatchData> bestmatches, int klone) {
		this.source = source;
		this.bestmatches = bestmatches;
		target = new ArrayList<AlgoDaten>();
		for (int l = 0; l <= klone; l++) {
			for (int i = 0; i < bestmatches.size(); i++) {
				klon(i);
			}
		}
		return target;
	}

	private void klon(int i) {
		MatchData m = bestmatches.get(i);
		AlgoDaten born = source.get(m.getPrüf());
		born.setName(m.getBase());
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
