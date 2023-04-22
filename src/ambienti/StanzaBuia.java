package ambienti;

public class StanzaBuia extends Stanza{
	
	public String  attrezzo;
	
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzo=attrezzo;
	}
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(attrezzo))
			return "qui c'è buio pesto";
		return super.getDescrizione();
	}

}
