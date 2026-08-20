package br.edu.ifrs.dominio;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class Pet {

    private String nomePet;
    private Especie especie;

    public Pet(String nomePet, Especie especie) {
        this.nomePet = nomePet;
        this.especie = especie;
    }


}
