
public class MatchData {
	
	private int match;
	private int base;
	private int prüf;
	
	public MatchData() {
		
	}
	public MatchData(MatchData d) {
		this.base = d.base;
		this.match = d.match;
		this.prüf = d.prüf;
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
	public int getPrüf() {
		return prüf;
	}
	public void setPrüf(int prüf) {
		this.prüf = prüf;
	}
	

}
