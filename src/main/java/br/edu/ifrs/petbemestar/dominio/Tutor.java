package br.edu.ifrs.petbemestar.dominio;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;

    @OneToMany(mappedBy = "tutor")
    private List<Pet> pets = new ArrayList<>();

    public Tutor() {
    }

    public Tutor(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public void adicionarPet(Pet pet) {
        pets.add(pet);
        pet.setTutor(this);
    }

    public Long getId()                { return id; }
    public String getNome()            { return nome; }
    public String getTelefone()        { return telefone; }
    public List<Pet> getPets()         { return pets; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    @Override
    public String toString() {
        return nome;
    }
}
