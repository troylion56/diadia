package fixture;

import ambienti.Stanza;
import attrezzi.Attrezzo;
import diadia.DiaDia;
import diadia.IOSimulator;

public class Fixture {

	public static IOSimulator creaSimulazionePartitaEGioca(String... righeDaLEggere) {
		IOSimulator io = new IOSimulator(righeDaLEggere);
		new DiaDia(io).gioca();
		return io;
	}
	
	public static Attrezzo creaAttrezzoEAggiungiAStanza(Stanza stanzaDaReimpire,String nomeAttrezzo, int peso) {
		Attrezzo attrezzo =new Attrezzo(nomeAttrezzo, peso);
		stanzaDaReimpire.addAttrezzo(attrezzo);
		return attrezzo;
	}
}
