package no.hvl.dat109.app;

import no.hvl.dat109.database.Bruker;

public class Spiller {

	public Spill spill;
	private Bruker bruker;

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
	}
	
	public void ForlatSpill() {
		Spill.fjernSpillerFraAlleSpill(this);
		this.spill = null;
	}
	
	public int SpillRunde() {
		return 0;
	}

	public String getBrukernavn() {
		return bruker.getBrukernavn();
	}
	
	public String getEpost() {
		return bruker.getEpost();
	}

}
