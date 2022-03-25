package no.hvl.dat109.app;

public class Hand {

	public int resultat;

	public int antalltrill;

	public Terning[] terninger;

	public int rundeNr;

	public Hand(int resultat, int antalltrill, Terning[] terninger, int rundeNr) {
		this.antalltrill = antalltrill;
		this.resultat = resultat;
		this.terninger = terninger;
		this.rundeNr = rundeNr;
	}

	public int getResultat() {
		return resultat;
	}

	public void setResultat(int resultat) {
		this.resultat = resultat;
	}

	public int getAntalltrill() {
		return antalltrill;
	}

	public void setAntalltrill(int antalltrill) {
		this.antalltrill = antalltrill;
	}

	public Terning[] getTerninger() {
		return terninger;
	}

	public void setTerninger(Terning[] terninger) {
		this.terninger = terninger;
	}

	public int getRundeNr() {
		return rundeNr;
	}

	public void setRundeNr(int rundeNr) {
		this.rundeNr = rundeNr;
	}

	public void trill(Terning[] terninger) {

		for (int i = 0; i < terninger.length; i++) {

			if (terninger[i].getFaceValue() == 0) {
				terninger[i].roll();
			}

		}

		antalltrill++;

	}

	public void fjernterning(Terning terning) {

		terning.setFaceValue(0);

	}

}
