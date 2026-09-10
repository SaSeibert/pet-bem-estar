package br.edu.ifrs.petbemestar.dao;

import java.util.List;

import br.edu.ifrs.petbemestar.dominio.Tutor;
import jakarta.persistence.EntityManager;

public class TutorDAOJPA implements TutorDAO {

    private EntityManager em;

    public TutorDAOJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salvar(Tutor tutor) {
        em.getTransaction().begin();
        em.persist(tutor);
        em.getTransaction().commit();
    }

    @Override
    public Tutor buscarPorId(Long id) {
        return em.find(Tutor.class, id);
    }

    @Override
    public List<Tutor> listarTodos() {
        return em.createQuery("SELECT t FROM Tutor t", Tutor.class)
                 .getResultList();
    }

    @Override
    public void atualizar(Tutor tutor) {
        em.getTransaction().begin();
        em.merge(tutor);
        em.getTransaction().commit();
    }

    @Override
    public void remover(Long id) {
        em.getTransaction().begin();
        Tutor tutor = em.find(Tutor.class, id);
        em.remove(tutor);
        em.getTransaction().commit();
    }
}
