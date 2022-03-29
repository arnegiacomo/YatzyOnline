package no.hvl.dat109.app;

import no.hvl.dat109.database.Bruker;

public class Spiller {

	public Spill spill;
	private Bruker bruker;
	private Poengtabell tabell;

	public Spiller(Bruker bruker) {
		this.bruker = bruker;
	}

	public Spill getSpill() {
		return spill;
	}

	/**
	 * Ikke rør!
	 */
	public void setSpill(Spill spill) {
		Spill.fjernSpillerFraAlleSpill(this);
		this.spill = spill;
		this.tabell = new Poengtabell();
	}
	
	public void ForlatSpill() {
		Spill.fjernSpillerFraAlleSpill(this);
		this.spill = null;
		this.tabell = null;
	}
	
	public int SpillRunde() {
		return 0;
	}

	// Getters / Setters / toString
	
	public String getBrukernavn() {
		return bruker.getBrukernavn();
	}
	
	public String getEpost() {
		return bruker.getEpost();
	}

	public Poengtabell getTabell() {
		return tabell;
	}

	@Override
	public String toString() {
		return "Spiller [bruker=" + bruker + "]";
	}
	
	

}
