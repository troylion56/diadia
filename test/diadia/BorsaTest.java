package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BorsaTest {
	
	Borsa b =new Borsa();
	Attrezzo a1;
	Attrezzo a2;
	
	@Before
	public void zetUp() {
		a1= new Attrezzo("a1", 2);
		a2=new Attrezzo("a2", 11);
	}
	
	@Test
	public void oggettoSottoIlMax() {
		assertTrue(b.addAttrezzo(a1));
	}
	
	@Test
	public void oggettoSopraIlMax() {
		assertFalse(b.addAttrezzo(a2));
	}
	
	@Test
	public void testGetAttrezzo() {
		b.addAttrezzo(a1);
		assertEquals(a1, b.getAttrezzo("a1"));
	}
	
	@Test void removeAtttrezzo1() {
		
	}
}
