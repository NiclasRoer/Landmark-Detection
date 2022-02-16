import java.util.ArrayList;

public class Back_Transformation {

	public static ArrayList<int[]> bt(Datensatz marks, Datensatz source) {
		ArrayList<Integer> neueX = marks.getganzeneueLandmarkenX();
		ArrayList<Integer> neueY = marks.getganzeneueLandmarkenY();
		ArrayList<int[]> btmarks = new ArrayList<int[]>();
		for (int i = 0; i < neueX.size(); i++) {
			int[] newmark = new int[2];
			int mark = (int) neueX.get(i);
			int[] scalediff = source.getScalediff();
			mark = mark - (source.getNew_border() + scalediff[1]);
			mark = (int) Math.round(mark / source.getScaleY());
			int[] b = source.getBorders();
			mark = mark + b[1];
			newmark[0] = mark;
			mark = (int) neueY.get(i);
			mark = mark - (source.getNew_border() + scalediff[0]);
			mark = (int) Math.round(mark / source.getScaleX());
			mark = mark + b[0];
			newmark[1] = mark;
			btmarks.add(newmark);
		}
		return btmarks;
	}
	public static ArrayList<int[]> bt2(ArrayList<int[]> marks, Datensatz source) {
		
		
		ArrayList<int[]> btmarks = new ArrayList<int[]>();
		for (int i = 0; i < marks.size(); i++) {
			int[] alteMark = marks.get(i);
			int[] newmark = new int[2];
			int mark = alteMark[0];
			int[] scalediff = source.getScalediff();
			mark = mark - (source.getNew_border() + scalediff[1]);
			mark = (int) Math.round(mark / source.getScaleY());
			int[] b = source.getBorders();
			mark = mark + b[1];
			newmark[0] = mark;
			mark = alteMark[1];
			mark = mark - (source.getNew_border() + scalediff[0]);
			mark = (int) Math.round(mark / source.getScaleX());
			mark = mark + b[0];
			newmark[1] = mark;
			btmarks.add(newmark);
		}
		return btmarks;
	}
}
