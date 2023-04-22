package ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import attrezzi.Attrezzo;

public class StanzaBuiaTest {

	private StanzaBuia stanza;
	private Attrezzo a;
	@Before
	public void setUp() throws Exception {
		stanza = new StanzaBuia("StanzaBuia", "a");
		a=new Attrezzo("a",	 1);
	}

	@Test
	public void testGetDEscrizioneConAttrezzo() {
		stanza.addAttrezzo(a);
		assertEquals(stanza.toString(), stanza.getDescrizione());
	}

}
