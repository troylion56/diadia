package comandi;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

public class ComandoAiuto implements Comando {

	static final private String[] elencoComandi = {"aiuto", "vai", "fine", "prendi", "posa","guarda"};
	private final static String nome= "aiuto";
	private IO io;
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");

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
