package diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ComandoVaiTest {
	
	private Partita partita;
	private IOConsole io;
	private ComandoVai comandovai;
  
	@Before
	public void setUp() {
		this.io = new IOConsole();
		this.partita=new Partita(this.io);
	}	

	@Test
	public void testComandoNonEsistente() {
		comandovai =new ComandoVai("lol");
		comandovai.esegui(partita);
//		assertEquals("Atrio", partita.getLabirinto().getStanzaCorrente().getNome());
		assertTrue(partita.getLabirinto().getStanzaCorrente().getNome().equals("Atrio"));
	}
	
	@Test
	public void testComandoEsiste2() {
		comandovai =new ComandoVai("nord");
		comandovai.esegui(partita);
//		assertEquals("test", partita.getLabirinto().getStanzaCorrente().getNome());
		assertTrue(partita.getLabirinto().getStanzaCorrente().getNome().equals("Atrio"));
	}
	@Test
	public void testComandoEsiste3() {
		comandovai =new ComandoVai("sud");
		comandovai.esegui(partita);
//		assertEquals("test", partita.getLabirinto().getStanzaCorrente().getNome());
		assertTrue(partita.getLabirinto().getStanzaCorrente().getNome().equals("Atrio"));


	}
	@Test
	public void testComandoEsiste4() {
		comandovai =new ComandoVai("ovest");
		comandovai.esegui(partita);
//		assertEquals("test", partita.getLabirinto().getStanzaCorrente().getNome());
		assertTrue(partita.getLabirinto().getStanzaCorrente().getNome().equals("Atrio"));


	}
	@Test
	public void testComandoEsiste5() {
		comandovai =new ComandoVai("est");
		comandovai.esegui(partita);
//		assertEquals("test", partita.getLabirinto().getStanzaCorrente().getNome());
		assertTrue(partita.getLabirinto().getStanzaCorrente().getNome().equals("Atrio"));


	}
}
