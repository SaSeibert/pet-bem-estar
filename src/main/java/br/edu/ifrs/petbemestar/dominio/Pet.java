package br.edu.ifrs.petbemestar.dominio;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pet {

    @Id
    private Long id;
    private String nome;
    private Especie especie;
    private Porte porte;
    private Tutor tutor;
    private List<Atendimento> atendimentos = new ArrayList<>();

    public Pet() {
    }

    public Pet(String nome, Especie especie, Porte porte) {
        this.nome = nome;
        this.especie = especie;
        this.porte = porte;
    }

    public void adicionarAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
        atendimento.setPet(this);
    }

    public Atendimento ultimoAtendimentoRealizado() {
        Atendimento ultimo = null;
        for (Atendimento atendimento : atendimentos) {
            if (atendimento.getSituacao() != StatusAtendimento.REALIZADO) {
                continue;
            }
            if (ultimo == null || atendimento.getDataHora().isAfter(ultimo.getDataHora())) {
                ultimo = atendimento;
            }
        }
        return ultimo;
    }

    public Long getId()          { return id; }
    public String getNome()      { return nome; }
    public Especie getEspecie()  { return especie; }
    public Porte getPorte()      { return porte; }
    public Tutor getTutor()      { return tutor; }
    public List<Atendimento> getAtendimentos() { return atendimentos; }

    public void setTutor(Tutor tutor) { this.tutor = tutor; }

    @Override
    public String toString() {
        return nome + " (" + especie + ")";
    }

}
