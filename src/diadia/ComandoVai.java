package diadia;
import ambienti.Labirinto;
import ambienti.Stanza;

public class ComandoVai implements Comando {
	private String direzione;

	public ComandoVai(String direzione) {
		this.direzione = direzione;
	}

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza=null;
		if(direzione==null) {
			System.out.println("Dove vuoi andare? devi specificare una direzione");
			return;
		}
		prossimaStanza =stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza==null) {
			System.out.println("Direzione inesistente");
			return;
		}
		Labirinto labirtinto;
		partita.;;
	}

}
