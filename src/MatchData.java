
public class MatchData {
	
	private int match;
	private int base;
	private int pr?f;
	
	public MatchData() {
		
	}
	public MatchData(MatchData d) {
		this.base = d.base;
		this.match = d.match;
		this.pr?f = d.pr?f;
	}
	
	
	public int getMatch() {
		return match;
	}
	public void setMatch(int match) {
		this.match = match;
	}
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public int getPr?f() {
		return pr?f;
	}
	public void setPr?f(int pr?f) {
		this.pr?f = pr?f;
	}
	

}
