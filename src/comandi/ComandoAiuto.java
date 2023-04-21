package comandi;

import diadia.Partita;

public class ComandoAiuto implements Comando {

	static final private String[] elencoComandi = {"aiuto", "vai", "fine", "prendi", "posa"};
	private String parametro;
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.println(elencoComandi[i]+" ");
		System.out.println("");

	}
	@Override
	public void setParametro(String parametro) {
	}

}
