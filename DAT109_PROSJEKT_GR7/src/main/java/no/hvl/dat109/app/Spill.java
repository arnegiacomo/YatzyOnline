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
	private boolean slettes = false;
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
		
		System.out.println(this.toString() + " har startet!");
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
	 * Sletter et spill fra minnet
	 */
	public void slettSpill() {
		spill.remove(this.ID);
		this.slettes = true;
	}
	
	/**
	 * Fjerner en spiller, hvis det er eneste spiller eller admin, sletter spillet. faen dette er rotete -arne
	 * @param spiller som skal fjernes
	 */
	public void fjernSpiller(Spiller spiller) {
		if(this.admin.getEpost().equals(spiller.getEpost())) {
			slettSpill();
			
			getSpillere().forEach(s -> s.ForlatSpill());
			
			return;
		}
		spillere.remove(spiller.getEpost());
		spiller.ForlatSpill();
		
	}



	/**
	 * Legg til ny spiller i spillet, hvis bruker (spiller) med likt brukernavn allerede deltar skjer ingenting. Hvis spillere = 6 aka spillet er fullt, returner
	 * @param spiller som skal legges til
	 */
	public void join(Spiller spiller) {
		
		if(getSpillere().size() >= 6) {
			return;
		}
		
		for(int i = 0; i < getSpillere().size(); i++) {
			if(getSpillere().get(i).getBrukernavn().equals(spiller.getBrukernavn()))
				return;
		}
		
		spiller.setSpill(this);
		this.spillere.put(spiller.getEpost(), spiller);
		
	}

	/**
	 * Legger til tilskuer til spillet
	 * @param tilskuer
	 */
	public void spectate(Tilskuer tilskuer) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Returnerer statusen til spillet
	 * @return
	 */
	public String status() {
		if(!startet) {
			return "Ikke startet";
		} else {
			return "Spillet har startet! Runde: " + runderSpilt;
		}
	}
	
	/**
	 * Rydde opp i ting
	 * @param epost
	 */
	public static void fjernSpillerFraAlleSpill(Spiller spiller) {
		List<Spill> spills = getSpill();
		spills.forEach(s -> s.fjernSpiller(spiller));
		spill = new ConcurrentHashMap<Integer, Spill>();
		
		spills.forEach(s -> {
			if(!s.slettes)
				spill.put(s.getID(), s);
		});
		
	}

	@Override
	public String toString() {
		return "Spill [ID=" + ID + ", admin=" + admin + "]";
	}
	
	
	

}
