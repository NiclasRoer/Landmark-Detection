
public class New_Landmark_fix {

	public Datensatz fix_landmark(Datensatz source) {

		for (int i = 0; i < source.getLandmark_size(); i++) {
			int mark = (int) source.getLandmark(i, 1);
			int[] b = source.getBorders();
			mark = mark - b[1];
			mark = (int) Math.round(mark * source.getScaleY());
			int[] scalediff = source.getScalediff();
			mark = mark + source.getNew_border() + scalediff[1];
			source.setnewLandmark(mark, 1);
		}

		for (int i = 0; i < source.getLandmark_size(); i++) {
			int mark = (int) source.getLandmark(i, 2);
			int[] b = source.getBorders();
			mark = mark - b[0];
			mark = (int) Math.round(mark * source.getScaleX());
			int[] scalediff = source.getScalediff();
			mark = mark + source.getNew_border() + scalediff[0];
			source.setnewLandmark(mark, 2);
		}
		return source;
	}
}