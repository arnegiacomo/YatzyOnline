package no.hvl.dat109.app;

public class Spiller extends Bruker {

	public Spill spill;

	public Spiller() {
		super("", "", "", "");

	}

	public Spiller(String navn, String brukernavn, String Epost, String passord, Spill spill) {
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
