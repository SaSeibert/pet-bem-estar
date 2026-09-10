package br.edu.ifrs.petbemestar.dao;

import java.util.List;

import br.edu.ifrs.petbemestar.dominio.Atendimento;

public interface AtendimentoDAO {

    void salvar(Atendimento atendimento);
    Atendimento buscarPorId(Long id);
    List<Atendimento> listarTodos();
    void atualizar(Atendimento atendimento);
    void remover(Long id);
}
