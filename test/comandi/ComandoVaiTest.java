package comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ambienti.Labirinto;
import ambienti.Stanza;
import diadia.DiaDia;
import diadia.IOConsole;
import diadia.IOSimulator;
import diadia.Partita;
import fixture.Fixture;

public class ComandoVaiTest {
	private Stanza partenza;
	private Comando comandoVai;
	private Partita partita;
	private static final String NORD="nord";
	private static final String NOME_STANZA_PARTENZA="Partenza";
	
	@Before
	public void setUp() {
		this.comandoVai=new ComandoVai();
		this.comandoVai.setIo(new IOConsole());
		this.partita =new Partita();
		this.partenza.setStanzaCorrente(this.partenza);
	}

	
	@Test
	public void testStanzaPresente() {
		Stanza destinazione=new Stanza("Destinazione");
		this.partenza.impostaStanzaAdiacente(NORD, destinazione);
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(partita);
		assertEquals("Destinazione",this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testVaiStanzaPresenteInDirezioneSbagliata() {
		Stanza destinazione= new Stanza ("Destinazione");
		this.partenza.impostaStanzaAdiacente("sud", destinazione);
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(partita);
		assertEquals(NOME_STANZA_PARTENZA, this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testPartitaConComandoVai() {
		String[] comandiDaEseguire= {"vai sud","fine"};
		IOSimulator io= Fixture.creaSimulazionePartitaEGioca(comandiDaEseguire);
		assertTrue(io.hasNExtMEssaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNExtMEssaggio());
		assertContains("Aula N10",io.nextMessaggio());
		assertTrue(io.hasNExtMEssaggio());
		assertEquals(ComandoFine.nome, io.nextMessaggio());
		
	}
	
	public void assertContains(String expected, String interaRiga) {
		assertTrue(interaRiga.contains(interaRiga));
	}
}
