package me.fit.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.Muzej;

import java.util.List;

@Dependent
public class MuzejService {
    @Inject
    private EntityManager em;

    @Transactional
    public Muzej createMuzej(Muzej m) {
        return em.merge(m);
    }

    @Transactional
    public List<Muzej> getAllMuzeji() {
        return em.createNamedQuery(Muzej.GET_ALL_MUZEJI, Muzej.class).getResultList();
    }

} 

