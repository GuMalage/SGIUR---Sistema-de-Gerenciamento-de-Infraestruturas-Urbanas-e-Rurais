package br.com.service;

import br.com.dao.ManutencaoUnidadeTratamentoDao;
import br.com.model.ManutencaoUnidadeTratamento;
import br.com.relatorios.ManutencoesPorUnidadeDeTratamento;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ManutencaoUnidadeTratamentoService {
    private ManutencaoUnidadeTratamentoDao manutencaoUnidadeTratamentoDao;

    public ManutencaoUnidadeTratamentoService(EntityManager em) {
        manutencaoUnidadeTratamentoDao = new ManutencaoUnidadeTratamentoDao(em);
    }

    public void cadastrarManutencaoUnidadeTratamento(ManutencaoUnidadeTratamento manutencaoUnidadeTratamento){
        manutencaoUnidadeTratamentoDao.cadastrar(manutencaoUnidadeTratamento);
    }

    public void atualizarManutencaoUnidadeTratamento(ManutencaoUnidadeTratamento manutencaoUnidadeTratamento){
        manutencaoUnidadeTratamentoDao.atualizar(manutencaoUnidadeTratamento);
    }

    public void removerManutencaoUnidadeTratamento(ManutencaoUnidadeTratamento manutencaoUnidadeTratamento){
        manutencaoUnidadeTratamentoDao.remover(manutencaoUnidadeTratamento);
    }

    public ManutencaoUnidadeTratamento buscarManutencaoUnidadeTratamentoPorId(int id) {
        return manutencaoUnidadeTratamentoDao.buscarPorId(id);
    }

    public List<ManutencaoUnidadeTratamento> listarTodasAsManutencaoUnidadeTratamento() {
        return manutencaoUnidadeTratamentoDao.buscarTodos();
    }

    public void salvarManutencaoUnidadeTratamentoEmArquivoBinario(String nomeArquivoBinario) {
        manutencaoUnidadeTratamentoDao.salvarEmArquivoBinario(nomeArquivoBinario, listarTodasAsManutencaoUnidadeTratamento());
    }

    public List<ManutencoesPorUnidadeDeTratamento> listarQuantidadeDeManutencoesPorUnidadeDeTratamento() {
        return manutencaoUnidadeTratamentoDao.quantidadedeManutencoesPorUnidadeDeTratamento();
    }

    public void salvarManutencoesPorUnidadeDeTratamentoEmArquivoBinario(String nomeArquivoBinario) {
        manutencaoUnidadeTratamentoDao.salvarEmArquivoBinario(nomeArquivoBinario, listarQuantidadeDeManutencoesPorUnidadeDeTratamento());
    }
}
