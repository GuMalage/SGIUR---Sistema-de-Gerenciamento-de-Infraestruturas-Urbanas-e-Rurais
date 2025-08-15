package br.com.service;

import br.com.dao.RuaLinhaDao;
import br.com.model.RuaLinha;
import br.com.relatorios.RuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade;
import br.com.relatorios.RuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade;
import jakarta.persistence.EntityManager;

import java.util.List;

public class RuaLinhaService {
    private RuaLinhaDao ruaLinhaDao;

    public RuaLinhaService(EntityManager em) {
        ruaLinhaDao = new RuaLinhaDao(em);
    }

    public void cadastrarRuaLinha(RuaLinha ruaLinha) {
        ruaLinhaDao.cadastrar(ruaLinha);
    }

    public void atualizarRuaLinha(RuaLinha ruaLinha) {
        ruaLinhaDao.atualizar(ruaLinha);
    }

    public void removerRuaLinha(RuaLinha ruaLinha) {
        ruaLinhaDao.remover(ruaLinha);
    }

    public RuaLinha buscarRuaLinhaPorNome(int id) {
        return ruaLinhaDao.buscarPorId(id);
    }

    public List<RuaLinha> listarTodasAsRuaLinhas() {
        return ruaLinhaDao.buscarTodos();
    }

    public RuaLinha buscarRuaLinhaPorNome(String nome) {
        return ruaLinhaDao.buscarPorNome("nomeRua", nome);
    }

    public List<RuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade> listarRuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade(String nomeLocalidade) {
        return ruaLinhaDao.listarRuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade(nomeLocalidade);
    }

    public void salvarRuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidadeEmArquivoBinario(String nomeArquivoBinario, String nomeLocalidade) {
        ruaLinhaDao.salvarEmArquivoBinario(nomeArquivoBinario, listarRuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade(nomeLocalidade));
    }

    public List<RuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade> listarRuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade(String nomeLocalidade) {
        return ruaLinhaDao.listarRuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade(nomeLocalidade);
    }

    public void salvarRuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidadeEmArquivoBinario(String nomeArquivoBinario, String nomeLocalidade) {
        ruaLinhaDao.salvarEmArquivoBinario(nomeArquivoBinario, listarRuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade(nomeLocalidade));
    }

}
