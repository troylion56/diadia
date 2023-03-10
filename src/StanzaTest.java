import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author bluph
 *
 */
public class StanzaTest {

	public static void main(String[] args) {
		Stanza bar = new Stanza("Bar");
		Stanza mensa = new Stanza("Mensa");
		bar.impostaStanzaAdiacente("nord", mensa);
		mensa.impostaStanzaAdiacente("sud", bar);
		Attrezzo tazzina = new Attrezzo("tazzina", 1);
		Attrezzo piatto = new Attrezzo("piatto", 2);
		
		
		bar.addAttrezzo(tazzina);
		mensa.addAttrezzo(piatto);		

		Stanza stanzaNordBar = bar.getStanzaAdiacente("nord");
		System.out.println("Dietro la porta nord del bar c'è: " + stanzaNordBar.getDescrizione());

		Stanza stanzaSudMensa = mensa.getStanzaAdiacente("sud");
		System.out.println("Dietro la porta sud della mensa c'è: " + stanzaSudMensa.getDescrizione());
	}
}
