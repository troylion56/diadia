package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {
	
	private Stanza s1;
	private Stanza s2;
	private Attrezzo a;
	private Attrezzo b;
	
	@Before
	public void setUp(){
		this.s1=new Stanza("s1");
		this.s2=new Stanza("s2");
		this.a=new Attrezzo("a", 3);
	}
	
	@Test			//faccio il test per la stanza adiacente poiche mi serve affinceh io posso verificare la stanza adaicente di s1
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente("sud"));
		//assertNull afferma che il suo argomento è nullo fallisce se non lo è
		
	}
	
	@Test
	public void testStanzaAdiacente(){
		s1.impostaStanzaAdiacente("sud", s2);
		assertEquals(s2,s1.getStanzaAdiacente("sud"));
		//verifica se s2 sta a sud di s1
	}
	
	@Test
	public void testAttrezzoNellaStanza(){
		assertTrue(s1.addAttrezzo(a));
		//assertTrue afferma che il suo argomento è true fallisce se non lo è
	}
	
	@Test 
	public void testrimuoviAttrezzo1() {
		s1.addAttrezzo((a));
		assertTrue(s1.removeAttrezzo("a"));
	}
	
	@Test 
	public void testrimuoviAttrezzo2() {
		s1.addAttrezzo((a));
		assertFalse(s1.removeAttrezzo("b"));
	}
}
