package comandi;

import ambienti.Stanza;
import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

public class ComandoVai implements Comando {
	private String direzione;
	private final static String nome= "vai";
	private IO io;
	
	
	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(direzione==null) {
			io.mostraMessaggio("\nDoveVuoi andare? devi specificare una direzione");
		}
		prossimaStanza=stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza==null) {
			io.mostraMessaggio("\ndireione inesistente");
			return;
		}
		partita.setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}
	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;
	}
	@Override
	public String getParametro() {
		return this.direzione;
	}
	@Override
	public String getNome() {
		return nome;
	}
	
	@Override
	public void setIo(IO io) {
		this.io=io;
	}
}