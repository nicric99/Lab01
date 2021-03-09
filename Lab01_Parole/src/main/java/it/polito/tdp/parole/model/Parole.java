package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {
	private List<String> parole;
		
	public Parole() {
		this.parole= new ArrayList<>();
	}
	
	public void addParola(String p) {
		this.parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole);
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}
	public void cancella(String p) {
		parole.remove(p);
	}
}
