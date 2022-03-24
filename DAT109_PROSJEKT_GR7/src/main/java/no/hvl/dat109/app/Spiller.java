package no.hvl.dat109.app;

import no.hvl.dat109.database.Bruker;

public class Spiller extends Bruker {

	public Spill spill;

	public Spiller() {
		super();
	}

	public Spiller(String navn, String brukernavn, String Epost, String passord, Spill spill) {
		super();
		this.spill = spill;
	}

	public Spill getSpill() {
		return spill;
	}

	public void setSpill(Spill spill) {
		this.spill = spill;
	}
	
	public void ForlatSpill() {
		
	}
	
	public int SpillRunde() {
		return 0;
	}

}
