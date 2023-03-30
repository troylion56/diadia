package ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ambienti.Labirinto;
import ambienti.Stanza;

public class LabirintoTest {

	Labirinto l;
	Stanza biblioteca;
	Stanza DS1;

	@Before
	public void setUp() {
		l = new Labirinto();
		l.creaStanze();
		biblioteca = new Stanza("Biblioteca");
		DS1 = new Stanza("DS1");
	}


	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", l.getStanzaVincente().getNome());
	}


	@Test
	public void testSetStanzaCorrente() {
		l.setStanzaCorrente(DS1);
		assertEquals(DS1, l.getStanzaCorrente());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", l.getStanzaCorrente().getNome());
	}@Test
	public void test() {
		fail("Not yet implemented");
	}



}
