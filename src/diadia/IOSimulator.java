package diadia;

public class IOSimulator implements IO {

	private String[] righeLette;
	private int indiceRigheLette;

	public String[] getMessaggiProdotti() {
		return messaggiProdotti;
	}

	public void setMessaggiProdotti(String[] messaggiProdotti) {
		this.messaggiProdotti = messaggiProdotti;
	}

	private String[] messaggiProdotti;
	private int indiceMessaggiProdotti;
	private int indiceMessaggiMostrati;

	public IOSimulator(String[] righeDaLeggere) {
		this.righeLette = righeDaLeggere;
		this.indiceRigheLette = 0;
		this.indiceMessaggiMostrati = 0;
		this.messaggiProdotti = new String[42*23];
	}

	@Override
	public String leggiRiga() {
		String riga = null;

		riga = this.righeLette[indiceRigheLette];
		this.indiceRigheLette++;
		return riga;
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		// TODO Auto-generated method stub
		
	}



}