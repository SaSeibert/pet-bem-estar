package br.edu.ifrs.dominio;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//inicialmente eu tinha criado uma classe Servico, mas eu acho que o Enum eh suficiente... 
// n seii, podemos add ao enum caracteristicas tipo preço e tempo de atendimento???

public enum TipoServico {
    BANHO,
    TOSA,
    BANHO_E_TOSA,
    CONSULTA_VET;
}
