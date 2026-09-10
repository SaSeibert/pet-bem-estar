package br.edu.ifrs.petbemestar.dao;

import java.util.List;

import br.edu.ifrs.petbemestar.dominio.Atendimento;
import br.edu.ifrs.petbemestar.dominio.StatusAtendimento;

public interface AtendimentoDAO {

    void salvar(Atendimento atendimento);
    Atendimento buscarPorId(Long id);
    List<Atendimento> listarTodos();
    void atualizar(Atendimento atendimento);
    void remover(Long id);
    List<Atendimento> listarPorAnimal(Long idAnimal);
    List<Atendimento> listarPorSituacao(StatusAtendimento situacao);
}
