package no.hvl.dat109.app;

public class Poengtabell {

	public int rundeNr;

	public int[] resultater;

	public Poengtabell(int rundeNr, int[] resultater) {
		this.rundeNr = rundeNr;
		this.resultater = resultater;
	}

	public int getRundeNr() {
		return rundeNr;
	}

	public void setRundeNr(int rundeNr) {
		this.rundeNr = rundeNr;
	}

	public int[] getResultater() {
		return resultater;
	}

	public void setResultater(int[] resultater) {
		this.resultater = resultater;
	}
	
	

}
