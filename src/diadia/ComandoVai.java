package diadia;
import ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;
	private IOConsole io;
	private Partita partita;

	public ComandoVai(String direzione) {
		this.direzione = direzione;
	}

	/*esecuzione del comando*/
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza=null;
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare? devi specificare una direzione");
			return;
		}
		prossimaStanza =stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza==null) {
			io.mostraMessaggio("Direzione inesistente");
			return;
		}
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}

}

