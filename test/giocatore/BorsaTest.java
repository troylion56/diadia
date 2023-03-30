package giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import attrezzi.Attrezzo;
import giocatore.Borsa;

public class BorsaTest {
	
	private Borsa b;
	private Attrezzo a1;
	private Attrezzo a2;
	
	@Before
	public void setUp() {
		this.b=new Borsa();
		this.a1= new Attrezzo("a1", 2);
		this.a2= new Attrezzo("a2", 11);
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
	
	// test get attrezzo: quando c'è ed inserisci il nome giusto
	// quando non c'è niente e metti un nome
	// quando c'è qualcosa e metti il nome sbagliato
	
	@Test 
	public void removeAtttrezzo1() {
		b.addAttrezzo(a1);
		b.removeAttrezzo("a1");
		assertEquals("a1", a1.getNome());
	}
}
