package br.edu.ifrs.dominio;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class Agendamento {

    private String data;
    private String hora;
    private TipoServico tipoServico;
    private StatusAgend statusAgend;
    
    // private historico de agendamento seria uma coleçao?
    //n imagino como implementar agr, mas fica a ideia


    public Agendamento(String data, String hora, TipoServico tipoServico, StatusAgend statusAgend) {
        this.data = data;
        this.hora = hora;
        this.tipoServico = tipoServico;
        this.statusAgend = statusAgend;
    }



}
