package br.com.service;

import br.com.dao.ConexaoUnidadeConsumidoraDistribuidoraDao;
import br.com.model.ConexaoUnidadeConsumidoraDistribuidora;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ConexaoUnidadeConsumidoraDistribuidoraService {
    private ConexaoUnidadeConsumidoraDistribuidoraDao conexaoUnidadeConsumidoraDistribuidoraDao;

    public ConexaoUnidadeConsumidoraDistribuidoraService(EntityManager em) {
        conexaoUnidadeConsumidoraDistribuidoraDao = new ConexaoUnidadeConsumidoraDistribuidoraDao(em);
    }

    public void cadastrarConexaoUnidadeConsumidoraDistribuidora(ConexaoUnidadeConsumidoraDistribuidora conexaoUnidadeConsumidoraDistribuidora) {
        conexaoUnidadeConsumidoraDistribuidoraDao.cadastrar(conexaoUnidadeConsumidoraDistribuidora);
    }

    public void atualizarConexaoUnidadeConsumidoraDistribuidora(ConexaoUnidadeConsumidoraDistribuidora conexaoUnidadeConsumidoraDistribuidora) {
        conexaoUnidadeConsumidoraDistribuidoraDao.atualizar(conexaoUnidadeConsumidoraDistribuidora);
    }

    public void removerConexaoUnidadeConsumidoraDistribuidora(ConexaoUnidadeConsumidoraDistribuidora conexaoUnidadeConsumidoraDistribuidora) {
        conexaoUnidadeConsumidoraDistribuidoraDao.remover(conexaoUnidadeConsumidoraDistribuidora);
    }

    public ConexaoUnidadeConsumidoraDistribuidora buscarConexaoUnidadeConsumidoraDistribuidoraPorId(int id) {
        return conexaoUnidadeConsumidoraDistribuidoraDao.buscarPorId(id);
    }

    public List<ConexaoUnidadeConsumidoraDistribuidora> listarTodasAsConexoesUnidadeConsumidoraDistribuidora() {
        return conexaoUnidadeConsumidoraDistribuidoraDao.buscarTodos();
    }




}
