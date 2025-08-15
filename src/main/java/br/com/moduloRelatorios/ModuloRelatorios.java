package br.com.moduloRelatorios;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ModuloRelatorios {
    private static final Scanner scanner = new Scanner(System.in);

    public void iniciarRelatorio() {
        boolean continuar = true;
        BaixarRelatorio baixarRelatorio = new BaixarRelatorio();

        while (continuar) {
            System.out.println("\n============/SELECIONE UMA OPERACAO");
            System.out.println("[1]-Emitir Relatorio");
            System.out.println("[2]-Baixar Relatorio Em Arquivo Binario");
            System.out.println("[3]-Baixar Relação contatos Para Emissão de Comunicado de Desligamento de Agua em Arquivo JSON");
            System.out.println("[4]-Sair");
            System.out.print("-->");
            int op = scanner.nextInt();

            switch (op) {
                case 1 -> {
                    GerarReletorio gerarReletorio = new GerarReletorio();
                    boolean continuar1 = true;
                    while(continuar1){
                        System.out.println("\n============/SELECIONE O RELATORIO QUE DESEJA GERAR");
                        System.out.println("[1]-Conexão Unidade Consumidora Unidade de Tratamento por periodo");
                        System.out.println("[2]-Criticidade de locomoção por Localidade");
                        System.out.println("[3]-Relatorio de contatos para Comunicado de Desligamento de Agua");
                        System.out.println("[4]-Relatorio de falhas por Unidades Distribuidoras de Luz que atendem determinada Localidade");
                        System.out.println("[5]-Manutençãoes por Unidade de Tratamento");
                        System.out.println("[6]-Relatorio quantidade de pessoas atendidas por Unidade Distribuidora de Luz");
                        System.out.println("[7]-Relatorio população atendida por saneamento basico em nas Localidades de uma Cidade");
                        System.out.println("[8]-Relatorio população atendida por saneamento basico completo(por cidade)");
                        System.out.println("[9]-Ruas e Linhas atendidas por coleta seletiva de lixo");
                        System.out.println("[10]-Ruas e Linhas não atendidas por coleta seletiva de lixo");
                        System.out.println("[11]-Relatorio completo coleta seletiva de lixo");
                        System.out.println("[12]-Sair");
                        System.out.print("-->");
                        int op1 = scanner.nextInt();
                        switch(op1){
                            case 1 ->{
                                LocalDate dataInicio = null;
                                LocalDate dataFim = null;
                                if (scanner.hasNextLine()) scanner.nextLine();
                                while (dataInicio == null) {
                                    System.out.print("\nInforme a data do início do periodo (aaaa-mm-dd): ");
                                    String data = scanner.nextLine();
                                    try {
                                        dataInicio = LocalDate.parse(data);
                                    } catch (DateTimeParseException e) {
                                        System.out.println("Data inválida. Tente novamente no formato aaaa-mm-dd.");
                                    }
                                }
                                while (dataFim == null) {
                                    System.out.print("Informe a data de fim do periodo (aaaa-mm-dd): ");
                                    String data = scanner.nextLine();
                                    try {
                                        dataFim = LocalDate.parse(data);
                                    } catch (DateTimeParseException e) {
                                        System.out.println("Data inválida. Tente novamente no formato aaaa-mm-dd.");
                                    }
                                }
                                gerarReletorio.gerarRelatorioConexaoUnidadeConsumidoraTratamentoPorPeriodo(dataInicio, dataFim);
                            }
                            case 2 ->{
                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("\nInforme o nome da Localidade: ");
                                String nomeLocalidade = scanner.nextLine();
                                gerarReletorio.gerarRelatorioCriticidadeDeLocomocaoPorLocalidade(nomeLocalidade);
                            }
                            case 3 ->{
                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("\nInforme o nome da Unidade Distribuidora que irá interromper o fornecimento de agua: ");
                                String nomeUnidade = scanner.nextLine();
                                gerarReletorio.gerarRelatorioContatosParaEmissaoDeComunicadoDeDesligamentoDeAgua(nomeUnidade);
                            }
                            case 4 ->{
                                gerarReletorio.gerarRelatorioFalhasUnidadeDistribuidoraDeLuzPorLocalidade();
                            }
                            case 5 ->{
                                gerarReletorio.gerarRelatorioManutencoesPorUnidadeDeTratamento();
                            }
                            case 6 ->{
                                gerarReletorio.gerarRelatorioPessoasAtendidasPorUnidadeDistribuidoraDeLuz();
                            }
                            case 7 ->{
                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("\nInforme o nome da Ciadade: ");
                                String nomeLocalidade = scanner.nextLine();
                                gerarReletorio.gerarRelatorioPorcentagemPopulacaoAtendidaPorSaneamentoBasicoPorLocalidade(nomeLocalidade);
                            }
                            case 8 ->{
                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("\nInforme o nome da Cidade: ");
                                String nomeCidade = scanner.nextLine();
                                gerarReletorio.gerarRelatorioSaneamentoBasicoPorCidadeCompleto(nomeCidade);
                            }
                            case 9 ->{
                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("\nInforme o nome da Localidade: ");
                                String nomeLocalidade = scanner.nextLine();
                                gerarReletorio.gerarRelatorioRuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade(nomeLocalidade);
                            }
                            case 10 ->{
                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("\nInforme o nome da Localidade: ");
                                String nomeLocalidade = scanner.nextLine();
                                gerarReletorio.gerarRelatorioRuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade(nomeLocalidade);
                            }
                            case 11 ->{
                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("\nInforme o nome da Localidade: ");
                                String nomeLocalidade = scanner.nextLine();
                                gerarReletorio.gerarRelatorioColetaSeletivaPorLocalidadeCompleto(nomeLocalidade);
                            }
                            case 12 ->{
                                continuar1 = false;
                            }
                            default ->{
                                System.out.println("Opção invalida!");
                            }
                        }
                    }
                }

                case 2 -> {
                    boolean continuar2 = true;
                    while(continuar2){
                        System.out.println("\n============/SELECIONE O RELATÓRIO QUE DESEJA GERAR");
                        System.out.println("[1]-Baixar em Arquivo Binário: Conexão Unidade Consumidora Unidade de Tratamento por período");
                        System.out.println("[2]-Baixar em Arquivo Binário: Criticidade de locomoção por Localidade");
                        System.out.println("[3]-Baixar em Arquivo Binário: Relatório de contatos para Comunicado de Desligamento de Água");
                        System.out.println("[4]-Baixar em Arquivo Binário: Relatório de falhas por Unidades Distribuidoras de Luz que atendem determinada Localidade");
                        System.out.println("[5]-Baixar em Arquivo Binário: Manutenções por Unidade de Tratamento");
                        System.out.println("[6]-Baixar em Arquivo Binário: Relatório quantidade de pessoas atendidas por Unidade Distribuidora de Luz");
                        System.out.println("[7]-Baixar em Arquivo Binário: Relatório população atendida por saneamento básico em pos Localidades de um Cidade");
                        System.out.println("[8]-Baixar em Arquivo Binário: Ruas e Linhas atendidas por coleta seletiva de lixo");
                        System.out.println("[9]-Baixar em Arquivo Binário: Ruas e Linhas não atendidas por coleta seletiva de lixo");
                        System.out.println("[10]-Sair");
                        System.out.print("-->");
                        int op2 = scanner.nextInt();
                        switch(op2){
                            case 1 ->{
                                LocalDate dataInicio = null;
                                LocalDate dataFim = null;
                                if (scanner.hasNextLine()) scanner.nextLine();
                                while (dataInicio == null) {
                                    System.out.print("\nInforme a data do início do periodo (aaaa-mm-dd): ");
                                    String data = scanner.nextLine();
                                    try {
                                        dataInicio = LocalDate.parse(data);
                                    } catch (DateTimeParseException e) {
                                        System.out.println("Data inválida. Tente novamente no formato aaaa-mm-dd.");
                                    }
                                }
                                while (dataFim == null) {
                                    System.out.print("Informe a data de dim do periodo (aaaa-mm-dd): ");
                                    String data = scanner.nextLine();
                                    try {
                                        dataFim = LocalDate.parse(data);
                                    } catch (DateTimeParseException e) {
                                        System.out.println("Data inválida. Tente novamente no formato aaaa-mm-dd.");
                                    }
                                }
                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("Informe o nome do arquivo que deseja salvar o relatório: ");
                                String nomeArquivoBinario = scanner.nextLine();

                                nomeArquivoBinario = nomeArquivoBinario + "_" + LocalDate.now() + ".bin";

                                baixarRelatorio.baixarEmArquivoBinarioRelatorioConexaoUnidadeConsumidoraTratamento(nomeArquivoBinario, dataInicio, dataFim);
                            }
                            case 2 ->{
                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("\nInforme o nome da Localidade: ");
                                String nomeLocalidade = scanner.nextLine();

                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("Informe o nome do arquivo que deseja salvar o relatório: ");
                                String nomeArquivoBinario = scanner.nextLine();

                                nomeArquivoBinario = nomeArquivoBinario + "_" + LocalDate.now() + ".bin";

                                baixarRelatorio.baixarEmArquivoBinarioRelatorioCriticidadeLocomocao(nomeArquivoBinario, nomeLocalidade);
                            }
                            case 3 ->{
                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("\nInforme o nome da Unidade Distribuidora que irá interromper o fornecimento de agua: ");
                                String nomeUnidade = scanner.nextLine();

                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.println("Informe o nome do arquivo que deseja salvar o relatório: ");
                                String nomeArquivoBinario = scanner.nextLine();

                                nomeArquivoBinario = nomeArquivoBinario + "_" + LocalDate.now() + ".bin";

                                baixarRelatorio.baixarEmArquivoBinarioContatosParaDesligamentoAgua(nomeArquivoBinario, nomeUnidade);
                            }
                            case 4 ->{
                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("Informe o nome do arquivo que deseja salvar o relatório: ");
                                String nomeArquivoBinario = scanner.nextLine();

                                nomeArquivoBinario = nomeArquivoBinario + "_" + LocalDate.now() + ".bin";

                                baixarRelatorio.baixarEmArquivoBinarioRelatorioFalhasDistribuidoraLuz(nomeArquivoBinario);
                            }
                            case 5 ->{
                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("Informe o nome do arquivo que deseja salvar o relatório: ");
                                String nomeArquivoBinario = scanner.nextLine();

                                nomeArquivoBinario = nomeArquivoBinario + "_" + LocalDate.now() + ".bin";

                                baixarRelatorio.baixarEmArquivoBinarioManutencoesPorUnidadeTratamento(nomeArquivoBinario);
                            }
                            case 6 ->{
                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("Informe o nome do arquivo que deseja salvar o relatório: ");
                                String nomeArquivoBinario = scanner.nextLine();

                                nomeArquivoBinario = nomeArquivoBinario + "_" + LocalDate.now() + ".bin";
                                baixarRelatorio.baixarEmArquivoBinarioPessoasAtendidasPorDistribuidoraLuz(nomeArquivoBinario);
                            }
                            case 7 ->{
                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("\nInforme o nome da Cidade: ");
                                String nomeLocalidade = scanner.nextLine();

                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("Informe o nome do arquivo que deseja salvar o relatório: ");
                                String nomeArquivoBinario = scanner.nextLine();

                                nomeArquivoBinario = nomeArquivoBinario + "_" + LocalDate.now() + ".bin";

                                baixarRelatorio.baixarEmArquivoBinarioRelatorioPopulacaoAtendidaPorSaneamentoBasico(nomeArquivoBinario, nomeLocalidade);
                            }
                            case 8 ->{
                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("\nInforme o nome da Localidade: ");
                                String nomeLocalidade = scanner.nextLine();

                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("Informe o nome do arquivo que deseja salvar o relatório: ");
                                String nomeArquivoBinario = scanner.nextLine();

                                nomeArquivoBinario = nomeArquivoBinario + "_" + LocalDate.now() + ".bin";

                                baixarRelatorio.baixarEmArquivoBinarioRuasLinhasAtendidasColeta(nomeArquivoBinario, nomeLocalidade);
                            }
                            case 9 -> {
                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("\nInforme o nome da Localidade: ");
                                String nomeLocalidade = scanner.nextLine();

                                if (scanner.hasNextLine()) scanner.nextLine();
                                System.out.print("Informe o nome do arquivo que deseja salvar o relatório: ");
                                String nomeArquivoBinario = scanner.nextLine();

                                nomeArquivoBinario = nomeArquivoBinario + "_" + LocalDate.now() + ".bin";

                                baixarRelatorio.baixarEmArquivoBinarioRuasLinhasNaoAtendidasColeta(nomeArquivoBinario, nomeLocalidade);
                            }
                            case 10 ->{
                                continuar2 = false;
                            }
                            default ->{
                                System.out.println("Opção invalida!");
                            }
                        }
                    }

                }

                case 3 -> {
                    System.out.print("\nInforme o nome da Unidade Distribuidora que irá interromper o fornecimento de agua: ");
                    String nomeUnidade = scanner.nextLine();

                    scanner.nextLine();
                    System.out.print("Informe o nome do arquivo que deseja salvar o JSON: ");
                    String nomeArquivoJson = scanner.nextLine();

                    nomeArquivoJson = nomeArquivoJson + "_" + LocalDate.now() + ".json";

                    baixarRelatorio.baixarEmArquivoJsonContatosParaDesligamentoAgua(nomeArquivoJson, nomeUnidade);
                }

                case 4 -> {
                    continuar = false;
                }

                default -> {
                    System.out.println("Opção invalida!");
                }
            }
        }
    }
}
