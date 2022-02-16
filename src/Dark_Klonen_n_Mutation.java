import java.util.ArrayList;

public class Dark_Klonen_n_Mutation {
	public ArrayList<int[]> get_Dark_Klonelist(ArrayList<int[]> source, int count) {
		int[] center = source.get(0);

		for (int i = (-count); i < count; i++) {
			int[] mark = new int[2];
			mark[0] = center[0] + count;
			mark[1] = center[1] + i;
			source.add(mark);
		}
		for (int i = (-count); i < count; i++) {
			int[] mark = new int[2];
			mark[0] = center[0] + i;
			mark[1] = center[1] + count;
			source.add(mark);
		}
		for (int i = count; i > -count; i--) {
			int[] mark = new int[2];
			mark[0] = center[0] + count;
			mark[1] = center[1] + i;
			source.add(mark);
		}
		for (int i = count; i > -count; i--) {
			int[] mark = new int[2];
			mark[0] = center[0] + i;
			mark[1] = center[1] + count;
			source.add(mark);
		}

		return source;
	}
}
