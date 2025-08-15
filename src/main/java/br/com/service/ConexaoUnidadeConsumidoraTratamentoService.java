package br.com.service;

import br.com.dao.ConexaoUnidadeConsumidoraTratamentoDao;
import br.com.model.ConexaoUnidadeConsumidoraTratamento;
import br.com.relatorios.ConexoesUnidadeConsumidoraTratamentoPorPeriodo;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class ConexaoUnidadeConsumidoraTratamentoService {
    private ConexaoUnidadeConsumidoraTratamentoDao conexaoUnidadeConsumidoraTratamentoDao;

    public ConexaoUnidadeConsumidoraTratamentoService(EntityManager em) {
        conexaoUnidadeConsumidoraTratamentoDao = new ConexaoUnidadeConsumidoraTratamentoDao(em);
    }

    public void cadastrarConexaoUnidadeConsumidoraTratamento(ConexaoUnidadeConsumidoraTratamento conexaoUnidadeConsumidoraTratamento) {
        conexaoUnidadeConsumidoraTratamentoDao.cadastrar(conexaoUnidadeConsumidoraTratamento);
    }

    public void atualizarConexaoUnidadeConsumidoraTratamento(ConexaoUnidadeConsumidoraTratamento conexaoUnidadeConsumidoraTratamento) {
        conexaoUnidadeConsumidoraTratamentoDao.atualizar(conexaoUnidadeConsumidoraTratamento);
    }

    public void removerConexaoUnidadeConsumidoraTratamento(ConexaoUnidadeConsumidoraTratamento conexaoUnidadeConsumidoraTratamento) {
        conexaoUnidadeConsumidoraTratamentoDao.remover(conexaoUnidadeConsumidoraTratamento);
    }

    public ConexaoUnidadeConsumidoraTratamento buscarConexaoUnidadeConsumidoraTratamentoPorId(int id) {
        return conexaoUnidadeConsumidoraTratamentoDao.buscarPorId(id);
    }

    public List<ConexaoUnidadeConsumidoraTratamento> listarTodasAsConexoesUnidadeConsumidoraTratamento() {
        return conexaoUnidadeConsumidoraTratamentoDao.buscarTodos();
    }

    public List<ConexoesUnidadeConsumidoraTratamentoPorPeriodo> listarConexaoUnidadeConsumidoraTratamentoPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        return conexaoUnidadeConsumidoraTratamentoDao.listaConexoesUnidadeConsumidoraTratamentoPorPeriodo(dataInicial, dataFinal);
    }

    public void salvarConexoesUnidadeConsumidoraTratamentoPorPeriodoEmBinario(String nomeArquivoBinario, LocalDate dataInicial, LocalDate dataFinal) {
        conexaoUnidadeConsumidoraTratamentoDao.salvarEmArquivoBinario(nomeArquivoBinario, listarConexaoUnidadeConsumidoraTratamentoPorPeriodo(dataInicial, dataFinal));
    }

}
