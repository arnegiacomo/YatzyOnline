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

	public int sluttresultat() {
		int poengsum = 0;

		for (int i = 0; i < resultater.length; i++) {
			poengsum += resultater[i];
		}

		// Fjerner poengtotalen fra de 6 foerste rundene
		poengsum = poengsum - resultater[6];

		return poengsum;
	}

	public int ovrepoengsum() {

		int poengsum = 0;

		for (int i = 0; i < 6; i++) {
			poengsum += resultater[i];
		}

		return poengsum;
	}

	public int bonus() {

		if (resultater[6] >= 42) {
			return 50;
		}

		return 0;

	}

	/**
	 * Regner ut poengsummen for hver runde ut i fra hvilken runde det er
	 * 
	 * @param rundeNr terninger
	 * @return - poengsummen for en runde
	 */
	private int poeng(int rundeNr, Terning[] terninger) {
		int score = 0, count = 0;

		// Lagrer verdiene på terningene i en array
		int[] diceValues = new int[5];
		for (int i = 0; i < 5; i++)
			diceValues[i] = terninger[i].getFaceValue();

		// Switch for hvert scenario
		switch (rundeNr) {
		case 0: // enere
			for (int i = 0; i < 5; i++) {
				if (diceValues[i] == 1)
					score += diceValues[i];
			}
			break;

		case 1: // toere
			for (int i = 0; i < 5; i++) {
				if (diceValues[i] == 2)
					score += diceValues[i];
			}
			break;

		case 2: // Treere
			for (int i = 0; i < 5; i++) {
				if (diceValues[i] == 3)
					score += diceValues[i];
			}
			break;

		case 3: // firere
			for (int i = 0; i < 5; i++) {
				if (diceValues[i] == 4)
					score += diceValues[i];
			}
			break;

		case 4: // Femmere
			for (int i = 0; i < 5; i++) {
				if (diceValues[i] == 5)
					score += diceValues[i];
			}
			break;

		case 5: // Seksere
			for (int i = 0; i < 5; i++) {
				if (diceValues[i] == 6)
					score += diceValues[i];
			}
			break;

		case 8: /*
				 * 1 par
				 */
			for (int i = 6; i > 0; i--) {
				count = 0;
				for (int j = 0; j < 5; j++) {
					if (diceValues[j] == i)
						count++;
					if (count == 2) {
						score = (diceValues[j] * 2);
						break;
					}
				}
				if (count == 2)
					break;
			}
			break;

		case 9: /*
				 * 2 par
				 */
			int pair = 0;
			for (int i = 6; i > 0; i--) {
				count = 0;
				for (int j = 0; j < 5; j++) {
					if (diceValues[j] == i && diceValues[j] != score / 2)
						count++;
					if (count == 2) {
						score += (diceValues[j] * 2);
						pair++;
						break;
					}
				}
			}
			// sjekker at vi har 2 par
			if (pair != 2)
				score = 0;
			break;

		case 10: /*
					 * Tre av samme
					 */
			for (int i = 6; i > 0; i--) {
				count = 0;
				for (int j = 0; j < 5; j++) {
					if (diceValues[j] == i)
						count++;
					if (count == 3) {
						score = (diceValues[j] * 3);
						break;
					}
				}
				if (count == 3)
					break;
			}
			break;

		case 11: /*
					 * fire av samme
					 */
			for (int i = 6; i > 0; i--) {
				count = 0;
				for (int j = 0; j < 5; j++) {
					if (diceValues[j] == i)
						count++;
					if (count == 4) {
						score = (diceValues[j] * 4);
						break;
					}
				}
				if (count == 4)
					break;
			}
			break;

		case 12: /*
					 * fullt hus
					 */
			boolean foundThree = false;
			boolean foundPair = false;
			for (int i = 6; i > 0; i--) {
				count = 0;
				for (int j = 0; j < 5; j++) {
					if (diceValues[j] == i)
						count++;
					if (count == 3) {
						score = (diceValues[j] * 3);
						foundThree = true;
						break;
					}
				}
				if (count == 3)
					break;
			}

			/*
			 * Sjekker etter par
			 */
			if (foundThree) {
				for (int i = 6; i > 0; i--) {
					count = 0;
					for (int j = 0; j < 5; j++) {
						if (diceValues[j] == i)
							count++;
						if (count == 2 && (score / 3) != diceValues[j]) {
							score += (diceValues[j] * 2);
							foundPair = true;
							break;
						}
					}
					if (count == 2)
						break;
				}
			}

			// Sjekker at vi har par i tilegg til tre av samme
			if (!foundPair)
				score = 0;

			break;

		case 13: /*
					 * liten straight
					 */
			iSort(diceValues);
			if (diceValues[0] == 1) {
				count = 1;
				for (int i = 1; i < 5; i++) {
					if (diceValues[i] == i + 1)
						count++;
				}

				if (count == 5)
					score = 15;
			}
			break;

		case 14: /*
					 * stor straight
					 */
			iSort(diceValues);
			if (diceValues[0] == 2) {
				count = 1;
				for (int i = 1; i < 5; i++) {
					if (diceValues[i] == i + 2)
						count++;
				}

				if (count == 5)
					score = 20;
			}
			break;

		case 15: /*
					 * Yatzy
					 */
			for (int i = 6; i > 0; i--) {
				count = 0;
				for (int j = 0; j < 5; j++) {
					if (diceValues[j] == i)
						count++;
					if (count == 5) {
						score = 50;
						break;
					}
				}
				if (count == 5)
					break;
			}
			break;

		case 16: /*
					 * Sjangse
					 */
			for (int i = 0; i < 5; i++) {
				score += diceValues[i];
			}
			break;
		}

		return score;
	}

	/**
	 * Sorterer et int array med terningverdier med insertion sort
	 * 
	 * @param et array som skal sorteres
	 */
	private void iSort(int[] A) {
		if (A.length < 2)
			return;

		for (int i = 1, temp; i < A.length; i++) {
			temp = A[i];
			int j = i - 1;
			while (j >= 0 && A[j] > temp) {
				A[j + 1] = A[j];
				j--;
			}
			A[j + 1] = temp;
		}
	}

}
