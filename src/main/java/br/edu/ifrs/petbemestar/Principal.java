package br.edu.ifrs.petbemestar;

import java.time.LocalDateTime;

import br.edu.ifrs.petbemestar.dominio.Pet;
import br.edu.ifrs.petbemestar.dominio.Atendimento;
import br.edu.ifrs.petbemestar.dominio.Especie;
import br.edu.ifrs.petbemestar.dominio.Porte;
import br.edu.ifrs.petbemestar.dominio.StatusAtendimento;
import br.edu.ifrs.petbemestar.dominio.Servico;
import br.edu.ifrs.petbemestar.dominio.Tutor;

public class Principal {

    public static void main(String[] args) {

        Tutor rosa = new Tutor("Rosa", "(51) 99999-0000");

        Pet mimi = new Pet("Mimi", Especie.GATO, Porte.PEQUENO);
        Pet thor = new Pet("Thor", Especie.CACHORRO, Porte.GRANDE);
        Pet frajola = new Pet("Frajola", Especie.GATO, Porte.PEQUENO);
        Pet nina = new Pet("Nina", Especie.GATO, Porte.PEQUENO);

        rosa.adicionarPet(mimi);
        rosa.adicionarPet(thor);
        rosa.adicionarPet(frajola);
        rosa.adicionarPet(nina);

        Atendimento banhoDaMimi = new Atendimento(LocalDateTime.of(2026, 8, 12, 9, 0), Servico.BANHO);
        Atendimento banhoDoThor = new Atendimento(LocalDateTime.of(2026, 8, 12, 9, 0), Servico.BANHO);
        Atendimento tosaDaFrajola = new Atendimento(LocalDateTime.of(2026, 8, 12, 14, 0), Servico.TOSA);
        Atendimento consultaDaNina = new Atendimento(LocalDateTime.of(2026, 8, 13, 10, 0), Servico.CONSULTA);

        mimi.adicionarAtendimento(banhoDaMimi);
        thor.adicionarAtendimento(banhoDoThor);
        frajola.adicionarAtendimento(tosaDaFrajola);
        nina.adicionarAtendimento(consultaDaNina);

        banhoDaMimi.setSituacao(StatusAtendimento.REALIZADO);
        tosaDaFrajola.setSituacao(StatusAtendimento.REALIZADO);
        consultaDaNina.setSituacao(StatusAtendimento.NAO_COMPARECEU);

        System.out.println("Tutora: " + rosa);
        System.out.println("Telefone (um so, em um lugar so): " + rosa.getTelefone());
        System.out.println("Pets: " + rosa.getPets().size() + " -> " + rosa.getPets());
        System.out.println();

        for (Pet pet : rosa.getPets()) {
            System.out.println(pet + " | " + pet.getAtendimentos());
        }
        System.out.println();

        for (Pet pet : rosa.getPets()) {
            Atendimento ultimo = pet.ultimoAtendimentoRealizado();
            System.out.println("Ultima vez que " + pet.getNome() + " veio: "
                    + (ultimo == null ? "nunca veio" : ultimo.getDataHora().toString()));
        }
    }
}
