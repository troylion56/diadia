package diadia;

import ambienti.Labirinto;
import giocatore.Giocatore;

public class Partita {

	private Labirinto labirinto;
	private Giocatore giocatore;
	private boolean finita;
	private IOConsole io;
	
	
	public Partita(IOConsole io){
		labirinto= new Labirinto();
		giocatore= new Giocatore();
		labirinto.creaStanze();
		this.io=io;
		this.finita = false;
	}
	
	public Labirinto getLabirinto() {
		return labirinto;
	}
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}
	
	
	/*Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta*/
	public boolean vinta() {
		return labirinto.getStanzaCorrente()== labirinto.getStanzaVincente();
	}

	/*Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita*/
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/*Imposta la partita come finita*/
	public void setFinita() {
		this.finita = true;
	}

	public IOConsole getIo() {
		return io;
	}

	public void setIo(IOConsole io) {
		this.io = io;
	}

	
}
