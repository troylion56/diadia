package comandi;

import attrezzi.Attrezzo;
import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

public class ComandoPosa implements Comando {
	
	
	private String posain;
	private final static String nome= "posa";
	private IO io;


	@Override
	public void esegui(Partita partita) {
		Attrezzo a= partita.getGiocatore().getBorsa().getAttrezzo(posain);
		if(partita.getStanzaCorrente().getNumeroAttrezziPossibili()>0) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(posain);
		}
		else {
			io.mostraMessaggio("Stanza vuota");
		}
	}

	@Override
	public void setParametro(String parametro) {

	}

	@Override
	public String getParametro() {
		return this.posain;
	}

	@Override
	public String getNome() {
		return nome;
	}
	
	@Override
	public void setIo(IO io) {
		this.io=io;
	}

}
