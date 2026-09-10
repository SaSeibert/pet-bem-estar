package br.edu.ifrs.petbemestar.dao;

import java.util.List;

import br.edu.ifrs.petbemestar.dominio.Pet;
import jakarta.persistence.EntityManager;

public class PetDAOJPA implements PetDAO {

    private EntityManager em;

    public PetDAOJPA(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salvar(Pet pet) {
        em.getTransaction().begin();
        em.persist(pet);
        em.getTransaction().commit();
    }

    @Override
    public Pet buscarPorId(Long id) {
        return em.find(Pet.class, id);
    }

    @Override
    public List<Pet> listarTodos() {
        return em.createQuery("SELECT p FROM Pet p", Pet.class)
                 .getResultList();
    }

    @Override
    public void atualizar(Pet pet) {
        em.getTransaction().begin();
        em.merge(pet);
        em.getTransaction().commit();
    }

    @Override
    public void remover(Long id) {
        em.getTransaction().begin();
        Pet pet = em.find(Pet.class, id);
        em.remove(pet);
        em.getTransaction().commit();
    }
}
