package no.hvl.dat109.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Spill {

	public static Map<Integer, Spill> spill;

	public int ID;

	public Admin admin;

	public Map<String, Spiller> spillere;

	private boolean startet = false;
	public int runderSpilt = -1;
	
	public Spill(Admin admin) {
		this.ID = getSpill().size();
		this.admin = admin;
		this.spillere = new ConcurrentHashMap<String, Spiller>();
		spillere.put(admin.getEpost(),admin);
		
		admin.setSpill(this);
		spill.put(ID, this);
	}
	
	public void start() {
		this.startet = true;
		this.runderSpilt = 0; // ???????
	}

	/**
	 * Hente liste av alle pågående spill, hvis det er ingen initialisert lag en ny liste
	 * @return alle spill i minnet
	 */
	public static List<Spill> getSpill() {
		if(spill == null) {
			spill = new ConcurrentHashMap<Integer, Spill>();
		}
		return new ArrayList(spill.values());
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
		return new ArrayList(spillere.values());
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
	
	public boolean startet() {
		return startet;
	}



	/**
	 * Legg til ny spiller i spillet, hvis bruker (spiller) med likt brukernavn allerede deltar skjer ingenting
	 * @param spiller som skal legges til
	 */
	public void join(Spiller spiller) {
		
		for(int i = 0; i < getSpillere().size(); i++) {
			if(getSpillere().get(i).getBrukernavn().equals(spiller.getBrukernavn()))
				return;
		}
		
		this.spillere.put(spiller.getEpost(), spiller);
		
	}

	/**
	 * Legger til tilskuer til spillet
	 * @param tilskuer
	 */
	public void spectate(Tilskuer tilskuer) {
		// TODO Auto-generated method stub
		
	}
	

}
