package ambienti;

import javax.print.DocFlavor.STRING;

public class StanzaBloccata extends Stanza{

	public String direzioneBloccata;
	public String attrezzo;
	
	public StanzaBloccata(String nome, String direzioneBloccata, String attrezzo) {
		super(nome);
		this.direzioneBloccata=direzioneBloccata;
		this.attrezzo=attrezzo;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzioneBloccata.equals(direzione) && !this.hasAttrezzo(attrezzo))
			return this;
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(attrezzo))
			return "direzione bloccata " + direzioneBloccata+ " prendi il " + attrezzo;
		return super.getDescrizione();
	}
}
