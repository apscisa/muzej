package me.fit.service;

import jakarta.enterprise.context.Dependent;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.IPLog;
import me.fit.Korisnik;
import java.util.List;


@Dependent
public class KorisnikService {
	@Inject private EntityManager em;
	
	@Transactional
	public Korisnik createKorisnik(Korisnik k, IPLog iplog) {
		return em.merge(k);
	}
	
	@Transactional
    public List<Korisnik> getAllKorisnike(){
        return em.createNamedQuery(Korisnik.GET_ALL_KORISNIKE, Korisnik.class).getResultList();
    }
	
	@Transactional
	public List<Korisnik> getKorisniciByName(String name) {
		List<Korisnik> korisnici = em.createNamedQuery(Korisnik.GET_KORISNICI_BY_NAME, Korisnik.class)
				.setParameter("name", name).getResultList();
		
		return korisnici;

	}
}
