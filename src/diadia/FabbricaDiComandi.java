package diadia;

import comandi.Comando;

public interface FabbricaDiComandi {
	public Comando costruisciComando(String istruzione);
}
