package br.com.moduloRelatorios;

import br.com.service.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Scanner;

public class GerarReletorio {
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

    public void gerarRelatorioPorcentagemPopulacaoAtendidaPorSaneamentoBasicoPorLocalidade(String nomeCidade) {
        System.out.println("Relatório Populacao Atendida Por Saneamento Basico Por Localidade\n");
        System.out.println(cidadeService.porcentagemPopulacaoAtendidaPorSaneamentoBasicoPorLocalidade(nomeCidade));
    }

    public void gerarRelatorioSaneamentoBasicoPorCidadeCompleto(String nomeCidade) {
        System.out.println("Relatório Populacao Atendida Por Saneamento Basico Por Localidade na cidade: " + nomeCidade + "\n");
        System.out.println(cidadeService.relatorioSaneamentoBasicoPorCidadeCompleto(cidadeService.porcentagemPopulacaoAtendidaPorSaneamentoBasicoPorLocalidade(nomeCidade)));
    }

    public void gerarRelatorioConexaoUnidadeConsumidoraTratamentoPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        System.out.println("Conexões entre Unidades Consumidora e Unidades Tratamento ente " + dataInicial + " e " + dataFinal + "\n");
        System.out.println(conexaoUnidadeConsumidoraTratamentoService.listarConexaoUnidadeConsumidoraTratamentoPorPeriodo(dataInicial, dataFinal));
    }

    public void gerarRelatorioFalhasUnidadeDistribuidoraDeLuzPorLocalidade(){
        System.out.println("Relatório de Falhas Distribuidora Por Localidade\n");
        System.out.println(localidadeService.listarFalhasUnidadeDistribuidoraDeLuzPorLocalidade());
    }

    public void gerarRelatorioCriticidadeDeLocomocaoPorLocalidade(String nomeLocalidade) {
        System.out.println("Relatorio situação da criticidade de locomoção das Ruas - Linhas da localidade: " + nomeLocalidade + "\n");
        System.out.println(localidadeService.listarCriticidadeDeLocomocaoPorLocalidade(nomeLocalidade));
    }

    public void gerarRelatorioRuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade(String nomeLocalidade) {
        System.out.println("Ruas e Linhas da localidade: " + nomeLocalidade + " atendidas por Coleta Seletiva de Lixo\n");
        System.out.println(ruaLinhaService.listarRuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade(nomeLocalidade));
    }

    public void gerarRelatorioRuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade(String nomeLocalidade) {
        System.out.println("Ruas e Linhas da localidade: " + nomeLocalidade + " que não são atendidas por Coleta Seletiva de Lixo\n");
        System.out.println(ruaLinhaService.listarRuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade(nomeLocalidade));
    }

    public void gerarRelatorioColetaSeletivaPorLocalidadeCompleto(String nomeLocalidade) {
        System.out.println("Relatorio Completo Coleta Seletiva de Lixo: " + nomeLocalidade + "\n");
        System.out.println(localidadeService.relatorioColetaSeletivaPorLocalidadeCompleto( ruaLinhaService.listarRuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade(nomeLocalidade),
                ruaLinhaService.listarRuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade(nomeLocalidade)));
    }

    public void gerarRelatorioPessoasAtendidasPorUnidadeDistribuidoraDeLuz(){
        System.out.println("População atendida por Unidades Distribuidoras de Luz:  \n");
        System.out.println(unidadeDistribuidoraService.listarPessoasAtendidasPorUnidade());
    }

    public void gerarRelatorioContatosParaEmissaoDeComunicadoDeDesligamentoDeAgua(String nomeUnidade){
        System.out.println("Lista de contatos para comunicação do desligamento do fornecimento de agua da Unidade " + nomeUnidade + "\n");
        System.out.println(unidadeDistribuidoraService.listarContatosParaEmissaoDeComunicadoDeDesligamentoDeAgua(nomeUnidade));
    }

    public void gerarRelatorioManutencoesPorUnidadeDeTratamento(){
        System.out.println(manutencaoUnidadeTratamentoService.listarQuantidadeDeManutencoesPorUnidadeDeTratamento());
    }

}