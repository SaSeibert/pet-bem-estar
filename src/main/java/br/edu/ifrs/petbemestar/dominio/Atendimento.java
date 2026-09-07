package br.edu.ifrs.petbemestar.dominio;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Atendimento {

    @Id
    private Long id;

    private LocalDateTime dataHora;
    private Servico tipo;
    private StatusAtendimento situacao;
    private Double valor;  //a ser visto futuramente
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
