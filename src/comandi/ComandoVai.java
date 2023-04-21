package comandi;

import ambienti.Stanza;
import diadia.Partita;

public class ComandoVai implements Comando {
	private String direzione;
	
	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(direzione==null) {
			System.out.println("\nDoveVuoi andare? devi specificare una direzione");
		}
		prossimaStanza=stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza==null) {
			System.out.println("\ndireione inesistente");
			return;
		}
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		System.out.println(partita.getLabirinto().getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}
	@Override
	public void setParametro(String parametro) {
		this.direzione=parametro;
	}
}