package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;

public class Parole {
	private List<String> parole;
		
	public Parole() {
		this.parole= new ArrayList<>();
		// in questo caso si può sostituire con un linked list per dare un occhiata se le prestazioni variano
//		this.parole= new LinkedList<>();
	}
	
	public void addParola(String p) {
		// usiamo la caratteristica delle liste di aggiungere un oggetto con .add()
		this.parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole);// sort è metodo che già mette in ordine alfabetico se per le stringhe
		return parole;
	}
	
	public void reset() {
		parole.clear();// metodo che pulisce una list
	}
	public void cancella(String p) {
		parole.remove(p);// metodo esistente che cancella da una lista un determinato componente
	}
// metodo in ovverride che prende una lista parole e la stampa
	@Override
	public String toString() {
		String s="";
		for(String v:parole){
    		s=s+v+"\n";
    
    	}
		return s;
	}
	
}
