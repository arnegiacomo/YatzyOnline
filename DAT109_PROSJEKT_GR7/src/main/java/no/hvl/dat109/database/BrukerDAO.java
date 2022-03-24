package no.hvl.dat109.database;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BrukerDAO {
	
	@PersistenceContext(name = "DB")
	private EntityManager em;
	
	/**
	 * Henter alle brukere i databasen
	 * @return List<Bruker> brukere
	 */
	public List<Bruker> hentAlle() {
		List<Bruker> all = em.createQuery("select m from Bruker m", Bruker.class).getResultList();
		return all;
	}

}
