package no.hvl.dat109.app;

public class Admin extends Spiller {

	public Admin() {
		super("", "", "", "", null);

	}

	public Admin(String navn, String brukernavn, String Epost, String passord, Spill spill) {
		super(navn, brukernavn, Epost, passord, spill);
	}

}
