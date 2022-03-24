package no.hvl.dat109.app;

import java.util.List;
import java.util.Map;

public class Spill {

	public static Map<Spiller, Poengtabell> spill;

	public int ID;

	public Admin admin;

	public List<Spiller> spillere;

	public int starttid;

	public int runderSpilt;
	
	public Spill(Map<Spiller, Poengtabell> spill, int ID, Admin admin, List<Spiller> spillere, int starttid, int runderSpilt) {
		Spill.spill = spill;
		this.ID = ID;
		this.admin = admin;
		this.spillere = spillere;
		this.starttid = starttid;
		this.runderSpilt = runderSpilt;
	}

	public static Map<Spiller, Poengtabell> getSpill() {
		return spill;
	}

	public static void setSpill(Map<Spiller, Poengtabell> spill) {
		Spill.spill = spill;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Spiller> getSpillere() {
		return spillere;
	}

	public void setSpillere(List<Spiller> spillere) {
		this.spillere = spillere;
	}

	public int getStarttid() {
		return starttid;
	}

	public void setStarttid(int starttid) {
		this.starttid = starttid;
	}

	public int getRunderSpilt() {
		return runderSpilt;
	}

	public void setRunderSpilt(int runderSpilt) {
		this.runderSpilt = runderSpilt;
	}
	
	public int SluttResultat() {
		return 0;
	}
	
	private void InkrementerRunde() {
		
	}
	

}
