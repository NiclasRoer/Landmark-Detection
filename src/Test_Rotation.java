import java.util.ArrayList;

public class Test_Rotation {
	
	public static ArrayList<Datensatz> turn(ArrayList<Datensatz> sourcebank){
		for(int i = 0; i<sourcebank.size(); i++) {
			Rotation rot = new Rotation();
			Datensatz d = sourcebank.get(i);
			d.setori_Pic(rot.turn(d.getori_Pic(), 20));
			sourcebank.set(i, d);
		}
		return sourcebank;
	}

}
