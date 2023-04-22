package comandi;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

public class ComandoGuarda implements Comando {

	private final static String nome= "guarda";
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Hai acnora: " + partita.getGiocatore().getCfu()+ "CFU");
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}
	
	@Override
	public void setIo(IO io) {
		this.io=io;
	}

}
