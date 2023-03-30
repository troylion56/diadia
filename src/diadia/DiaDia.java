package diadia;
import java.util.Scanner;

import ambienti.Labirinto;
import ambienti.Stanza;
import giocatore.Borsa;
import giocatore.Giocatore;


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

	static final private String[] elencoComandi = {"aiuto", "vai", "fine", "prendi", "posa"};

	private Partita partita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	private Borsa borsa;
	private Stanza stanza;

	public DiaDia() {
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		System.out.println(MESSAGGIO_BENVENUTO);
		scannerDiLinee = new Scanner(System.in);		
		do		
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));
		scannerDiLinee.close();
	}
	/*
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti*/
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome() != null && comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome() != null && comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome() != null && comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(comandoDaEseguire.getNome()!=null && comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome()!=null && comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else
			System.out.println("Comando sconosciuto");

		if (this.partita.vinta()) {
			System.out.println("Hai vinto!");
			return true;
		} else
			return false;
	}   


	/*Stampa informazioni di aiuto*/
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	/*Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 *e ne stampa il nome, altrimenti stampa un messaggio di errore*/
	private void vai(String direzione) {
		if(direzione==null)
			System.out.println("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			System.out.println("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		System.out.println(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}
	public void posa(String attrezzoDaPosare) {
		if(attrezzoDaPosare==null)
			System.out.println("cosa vuoi posare?");
		if(this.borsa.attrezzi!=null) {
			this.borsa.removeAttrezzo(attrezzoDaPosare);
			System.out.println("ho rimosso : " + attrezzoDaPosare);
		}
	}
	
	public void prendi(String attrezzoDaPrendere) {
		if(attrezzoDaPrendere==null)
			System.out.println("cosa vuoi posare?");
		if(this.stanza.attrezzi!=null) {
			this.stanza.getAttrezzo(attrezzoDaPrendere);
			System.out.println("Ho preso l'attrezzo : " + attrezzoDaPrendere);
		}
	}

	/* Comando "Fine".*/
	private void fine() {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}