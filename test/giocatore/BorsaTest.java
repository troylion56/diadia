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
	private Attrezzo a3;
	
	@Before
	public void setUp() {
		this.b=new Borsa();
		this.a1= new Attrezzo("a1", 2);		//sotto il max
		this.a2= new Attrezzo("a2", 11);	//sopra il max
		this.a3=new Attrezzo("a3", 4);		//sotto il min
		
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
	public void testGetAttrezzoVeroSottoMax() {
		b.addAttrezzo(a1);
		assertEquals(a1, b.getAttrezzo("a1"));
	}
	
	@Test
	public void testGetAttrezzoNulloSottoMax() {
		assertEquals(null, b.getAttrezzo("a2"));
	}
	
	@Test
	public void testGetAttrezzoConNomeSbagliatoSottoMax() {
		b.addAttrezzo(a1);
		assertEquals(null, b.getAttrezzo("a2"));
	}
	
	@Test
	public void testGetAttrezzoConDueAttrezziSopraMax() {
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		assertEquals(null, b.getAttrezzo("a2"));
	}
	
	@Test
	public void testGetAttrezzoConDueAttrezziSottoMax() {
		b.addAttrezzo(a1);
		b.addAttrezzo(a3);
		assertEquals(a3, b.getAttrezzo("a3"));
	}
	
	
	// test get attrezzo: quando c'è ed inserisci il nome giusto
	// quando non c'è niente e metti un nome
	// quando c'è qualcosa e metti il nome sbagliato
	
	@Test 
	public void removeAtttrezzoCiSta() {
		b.addAttrezzo(a1);
		assertEquals(a1, b.removeAttrezzo("a1"));
	}
	
	@Test 
	public void removeAtttrezzoNonCiSta() {
		assertEquals(null,b.removeAttrezzo("a1"));
	}
	
	@Test 
	public void removeAtttrezzoNonDoNiente() {
		assertEquals(null, b.removeAttrezzo(""));
	}
}
