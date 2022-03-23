package no.hvl.dat109.app;

public class Tilskuer extends Bruker {

	public Spill spill;

	public Tilskuer() {
		super("", "", "", "");

	}

	public Tilskuer(String navn, String brukernavn, String Epost, String passord, Spill spill) {
		super(navn, brukernavn, Epost, passord);
		this.spill = spill;
	}

	public Spill getSpill() {
		return spill;
	}

	public void setSpill(Spill spill) {
		this.spill = spill;
	}
}
