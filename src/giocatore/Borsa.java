package giocatore;

import attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	/************************COSTRUTTORE DI BORSA********************************/
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	/****************************************************************************/
	
	/***************************METODI SUGLI ATTREZZI****************************/
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];
		return a;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	public int getNumeroAttrezzi() {
		return this.numeroAttrezzi;
	}
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if(nomeAttrezzo==null)
			return a;
		else {
			for(int i=0;i<attrezzi.length;i++) {
				if(attrezzi[i]!=null && nomeAttrezzo.equals(attrezzi[i].getNome())){
					a=attrezzi[i];
					attrezzi[i]=attrezzi[numeroAttrezzi-1];
					//				attrezzi[numeroAttrezzi-1] = null;		// puoi pure non farlo
					numeroAttrezzi--;
					return a;
				}
			}
		}
		return a;
	}
	
	/****************************************************************************/
	
	
	/***********************************METODI PER VEDERE IL PESO***************/
	public int getPesoMax() {
		return pesoMax;
	}
	
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();

		return peso;
	}
	
	public boolean getPesoRimanente(Attrezzo nomeAttrezzo) {
		if(nomeAttrezzo!=null && this.getPesoMax()-this.getPeso()>=nomeAttrezzo.getPeso())
			return true;
		return false;
	}
	
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	/****************************************************************************/
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}