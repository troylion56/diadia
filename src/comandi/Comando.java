package comandi;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

public interface Comando {
	public void esegui(Partita partita);
	public void setParametro(String parametro);
	String getParametro();
	public String getNome();
	public void setIo(IO io);
}
