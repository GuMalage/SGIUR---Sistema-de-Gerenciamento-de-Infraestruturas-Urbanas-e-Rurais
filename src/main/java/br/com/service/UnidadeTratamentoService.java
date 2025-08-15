package br.com.service;

import br.com.dao.UnidadeTratamentoDao;
import br.com.model.UnidadeTratamento;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UnidadeTratamentoService {
    private UnidadeTratamentoDao unidadeTratamentoDao;

    public UnidadeTratamentoService(EntityManager em) {
        this.unidadeTratamentoDao = new UnidadeTratamentoDao(em);
    }

    public void cadastrarUnidadeTratamento(UnidadeTratamento unidadeTratamento) {
        unidadeTratamentoDao.cadastrar(unidadeTratamento);
    }

    public void atualizarUnidadeTratamento(UnidadeTratamento unidadeTratamento) {
        unidadeTratamentoDao.atualizar(unidadeTratamento);
    }

    public void removerUnidadeTratamento(UnidadeTratamento unidadeTratamento) {
        unidadeTratamentoDao.remover(unidadeTratamento);
    }

    public UnidadeTratamento buscarUnidadeTratamentoPorId(int id) {
        return unidadeTratamentoDao.buscarPorId(id);
    }

    public List<UnidadeTratamento> listarTodasAsUnidadesDeTratamento() {
        return unidadeTratamentoDao.buscarTodos();
    }

    public UnidadeTratamento buscarUnidadeTratamentoPorNome(String nome) {
        return unidadeTratamentoDao.buscarPorNome("nomeUnidade", nome);
    }

}
