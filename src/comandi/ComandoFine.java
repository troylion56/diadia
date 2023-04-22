package comandi;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

public class ComandoFine implements Comando {
	
	private final static String nome= "fine";
	private IO io;
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		io.mostraMessaggio("Grazie per aver giocato");

	}

	@Override
	public void setParametro(String parametro) {
	}
	@Override
	public String getParametro() {
		return null;
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
