package giocatore;

public class Giocatore {
	
	private int cfu;
	
	public Giocatore() {
		final int CFU_INIZIALI = 20;
		this.cfu=CFU_INIZIALI;
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}	
}
