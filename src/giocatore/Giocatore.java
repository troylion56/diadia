package giocatore;

public class Giocatore {
	
	private int cfu;
	private Borsa borsa;
	
	public Giocatore() {
		final int CFU_INIZIALI = 20;
		this.cfu=CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	public void setBorsa(Borsa borsa) {
		this.borsa=borsa;
	}
}
