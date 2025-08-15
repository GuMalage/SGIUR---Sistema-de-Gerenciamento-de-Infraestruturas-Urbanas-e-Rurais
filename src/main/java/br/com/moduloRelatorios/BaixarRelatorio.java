package br.com.moduloRelatorios;

import br.com.service.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Scanner;

public class BaixarRelatorio {
    private static final Scanner scanner = new Scanner(System.in);
    private static EntityManager em;

    static {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PostgresPU");
        em = emf.createEntityManager();
    }

    CidadeService cidadeService = new CidadeService(em);
    LocalidadeService localidadeService = new LocalidadeService(em);
    RuaLinhaService ruaLinhaService = new RuaLinhaService(em);
    UnidadeDistribuidoraService unidadeDistribuidoraService = new UnidadeDistribuidoraService(em);
    ConexaoUnidadeConsumidoraTratamentoService conexaoUnidadeConsumidoraTratamentoService = new ConexaoUnidadeConsumidoraTratamentoService(em);
    ManutencaoUnidadeTratamentoService manutencaoUnidadeTratamentoService = new ManutencaoUnidadeTratamentoService(em);

    public void baixarEmArquivoBinarioRelatorioPopulacaoAtendidaPorSaneamentoBasico(String nomeArquivoBinario, String nomeCidade) {
        cidadeService.salvarPopulacaoLocalidadeAtendidaPorSaneamentoBasicoEmArquivoBinario("Relatorios/RelatoriosBin/" + nomeArquivoBinario, nomeCidade);
    }

    public void baixarEmArquivoBinarioRelatorioConexaoUnidadeConsumidoraTratamento(String nomeArquivoBinario, LocalDate dataInicio, LocalDate dataFim) {
        conexaoUnidadeConsumidoraTratamentoService.salvarConexoesUnidadeConsumidoraTratamentoPorPeriodoEmBinario("Relatorios/RelatoriosBin/" + nomeArquivoBinario, dataInicio, dataFim);
    }

    public void baixarEmArquivoBinarioRelatorioFalhasDistribuidoraLuz(String nomeArquivoBinario) {
        localidadeService.salvarFalhasUnidadeDistribuidoraDeLuzPorLocalidadeEmArquivoBinario("Relatorios/RelatoriosBin/" + nomeArquivoBinario);
    }

    public void baixarEmArquivoBinarioRelatorioCriticidadeLocomocao(String nomeArquivoBinario, String nomeLocalidade) {
        localidadeService.salvarCriticidadeDeLocomocaoPorLocalidadeEmArquivoBinario("Relatorios/RelatoriosBin/" + nomeArquivoBinario, nomeLocalidade);
    }

    public void baixarEmArquivoBinarioRuasLinhasAtendidasColeta(String nomeArquivoBinario, String nomeLocalidade) {
        ruaLinhaService.salvarRuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidadeEmArquivoBinario("Relatorios/RelatoriosBin/" + nomeArquivoBinario, nomeLocalidade);
    }

    public void baixarEmArquivoBinarioRuasLinhasNaoAtendidasColeta(String nomeArquivoBinario, String nomeLocalidade) {
        ruaLinhaService.salvarRuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidadeEmArquivoBinario("Relatorios/RelatoriosBin/" + nomeArquivoBinario, nomeLocalidade);
    }

    public void baixarEmArquivoBinarioPessoasAtendidasPorDistribuidoraLuz(String nomeArquivoBinario) {
        unidadeDistribuidoraService.salvarPessoasAtendidasPorUnidadeDistribuidoraLuzEmArquivoBinario("Relatorios/RelatoriosBin/" + nomeArquivoBinario);
    }

    public void baixarEmArquivoBinarioContatosParaDesligamentoAgua(String nomeArquivoBinario, String nomeUnidade) {
        unidadeDistribuidoraService.salvarEmitirComunicadoDesligamentoDeAguaEmArquivoBinario("Relatorios/RelatoriosBin/" + nomeArquivoBinario, nomeUnidade);
    }

    public void baixarEmArquivoBinarioManutencoesPorUnidadeTratamento(String nomeArquivoBinario) {
        manutencaoUnidadeTratamentoService.salvarManutencoesPorUnidadeDeTratamentoEmArquivoBinario("Relatorios/RelatoriosBin/" + nomeArquivoBinario);
    }


    public void baixarEmArquivoJsonContatosParaDesligamentoAgua(String nomeArquivoJson, String nomeUnidade){
        unidadeDistribuidoraService.salvarEmitirComunicadoDesligamentoDeAguaEmArquivoJson("Relatorios/RelatoriosJson/" + nomeArquivoJson, nomeUnidade);
    }

}
