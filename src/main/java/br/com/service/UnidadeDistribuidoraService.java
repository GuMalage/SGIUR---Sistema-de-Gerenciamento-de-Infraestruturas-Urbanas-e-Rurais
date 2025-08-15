package br.com.service;

import br.com.dao.UnidadeDistribuidoraDao;
import br.com.model.UnidadeDistribuidora;
import br.com.relatorios.EmitirComunicadoDesligamentoDeAgua;
import br.com.relatorios.PessoasAtendidasPorUnidadeDistribuidoraLuz;
import jakarta.persistence.EntityManager;
import java.util.List;

public class UnidadeDistribuidoraService {
    private UnidadeDistribuidoraDao unidadeDistribuidoraDao;

    public UnidadeDistribuidoraService(EntityManager em) {
        unidadeDistribuidoraDao = new UnidadeDistribuidoraDao(em);
    }

    public void cadastrarUnidadeDistribuidora(UnidadeDistribuidora unidadeDistribuidora) {
        unidadeDistribuidoraDao.cadastrar(unidadeDistribuidora);
    }

    public void atualizarUnidadeDistribuidora(UnidadeDistribuidora unidadeDistribuidora) {
        unidadeDistribuidoraDao.atualizar(unidadeDistribuidora);
    }

    public void removerUnidadeDistribuidora(UnidadeDistribuidora unidadeDistribuidora) {
        unidadeDistribuidoraDao.remover(unidadeDistribuidora);
    }

    public UnidadeDistribuidora buscarUnidadeDistribuidoraPorId(int id) {
        return unidadeDistribuidoraDao.buscarPorId(id);
    }

    public List<UnidadeDistribuidora> listarTodasAsUnidadeDistribuidoras() {
        return unidadeDistribuidoraDao.buscarTodos();
    }

    public UnidadeDistribuidora buscarUnidadeDistribuidoraPorNome(String nome) {
        return unidadeDistribuidoraDao.buscarPorNome("nomeUnidade", nome);
    }

    public List<PessoasAtendidasPorUnidadeDistribuidoraLuz> listarPessoasAtendidasPorUnidade() {
        return unidadeDistribuidoraDao.pessoasAtendidasPorUnidadeDistribuidoraLuz();
    }

    public void salvarPessoasAtendidasPorUnidadeDistribuidoraLuzEmArquivoBinario(String nomeArquivoBinario) {
        unidadeDistribuidoraDao.salvarEmArquivoBinario(nomeArquivoBinario, listarPessoasAtendidasPorUnidade());
    }

    public List<EmitirComunicadoDesligamentoDeAgua> listarContatosParaEmissaoDeComunicadoDeDesligamentoDeAgua(String nomeUnidade) {
       return unidadeDistribuidoraDao.listarContatosParaEmissaoDeComunicadoDeDesligamentoDeAgua(nomeUnidade);
    }

    public void salvarEmitirComunicadoDesligamentoDeAguaEmArquivoBinario(String nomeArquivoBinario, String nomeUnidade) {
        unidadeDistribuidoraDao.salvarEmArquivoBinario(nomeArquivoBinario, listarContatosParaEmissaoDeComunicadoDeDesligamentoDeAgua(nomeUnidade));
    }

    public void salvarEmitirComunicadoDesligamentoDeAguaEmArquivoJson(String nomeArquivoJson, String nomeUnidade) {
        unidadeDistribuidoraDao.converterListaDeContatosParaEmissaoDeComunicadoDeDesligamentoDeAguaEmArquivoJson(nomeArquivoJson, listarContatosParaEmissaoDeComunicadoDeDesligamentoDeAgua(nomeUnidade));
    }

}
