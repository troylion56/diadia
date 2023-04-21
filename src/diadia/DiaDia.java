package diadia;
import java.util.Scanner;

import ambienti.Stanza;
import attrezzi.Attrezzo;
import comandi.Comando;



/*Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 Questa e' la classe principale crea e istanzia tutte le altre*/

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	private Partita partita;
	private IOConsole io;
	
	public DiaDia (IOConsole console) {
		this.io=console;
		this.partita=new Partita();
	}

	public void gioca() {
		String istruzione; 

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
				comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			System.out.println("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			System.out.println("Hai esaurito i CFU...");
		return this.partita.isFinita();
	}


	/*************************************************************************************************/
	/*Cerca di andare in una direzione. Se c'e' una stanza ci entra  e ne stampa il nome, altrimenti stampa un messaggio di errore*/
	private void vai(String direzione) {
		if(direzione==null) {
			io.mostraMessaggio("Dove vuoi andare?");
			direzione=io.leggiRiga();
		}
		else {
			Stanza prossimaStanza = null;
			prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
			if (prossimaStanza == null)
				io.mostraMessaggio("Direzione inesistente");
			else {
				this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
				int cfu = this.partita.getGiocatore().getCfu();
				this.partita.getGiocatore().setCfu(cfu--);
			}
			io.mostraMessaggio("Stanza corrente:");
			io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		}
	}
	/*************************************************************************************************/
	
	/********************************************POSA*************************************************/
	public void posa(String attrezzoDaPosare) {
		if(attrezzoDaPosare==null)
			io.mostraMessaggio("che cosa vuoi rimuovere?");
		else {
			Attrezzo a= partita.getLabirinto().getStanzaCorrente().getAttrezzo(attrezzoDaPosare);
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(attrezzoDaPosare);
		}
	}
	/*************************************************************************************************/
	
	/*********************************************PRENDI**********************************************/
	public void prendi(String attrezzoDaPrendere) {
		if(attrezzoDaPrendere==null)
			io.mostraMessaggio("che cosa vuoi rimuovere?");
		else {
			Attrezzo a=partita.getLabirinto().getStanzaCorrente().getAttrezzo(attrezzoDaPrendere);
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			partita.getLabirinto().getStanzaCorrente().getAttrezzo(attrezzoDaPrendere);
		}
	}
	/*************************************************************************************************/
	
	/*************************************************************************************************/
	/* Comando "Fine".*/
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	/*************************************************************************************************/

	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}