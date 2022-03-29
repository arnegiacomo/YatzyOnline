package no.hvl.dat109.app;

import no.hvl.dat109.database.Bruker;

public class Admin extends Spiller {
	
	

	public Admin(Bruker bruker) {
		

	}
	
	/**
	 * Ikke rør!
	 */
	public void setSpill(Spill spill) {
		this.spill = spill;
	}

	public Admin(String navn, String brukernavn, String Epost, String passord, Spill spill) {
		super(navn, brukernavn, Epost, passord, spill);
	}
	
	public void fjernSpiller() {
		
	}
	
	public void inviterSpiller(Spiller spiller) {
		
	}
	
	public void start() {
		
	}
	
	public void stopp() {
		
	}
	
	public void lagre() {
		
	}

}
