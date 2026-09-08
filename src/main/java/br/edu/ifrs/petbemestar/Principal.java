package br.edu.ifrs.petbemestar;

import java.time.LocalDateTime;

import br.edu.ifrs.petbemestar.dominio.Pet;
import br.edu.ifrs.petbemestar.dominio.Atendimento;
import br.edu.ifrs.petbemestar.dominio.Especie;
import br.edu.ifrs.petbemestar.dominio.Porte;
import br.edu.ifrs.petbemestar.dominio.StatusAtendimento;
import br.edu.ifrs.petbemestar.dominio.Servico;
import br.edu.ifrs.petbemestar.dominio.Tutor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Principal {

    public static void main(String[] args) {

        Tutor rosa = new Tutor("Rosa", "(51) 99999-0000");

        Pet mimi = new Pet("Mimi", Especie.GATO, Porte.PEQUENO);
        Pet thor = new Pet("Thor", Especie.CACHORRO, Porte.GRANDE);

        rosa.adicionarPet(mimi);
        rosa.adicionarPet(thor);

        Atendimento banhoDaMimi = new Atendimento(LocalDateTime.of(2026, 8, 12, 9, 0), Servico.BANHO);
        Atendimento banhoDoThor = new Atendimento(LocalDateTime.of(2026, 8, 12, 9, 0), Servico.BANHO_E_TOSA);

        mimi.adicionarAtendimento(banhoDaMimi);
        thor.adicionarAtendimento(banhoDoThor);

        banhoDaMimi.setSituacao(StatusAtendimento.REALIZADO);

        System.out.println("Tutora: " + rosa);
        System.out.println("Pets: " + rosa.getPets());

        // CREATE DATABASE IF NOT EXISTS pet_bem_estar;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pet-bem-estar-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(rosa);
        em.persist(mimi);
        em.persist(thor);
        em.persist(banhoDaMimi);
        em.persist(banhoDoThor);
        em.getTransaction().commit();

        System.out.println("\nPersistido com sucesso! Confiram no MySQL:");
        System.out.println("  SELECT * FROM Tutor;");
        System.out.println("  SELECT * FROM Pet;");
        System.out.println("  SELECT * FROM Atendimento;");

        em.close();
        emf.close();
    }
}
