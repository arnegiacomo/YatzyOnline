package no.hvl.dat109.app;

public class Poengtabell {

	public int rundeNr;

	public int[] resultater;

	public Poengtabell() {
		this.rundeNr = 0;
		this.resultater = new int[]{1,2,3,4,5,6,21,50,12,22,18,24,28,15,21,50,99, 102309};
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

		if (resultater[7] >= 42) {
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
	public static int poeng(int rundeNr, Terning[] terninger) {
		int score = 0, count = 0;

		// Lagrer verdiene p� terningene i en array
		int[] diceValues = new int[5];
		for (int i = 0; i < 5; i++)
			diceValues[i] = terninger[i].getFaceValue();

		// Switch for hvert scenario
		switch (rundeNr) {
		case 1: // enere
			for (int i = 0; i < 5; i++) {
				if (diceValues[i] == 1) {
					score += diceValues[i];
				}
					
			}
			break;

		case 2: // toere
			for (int i = 0; i < 5; i++) {
				if (diceValues[i] == 2)
					score += diceValues[i];
			}
			break;

		case 3: // Treere
			for (int i = 0; i < 5; i++) {
				if (diceValues[i] == 3)
					score += diceValues[i];
			}
			break;

		case 4: // firere
			for (int i = 0; i < 5; i++) {
				if (diceValues[i] == 4)
					score += diceValues[i];
			}
			break;

		case 5: // Femmere
			for (int i = 0; i < 5; i++) {
				if (diceValues[i] == 5)
					score += diceValues[i];
			}
			break;

		case 6: // Seksere
			for (int i = 0; i < 5; i++) {
				if (diceValues[i] == 6)
					score += diceValues[i];
			}
			break;

		case 7: /*
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

		case 8: /*
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

		case 9: /*
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

		case 10: /*
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

		case 11: /*
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

		case 12: /*
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

		case 13: /*
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

		case 14: /*
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

		case 15: /*
					 * Sjanse
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
	private static void iSort(int[] A) {
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
	
	// Gettere
	
	public int getEnere() {
		return resultater[0];
	}
	
	public int getToere() {
		return resultater[1];
	}
	
	public int getTrere() {
		return resultater[2];
	}
	
	public int getFirere() {
		return resultater[3];
	}
	
	public int getFemmere() {
		return resultater[4];
	}
	
	public int getSeksere() {
		return resultater[5];
	}
	
	public int getSum1() {
		return resultater[6];
	}
	
	public int getBonus() {
		return resultater[7];
	}
	
	public int get1Par() {
		return resultater[8];
	}
	
	public int get2Par() {
		return resultater[9];
	}

	public int get3Like() {
		return resultater[10];
	}
	
	public int get4Like() {
		return resultater[11];
	}
	
	public int getHus() {
		return resultater[12];
	}
	
	public int getLiten() {
		return resultater[13];
	}
	
	public int getStor() {
		return resultater[14];
	}
	
	public int getYatzy() {
		return resultater[15];
	}
	
	public int getSjanse() {
		return resultater[16];
	}
	
	public int getSum() {
		return resultater[17];
	}
}
