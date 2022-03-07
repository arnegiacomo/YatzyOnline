package no.hvl.dat109.mypackage;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DAO {
	
	@PersistenceContext(name = "DB")
	private EntityManager em;

	public List<TABELL> getAll() {
		List<TABELL> all = em.createQuery("select m from TABELL m", TABELL.class).getResultList();
		return all;
	}
	

}
