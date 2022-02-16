import java.util.ArrayList;

public class The_first_time {
	
	public static ArrayList<AlgoDaten> translate(ArrayList<Datensatz> source){
		ArrayList<AlgoDaten> target = new ArrayList<AlgoDaten>();
		for(int i = 0; i < source.size(); i++) {
			target.add(new AlgoDaten(source.get(i), i));
		}
		return target;
	}
	public static ArrayList<AlgoDaten> translate2(ArrayList<Datensatz> source, int grade){
		ArrayList<AlgoDaten> target = new ArrayList<AlgoDaten>();
		for(int i = 0; i < source.size(); i++) {
			target.add(new AlgoDaten(source.get(i), i, grade));
		}
		return target;
	}
}