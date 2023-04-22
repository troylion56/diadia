package comandi;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

public class ComandoNonValido implements Comando {
	private final static String nome= "non valido";
	private String parametro;
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio("Comando inesistente");

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
		return nome;
	}

	@Override
	public void setIo(IO io) {
		this.io=io;
		
	}

}
