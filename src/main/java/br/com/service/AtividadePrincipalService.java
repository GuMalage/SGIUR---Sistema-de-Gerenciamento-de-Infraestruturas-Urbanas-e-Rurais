package br.com.service;

import br.com.dao.AtividadePrincipalDao;
import br.com.model.AtividadePrincipal;
import jakarta.persistence.EntityManager;

import java.util.List;


public class AtividadePrincipalService {
    private AtividadePrincipalDao atividadePrincipalDao;

    public AtividadePrincipalService(EntityManager em) {
        atividadePrincipalDao = new AtividadePrincipalDao(em);
    }

    public void cadastrarAtividadePrincipal(AtividadePrincipal atividade) {
        atividadePrincipalDao.cadastrar(atividade);
    }

    public void atualizarAtividadePrincipal(AtividadePrincipal atividade) {
        atividadePrincipalDao.atualizar(atividade);
    }

    public void removerAtividadePrincipal(AtividadePrincipal atividade) {
        atividadePrincipalDao.remover(atividade);
    }

    public AtividadePrincipal buscarAtividadePrinciaplPorId(int id) {
        return atividadePrincipalDao.buscarPorId(id);
    }

    public List<AtividadePrincipal> listarTodasAsAtividades() {
        return  atividadePrincipalDao.buscarTodos();
    }

    public AtividadePrincipal buscarAtividadePrinciaplPorNome(String nome) {
        return atividadePrincipalDao.buscarPorNome("nomeAtividade", nome);
    }

}
