package no.hvl.dat109.app;

public class Bruker {

	public String navn;

	public String brukernavn;

	public String Epost;

	private String passord;

	public Bruker(String navn, String brukernavn, String Epost, String passord) {
		this.navn = navn;
		this.brukernavn = brukernavn;
		this.Epost = Epost;
		this.passord = passord;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getEpost() {
		return Epost;
	}

	public void setEpost(String epost) {
		Epost = epost;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

}
