package br.edu.ifrs.dominio;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public enum StatusAgend {
    MARCADO,
    CONCLUIDO,
    CANCELADO,
    N_COMPARECEU;
}
