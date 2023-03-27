package diadia;

import static org.junit.Assert.*;

import org.junit.Test;

public class GiocatoreTest {

	Giocatore g1 = new Giocatore();
	@Test
	public void testGetCfuDefault() {
		assertEquals(20, g1.getCfu());
	}

	@Test
	public void testSetCfu() {
		g1.setCfu(3);
		assertEquals(3, g1.getCfu());
	}

}
