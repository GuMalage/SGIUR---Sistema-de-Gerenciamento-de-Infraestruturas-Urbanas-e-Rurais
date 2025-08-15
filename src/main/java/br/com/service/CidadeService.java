package br.com.service;

import br.com.dao.CidadeDao;
import br.com.model.Cidade;
import br.com.relatorios.PopulacaoLocalidadeAtendidaPorSaneamentoBasico;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class CidadeService {
    private CidadeDao cidadeDao;
    private static EntityManager em;

    public CidadeService(EntityManager em) {
        cidadeDao = new CidadeDao(em);
    }

    public void cadastrarCidade(Cidade cidade) {
        this.cidadeDao.cadastrar(cidade);
    }

    public void atualizarCidade(Cidade cidade) {
        this.cidadeDao.atualizar(cidade);
    }

    public void removerCidade(Cidade cidade) {
        this.cidadeDao.remover(cidade);
    }

    public Cidade buscarCidadePorId(int id) {
        return cidadeDao.buscarPorId(id);
    }

    public List<Cidade> listarTodasAsCidades() {
        return cidadeDao.buscarTodos();
    }

    public Cidade buscarCidadePorNome(String nome) {
        return cidadeDao.buscarPorNome("nomeCidade", nome);
    }

    public List<PopulacaoLocalidadeAtendidaPorSaneamentoBasico> porcentagemPopulacaoAtendidaPorSaneamentoBasicoPorLocalidade(String nomeCidade){
        return cidadeDao.porcentagemPopulacaoCidadeAtendidaPorSaneamentoBasico(nomeCidade);
    }

    public void salvarPopulacaoLocalidadeAtendidaPorSaneamentoBasicoEmArquivoBinario(String nomeArquivoBinario, String nomeCidade){
        cidadeDao.salvarEmArquivoBinario(nomeArquivoBinario, porcentagemPopulacaoAtendidaPorSaneamentoBasicoPorLocalidade(nomeCidade));
    }

    public String relatorioSaneamentoBasicoPorCidadeCompleto(List<PopulacaoLocalidadeAtendidaPorSaneamentoBasico> lista) {
        Long somaPopulacaoComSaneamentoBasico = lista.stream()
                .map(PopulacaoLocalidadeAtendidaPorSaneamentoBasico::getPopulacaoComSaneamentoBasico)
                .reduce(0L, Long::sum);

        Cidade cidade = new Cidade();
        cidade = buscarCidadePorId(lista.getFirst().getIdCidade());

        double porcentagem = (somaPopulacaoComSaneamentoBasico.doubleValue() / cidade.getPopulacaoEstimada()) * 100;

        if (porcentagem == 100) {
            return "\nA cidade de " + cidade.getNomeCidade() +
                    " ESTÁ de acordo com a ODS 6. Porcentagem de cobertura: 100%. Meta conquistada com " +
                    Period.between(LocalDate.now(), LocalDate.of(2030, 1, 1)).getYears() +
                    " anos de antecedência.";
        } else {
            return "\nA cidade de " + cidade.getNomeCidade() +  " NÃO está de acordo com a ODS 6. " +
                    "Porcentagem de cobertura de apenas: " +  porcentagem + " dos 100% definidos como meta até 2030";
        }
    }

}
