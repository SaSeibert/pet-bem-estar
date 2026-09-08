package br.edu.ifrs.petbemestar.dominio;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private Servico tipo;

    @Enumerated(EnumType.STRING)
    private StatusAtendimento situacao;

    private Double valor;

    @ManyToOne
    private Pet pet;

    public Atendimento() {
    }

    public Atendimento(LocalDateTime dataHora, Servico tipo) {
        this.dataHora = dataHora;
        this.tipo = tipo;
        this.situacao = StatusAtendimento.AGENDADO;
    }

    public Long getId()                       { return id; }
    public LocalDateTime getDataHora()        { return dataHora; }
    public Servico getTipo()                  { return tipo; }
    public StatusAtendimento getSituacao()    { return situacao; }
    public Double getValor()                  { return valor; }
    public Pet getPet()                       { return pet; }

    public void setPet(Pet pet)                           { this.pet = pet; }
    public void setSituacao(StatusAtendimento situacao)   { this.situacao = situacao; }
    public void setValor(Double valor)                    { this.valor = valor; }

    @Override
    public String toString() {
        return tipo + " em " + dataHora + " (" + situacao + ")";
    }
}
