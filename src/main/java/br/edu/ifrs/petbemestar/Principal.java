package br.edu.ifrs.petbemestar;

import java.time.LocalDateTime;

import br.edu.ifrs.petbemestar.dao.AtendimentoDAO;
import br.edu.ifrs.petbemestar.dao.AtendimentoDAOJPA;
import br.edu.ifrs.petbemestar.dao.PetDAO;
import br.edu.ifrs.petbemestar.dao.PetDAOJPA;
import br.edu.ifrs.petbemestar.dao.TutorDAO;
import br.edu.ifrs.petbemestar.dao.TutorDAOJPA;
import br.edu.ifrs.petbemestar.dominio.Atendimento;
import br.edu.ifrs.petbemestar.dominio.Especie;
import br.edu.ifrs.petbemestar.dominio.Pet;
import br.edu.ifrs.petbemestar.dominio.Porte;
import br.edu.ifrs.petbemestar.dominio.Servico;
import br.edu.ifrs.petbemestar.dominio.StatusAtendimento;
import br.edu.ifrs.petbemestar.dominio.Tutor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Principal {

    public static void main(String[] args) {

        // CREATE DATABASE IF NOT EXISTS pet_bem_estar;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pet-bem-estar-pu");
        EntityManager em = emf.createEntityManager();

        TutorDAO tutorDAO           = new TutorDAOJPA(em);
        PetDAO petDAO               = new PetDAOJPA(em);
        AtendimentoDAO atendDAO     = new AtendimentoDAOJPA(em);

        // --- persiste um tutor com pet e DOIS atendimentos ---
        Tutor carlos = new Tutor("Carlos", "(51) 98888-1111");
        Pet rex = new Pet("Rex", Especie.CACHORRO, Porte.GRANDE);
        carlos.adicionarPet(rex);

        Atendimento banho    = new Atendimento(LocalDateTime.of(2026, 9, 1, 9, 0),  Servico.BANHO);
        Atendimento consulta = new Atendimento(LocalDateTime.of(2026, 9, 5, 14, 0), Servico.CONSULTA);
        rex.adicionarAtendimento(banho);
        rex.adicionarAtendimento(consulta);
        banho.setSituacao(StatusAtendimento.REALIZADO);

        em.getTransaction().begin();
        em.persist(carlos);
        em.persist(rex);
        em.persist(banho);
        em.persist(consulta);
        em.getTransaction().commit();

        Long idRex      = rex.getId();
        Long idConsulta = consulta.getId();

        // --- atualiza telefone do tutor ---
        carlos.setTelefone("(51) 97777-2222");
        tutorDAO.atualizar(carlos);
        System.out.println("Tutor apos atualizar: " + tutorDAO.buscarPorId(carlos.getId()).getTelefone());

        // --- remove um atendimento ---
        atendDAO.remover(idConsulta);
        System.out.println("Atendimento removido (deve ser null): " + atendDAO.buscarPorId(idConsulta));

        // --- listarPorAnimal: mostra os atendimentos restantes de Rex ---
        System.out.println("\nAtendimentos de Rex (id=" + idRex + "):");
        for (Atendimento a : atendDAO.listarPorAnimal(idRex)) {
            System.out.println("  " + a);
        }

        // --- listarPorSituacao: todos os atendimentos REALIZADOS ---
        System.out.println("\nTodos os atendimentos REALIZADOS:");
        for (Atendimento a : atendDAO.listarPorSituacao(StatusAtendimento.REALIZADO)) {
            System.out.println("  " + a);
        }

        em.close();
        emf.close();
    }
}
