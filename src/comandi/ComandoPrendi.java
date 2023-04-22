package comandi;

import attrezzi.Attrezzo;
import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

public class ComandoPrendi implements Comando {

	private String attrezzoDaPrendere;
	private final static String nome= "prendi";
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
			Attrezzo a=partita.getLabirinto().getStanzaCorrente().getAttrezzo(attrezzoDaPrendere);
			if(partita.getGiocatore().getBorsa().getPesoRimanente(a)) {
				partita.getGiocatore().getBorsa().addAttrezzo(a);
				partita.getLabirinto().getStanzaCorrente().getAttrezzo(attrezzoDaPrendere);
			}
			else {
				io.mostraMessaggio("\nAttrezo troppo pesante");
		}
	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
	}
	@Override
	public String getParametro() {
		return this.attrezzoDaPrendere;
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
