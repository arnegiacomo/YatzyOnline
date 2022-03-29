package no.hvl.dat109.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Spill {

	public static Map<Integer, Spill> spill;

	public int ID;

	public Admin admin;

	public List<Spiller> spillere;

	public int starttid;

	public int runderSpilt;
	
	public Spill(Admin admin) {
		this.ID = getSpill().size();
		this.admin = admin;
		this.spillere = new ArrayList<Spiller>();
		spillere.add(admin);
		this.starttid = (int) System.currentTimeMillis();
		this.runderSpilt = 0;
		
		admin.setSpill(this);
		spill.put(ID, this);
	}

	/**
	 * Hente liste av alle pågående spill, hvis det er ingen initialisert lag en ny liste
	 * @return alle spill i minnet
	 */
	public static Map<Integer, Spill> getSpill() {
		if(spill == null) {
			spill = new ConcurrentHashMap<Integer, Spill>();
		}
		return spill;
	}
	
	/**
	 * Hente peker til et spill i minne basert på ID
	 * @param ID - til spillet du leter etter
	 * @return Spill peker
	 */
	public static Spill getSpillFraID(int ID) {
		return spill.get(ID);
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
	
	
	/**
	 * Delta i spillet
	 * @param spiller
	 */
	public void join(Spiller spiller) {
		
		for(int i = 0; i < spillere.size(); i++) {
			if(spillere.get(i).getBrukernavn().equals(spiller.getBrukernavn()))
				return;
		}
		
		this.spillere.add(spiller);
		
	}

	/**
	 * 
	 * @param tilskuer
	 */
	public void spectate(Tilskuer tilskuer) {
		// TODO Auto-generated method stub
		
	}
	

}
