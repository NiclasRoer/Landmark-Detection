import java.util.ArrayList;

import ij.ImagePlus;

public class Mutation {

	public ArrayList<AlgoDaten> get_Mutants(ArrayList<AlgoDaten> algo_lib, int howmanymatches, int grade) {
		for (int i = howmanymatches; i < (howmanymatches * 2); i++) {
			AlgoDaten d = algo_lib.get(i);
			Rotation rot = new Rotation();
			ImagePlus ii = rot.turn(d.getbin_n_cut_Pic(), grade);
			d.setGrade(grade);
			d.setbin_n_cut_Pic(ii);
			algo_lib.set(i, d);
		}
		for (int i = (howmanymatches * 2); i < (howmanymatches * 3); i++) {
			AlgoDaten d = algo_lib.get(i);
			Rotation rot = new Rotation();
			ImagePlus ii = rot.turn(d.getbin_n_cut_Pic(), (0 - grade));
			d.setGrade(0 -grade);
			d.setbin_n_cut_Pic(ii);
			algo_lib.set(i, d);
		}
		return algo_lib;
	}
}