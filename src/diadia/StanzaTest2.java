package diadia;
import static org.junit.Assert.*;

import org.junit.Test;

public class StanzaTest2 {

	public static void main() {
		Stanza bar = new Stanza("bar");
		Stanza mensa = new Stanza("mensa");
		
		Attrezzo tazzina = new Attrezzo("tazzina", 1);
		Attrezzo piatto = new Attrezzo("piatto", 2);
		
		bar.impostaStanzaAdiacente("nord", mensa);
		bar.addAttrezzo(tazzina);
		mensa.impostaStanzaAdiacente("sud", bar);
		mensa.addAttrezzo(piatto);
		
		 Stanza stanzaNordBaratt = bar.getStanzaAdiacente("nord");
	     System.out.println("Dietro la porta nord del bar c'è: " + stanzaNordBaratt.getDescrizione() + "l'attezzo contenuto dentro la stanza " + stanzaNordBaratt.getAttrezzi());
		
	}

}
