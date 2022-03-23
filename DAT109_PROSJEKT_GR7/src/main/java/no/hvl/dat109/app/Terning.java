package no.hvl.dat109.app;

public class Terning {

	public final int MAX = 6;

	public int faceValue;

	public Terning() {
		faceValue = 1;
	}

	public int roll() {
		faceValue = (int) (Math.random() * MAX) + 1;

		return faceValue;
	}

	public void setFaceValue(int value) {
		faceValue = value;
	}

	public int getFaceValue() {
		return faceValue;
	}

	public String toString() {
		String result = Integer.toString(faceValue);
		return result;
	}

}
