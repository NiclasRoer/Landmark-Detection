import java.util.ArrayList;

import ij.ImagePlus;

public class Light_Mutation {
	
	public ArrayList<AlgoDaten> get_rotierte_Mutants(ArrayList<AlgoDaten> algo_lib, int howmanymatches, int grade) {
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
	
	public ArrayList<AlgoDaten> get_moved_Mutants(ArrayList<AlgoDaten> algo_lib, int howmanymatches, int way){
		for (int i = howmanymatches; i < (howmanymatches * 2); i++) {
			AlgoDaten d = algo_lib.get(i);
			Mover mo = new Mover();
			ImagePlus ii = mo.move(d.getbin_n_cut_Pic(), way, 0);
			d.setXway(way);
			d.setYway(0);
			d.setbin_n_cut_Pic(ii);
			algo_lib.set(i, d);
		}
		for (int i = (howmanymatches * 2); i < (howmanymatches * 3); i++) {
			AlgoDaten d = algo_lib.get(i);
			Mover mo = new Mover();
			ImagePlus ii = mo.move(d.getbin_n_cut_Pic(), way, way);
			d.setXway(way);
			d.setYway(way);
			d.setbin_n_cut_Pic(ii);
			algo_lib.set(i, d);
		}
		for (int i = (howmanymatches * 3); i < (howmanymatches * 4); i++) {
			AlgoDaten d = algo_lib.get(i);
			Mover mo = new Mover();
			ImagePlus ii = mo.move(d.getbin_n_cut_Pic(), 0, way);
			d.setXway(0);
			d.setYway(way);
			d.setbin_n_cut_Pic(ii);
			algo_lib.set(i, d);
		}
		for (int i = (howmanymatches * 4); i < (howmanymatches * 5); i++) {
			AlgoDaten d = algo_lib.get(i);
			Mover mo = new Mover();
			ImagePlus ii = mo.move(d.getbin_n_cut_Pic(), (-way), way);
			d.setXway((-way));
			d.setYway(way);
			d.setbin_n_cut_Pic(ii);
			algo_lib.set(i, d);
		}
		for (int i = (howmanymatches * 5); i < (howmanymatches * 6); i++) {
			AlgoDaten d = algo_lib.get(i);
			Mover mo = new Mover();
			ImagePlus ii = mo.move(d.getbin_n_cut_Pic(), (-way), 0);
			d.setXway((-way));
			d.setYway(0);
			d.setbin_n_cut_Pic(ii);
			algo_lib.set(i, d);
		}
		for (int i = (howmanymatches * 6); i < (howmanymatches * 7); i++) {
			AlgoDaten d = algo_lib.get(i);
			Mover mo = new Mover();
			ImagePlus ii = mo.move(d.getbin_n_cut_Pic(), (-way), (-way));
			d.setXway((-way));
			d.setYway((-way));
			d.setbin_n_cut_Pic(ii);
			algo_lib.set(i, d);
		}
		for (int i = (howmanymatches * 7); i < (howmanymatches * 8); i++) {
			AlgoDaten d = algo_lib.get(i);
			Mover mo = new Mover();
			ImagePlus ii = mo.move(d.getbin_n_cut_Pic(), 0, (-way));
			d.setXway(0);
			d.setYway((-way));
			d.setbin_n_cut_Pic(ii);
			algo_lib.set(i, d);
		}
		for (int i = (howmanymatches * 8); i < (howmanymatches * 9); i++) {
			AlgoDaten d = algo_lib.get(i);
			Mover mo = new Mover();
			ImagePlus ii = mo.move(d.getbin_n_cut_Pic(), way, (-way));
			d.setXway(way);
			d.setYway((-way));
			d.setbin_n_cut_Pic(ii);
			algo_lib.set(i, d);
		}
		return algo_lib;
	}

}
