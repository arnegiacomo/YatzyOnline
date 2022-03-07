package no.hvl.dat109.mypackage;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "prosjekt")
public class TABELL {
	
	@Id
	private String TEKST;

	public String getTEKST() {
		return TEKST;
	}

	public void setTEKST(String tEKST) {
		TEKST = tEKST;
	}

	@Override
	public String toString() {
		return "TABELL [TEKST=" + TEKST + "]";
	}
	
	
}
