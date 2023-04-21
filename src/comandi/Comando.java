package comandi;

import diadia.Partita;

public interface Comando {
	public void esegui(Partita partita);
	public void setParametro(String parametro);
}
