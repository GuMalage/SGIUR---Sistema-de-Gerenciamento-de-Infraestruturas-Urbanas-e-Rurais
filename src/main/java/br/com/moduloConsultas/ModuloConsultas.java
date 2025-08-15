package br.com.moduloConsultas;

import br.com.model.*;
import br.com.service.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class ModuloConsultas {
    private static final Scanner scanner = new Scanner(System.in);
    private static EntityManager em;

    static {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PostgresPU");
        em = emf.createEntityManager();
    }

    AtividadePrincipalService atividadePrincipalService = new AtividadePrincipalService(em);
    CidadeService cidadeService = new CidadeService(em);
    LocalidadeService localidadeService = new LocalidadeService(em);
    RuaLinhaService ruaLinhaService = new RuaLinhaService(em);
    UnidadeConsumidoraService unidadeConsumidoraService = new UnidadeConsumidoraService(em);
    UnidadeDistribuidoraService unidadeDistribuidoraService = new UnidadeDistribuidoraService(em);
    UnidadeTratamentoService unidadeTratamentoService = new UnidadeTratamentoService(em);
    ConexaoUnidadeConsumidoraDistribuidoraService conexaoUnidadeConsumidoraDistribuidoraService = new ConexaoUnidadeConsumidoraDistribuidoraService(em);
    ConexaoUnidadeConsumidoraTratamentoService conexaoUnidadeConsumidoraTratamentoService = new ConexaoUnidadeConsumidoraTratamentoService(em);
    ColetaSeletivaPorRuaLinhaService coletaSeletivaPorRuaLinhaService = new ColetaSeletivaPorRuaLinhaService(em);
    ManutencaoUnidadeDistribuidoraService manutencaoUnidadeDistribuidoraService = new ManutencaoUnidadeDistribuidoraService(em);
    ManutencaoUnidadeTratamentoService manutencaoUnidadeTratamentoService = new ManutencaoUnidadeTratamentoService(em);

    public void iniciarModuloConsultas() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n============/SELECIONE UMA OPERACAO");
            System.out.println("[1]-Consultar Registros");
            System.out.println("[2]-Buscar Registro");
            System.out.println("[3]-Sair");
            System.out.println("-->");
            int op = scanner.nextInt();

            switch (op) {
                case 1 -> {
                    boolean continuar1 = true;
                    while(continuar1){
                        System.out.println("\n============/SELECIONE OS REGISTROS QUE DESEJA CONSULTAR");
                        System.out.println("[1]-Consultar Atividades Principais");
                        System.out.println("[2]-Consultar Cidades");
                        System.out.println("[3]-Consultar Ruas - Linhas");
                        System.out.println("[4]-Consultar Localidades");
                        System.out.println("[5]-Consultar Unidades Consumidoras");
                        System.out.println("[6]-Consultar Unidades Distribuidoras");
                        System.out.println("[7]-Consultar Unidades de Tratamento");
                        System.out.println("[8]-Consultar Conexões de Unidades Consumidoras a Unidades Distribuidoras");
                        System.out.println("[9]-Consultar Conexões de Unidades Consumidoras a Unidades de Tratamento");
                        System.out.println("[10]-Consultar Ruas - Linhas atendidas por Coleta Seletiva");
                        System.out.println("[11]-Consultar Manutenções em Unidades Distribuidoras");
                        System.out.println("[12]-Consultar Manutenções em Unidades de Tratamento");
                        System.out.println("[13]-Sair");
                        System.out.print("-->");
                        int op1 = scanner.nextInt();
                        switch(op1){
                            case 1 -> {
                                System.out.println("\nAtividades Encontradas:");
                                System.out.println(atividadePrincipalService.listarTodasAsAtividades());
                            }
                            case 2 -> {
                                System.out.println("\nCidades Encontradas:");
                                System.out.println(cidadeService.listarTodasAsCidades());
                            }
                            case 3 -> {
                                System.out.println("\nRuas/Linhas Encontradas:");
                                System.out.println(ruaLinhaService.listarTodasAsRuaLinhas());
                            }
                            case 4 -> {
                                System.out.println("\nLocalidades Encontradas:");
                                System.out.println(localidadeService.listarTodasAsLocalidades());
                            }
                            case 5 -> {
                                System.out.println("\nUnidades Consumidoras Encontradas:");
                                System.out.println(unidadeConsumidoraService.listarTodasAsUnidadeConsumidoras());
                            }
                            case 6 -> {
                                System.out.println("\nUnidades Distribuidoras Encontradas:");
                                System.out.println(unidadeDistribuidoraService.listarTodasAsUnidadeDistribuidoras());
                            }
                            case 7 -> {
                                System.out.println("\nUnidades de Tratamento Encontradas:");
                                System.out.println(unidadeTratamentoService.listarTodasAsUnidadesDeTratamento());
                            }
                            case 8 -> {
                                System.out.println("\nConexões entre Unidades Consumidoras e Distribuidoras Encontradas:");
                                System.out.println(conexaoUnidadeConsumidoraDistribuidoraService.listarTodasAsConexoesUnidadeConsumidoraDistribuidora());
                            }
                            case 9 -> {
                                System.out.println("\nConexões entre Unidades Consumidoras e de Tratamento Encontradas:");
                                System.out.println(conexaoUnidadeConsumidoraTratamentoService.listarTodasAsConexoesUnidadeConsumidoraTratamento());
                            }
                            case 10 -> {
                                System.out.println("\nRuas/Linhas Atendidas por Coleta Seletiva Encontradas:");
                                System.out.println(coletaSeletivaPorRuaLinhaService.listarTodasAsRuasLinhasComColetaSeletiva());
                            }
                            case 11 -> {
                                System.out.println("\nManutenções em Unidades Distribuidoras Encontradas:");
                                System.out.println(manutencaoUnidadeDistribuidoraService.listarTodasAsManutencoesUnidadeDistribuidora());
                            }
                            case 12 -> {
                                System.out.println("\nManutenções em Unidades de Tratamento Encontradas:");
                                System.out.println(manutencaoUnidadeTratamentoService.listarTodasAsManutencaoUnidadeTratamento());
                            }
                            case 13 ->{
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
                    scanner.nextLine(); // Limpa o buffer do scanner
                    while (continuar2) {
                        System.out.println("\n============/SELECIONE O REGISTRO QUE DESEJA BUSCAR POR NOME");
                        System.out.println("[1]-Buscar Atividade Principal por Nome");
                        System.out.println("[2]-Buscar Cidade por Nome");
                        System.out.println("[3]-Buscar Rua - Linha por Nome");
                        System.out.println("[4]-Buscar Localidade por Nome");
                        System.out.println("[5]-Buscar Unidade Consumidora por Nome");
                        System.out.println("[6]-Buscar Unidade Distribuidora por Nome");
                        System.out.println("[7]-Buscar Unidade de Tratamento por Nome");
                        System.out.println("[8]-Sair");
                        System.out.print("--> ");
                        int op2 = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer novamente

                        switch (op2) {
                            case 1 -> {
                                System.out.print("\nInforme o nome da Atividade Principal que deseja buscar: ");
                                String nome = scanner.nextLine();
                                AtividadePrincipal ap = atividadePrincipalService.buscarAtividadePrinciaplPorNome(nome);
                                if (ap != null) {
                                    System.out.println("\nAtividade Principal encontrada:\n" + ap);
                                } else {
                                    System.out.println("Nenhuma Atividade Principal encontrada com esse nome.");
                                }
                            }
                            case 2 -> {
                                System.out.print("\nInforme o nome da Cidade que deseja buscar: ");
                                String nome = scanner.nextLine();
                                Cidade cidade = cidadeService.buscarCidadePorNome(nome);
                                if (cidade != null) {
                                    System.out.println("\nCidade encontrada:\n" + cidade);
                                } else {
                                    System.out.println("Nenhuma Cidade encontrada com esse nome.");
                                }
                            }
                            case 3 -> {
                                System.out.print("\nInforme o nome da Rua/Linha que deseja buscar: ");
                                String nome = scanner.nextLine();
                                RuaLinha ruaLinha = ruaLinhaService.buscarRuaLinhaPorNome(nome);
                                if (ruaLinha != null) {
                                    System.out.println("\nRua/Linha encontrada:\n" + ruaLinha);
                                } else {
                                    System.out.println("Nenhuma Rua/Linha encontrada com esse nome.");
                                }
                            }
                            case 4 -> {
                                System.out.print("\nInforme o nome da Localidade que deseja buscar: ");
                                String nome = scanner.nextLine();
                                Localidade localidade = localidadeService.buscarLocalidadeNome(nome);
                                if (localidade != null) {
                                    System.out.println("\nLocalidade encontrada:\n" + localidade);
                                } else {
                                    System.out.println("Nenhuma Localidade encontrada com esse nome.");
                                }
                            }
                            case 5 -> {
                                System.out.print("\nInforme o nome o cpf do responsavel pela Unidade Consumidora que deseja buscar: ");
                                String cpf = scanner.nextLine();
                                UnidadeConsumidora uc = unidadeConsumidoraService.buscarUnidadeConsumidoraPorCpfResponsavel(cpf);
                                if (uc != null) {
                                    System.out.println("\nUnidade Consumidora encontrada:\n" + uc);
                                } else {
                                    System.out.println("Nenhuma Unidade Consumidora encontrada com esse nome.");
                                }
                            }
                            case 6 -> {
                                System.out.print("\nInforme o nome da Unidade Distribuidora que deseja buscar: ");
                                String nome = scanner.nextLine();
                                UnidadeDistribuidora ud = unidadeDistribuidoraService.buscarUnidadeDistribuidoraPorNome(nome);
                                if (ud != null) {
                                    System.out.println("\nUnidade Distribuidora encontrada:\n" + ud);
                                } else {
                                    System.out.println("Nenhuma Unidade Distribuidora encontrada com esse nome.");
                                }
                            }
                            case 7 -> {
                                System.out.print("\nInforme o nome da Unidade de Tratamento que deseja buscar: ");
                                String nome = scanner.nextLine();
                                UnidadeTratamento ut = unidadeTratamentoService.buscarUnidadeTratamentoPorNome(nome);
                                if (ut != null) {
                                    System.out.println("\nUnidade de Tratamento encontrada:\n" + ut);
                                } else {
                                    System.out.println("Nenhuma Unidade de Tratamento encontrada com esse nome.");
                                }
                            }
                            case 8 -> {
                                continuar2 = false;
                            }
                            default -> {
                                System.out.println("Opção inválida!");
                            }
                        }
                    }
                }


                case 3 -> {
                    continuar = false;
                }

                default -> {
                    System.out.println("Opção invalida!");
                }
            }
        }
    }
}
