package br.edu.ifrs.petbemestar.dao;

import java.util.List;

import br.edu.ifrs.petbemestar.dominio.Atendimento;
import br.edu.ifrs.petbemestar.dominio.StatusAtendimento;
import jakarta.persistence.EntityManager;

public class AtendimentoDAOJPA implements AtendimentoDAO {

    private EntityManager em;

    public AtendimentoDAOJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salvar(Atendimento atendimento) {
        em.getTransaction().begin();
        em.persist(atendimento);
        em.getTransaction().commit();
    }

    @Override
    public Atendimento buscarPorId(Long id) {
        return em.find(Atendimento.class, id);
    }

    @Override
    public List<Atendimento> listarTodos() {
        return em.createQuery("SELECT a FROM Atendimento a", Atendimento.class)
                 .getResultList();
    }

    @Override
    public void atualizar(Atendimento atendimento) {
        em.getTransaction().begin();
        em.merge(atendimento);
        em.getTransaction().commit();
    }

    @Override
    public void remover(Long id) {
        em.getTransaction().begin();
        Atendimento atendimento = em.find(Atendimento.class, id);
        em.remove(atendimento);
        em.getTransaction().commit();
    }

    @Override
    public List<Atendimento> listarPorAnimal(Long idAnimal) {
        return em.createQuery(
                "SELECT a FROM Atendimento a WHERE a.pet.id = :idAnimal", Atendimento.class)
                 .setParameter("idAnimal", idAnimal)
                 .getResultList();
    }

    @Override
    public List<Atendimento> listarPorSituacao(StatusAtendimento situacao) {
        return em.createQuery(
                "SELECT a FROM Atendimento a WHERE a.situacao = :situacao", Atendimento.class)
                 .setParameter("situacao", situacao)
                 .getResultList();
    }
}
