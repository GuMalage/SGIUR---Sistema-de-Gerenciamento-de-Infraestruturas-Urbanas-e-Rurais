package br.com.moduloCadastro;

import java.util.Scanner;

public class ModuloCadastro {
    private static final Scanner scanner = new Scanner(System.in);

    public void iniciarModuloCadastro(){
        boolean continuar = true;

        while(continuar){
            System.out.println("\n============/SELECIONE UMA OPERACAO");
            System.out.println("[1]-Cadastrar");
            System.out.println("[2]-Alterar");
            System.out.println("[3]-Inativar");
            System.out.println("[4]-Sair");
            System.out.print("-->");
            int op = scanner.nextInt();

            switch(op){
                case 1 ->{
                    Cadastrar cadastrar = new Cadastrar();
                    boolean continuar1 = true;
                    while(continuar1){
                        System.out.println("\n============/SELECIONE O QUE DESEJA CADASTRAR");
                        System.out.println("[1]-Cadastrar Atividade Principal");
                        System.out.println("[2]-Cadastrar Cidade");
                        System.out.println("[3]-Cadastrar Rua - Linha");
                        System.out.println("[4]-Cadastrar Localidade");
                        System.out.println("[5]-Cadastrar Unidade Consumidora");
                        System.out.println("[6]-Cadastrar Unidade Distribuidora");
                        System.out.println("[7]-Cadastrar Unidade de Tratamento");
                        System.out.println("[8]-Cadastrar Conexao de Unidade Consumidora a uma Unidade Distribuidora");
                        System.out.println("[9]-Cadastrar Conexao de Unidade Consumidora a uma Unidade de Tratamento");
                        System.out.println("[10]-Cadastrar Rua Linha atendida Por Coleta Seletiva");
                        System.out.println("[11]-Cadastrar Manutanção em Unidade Distribuidora");
                        System.out.println("[12]-Cadastrar Manutenção em Unidade de tratamento");
                        System.out.println("[13]-Sair");
                        System.out.print("-->");
                        int op1 = scanner.nextInt();
                        switch(op1){
                            case 1 ->{
                                cadastrar.cadastrarAtividadeprincipal();
                            }
                            case 2 ->{
                                cadastrar.cadastrarCidade();
                            }
                            case 3 ->{
                                cadastrar.cadastrarRuaLinha();
                            }
                            case 4 ->{
                                cadastrar.cadastrarLocalidade();
                            }
                            case 5 ->{
                                cadastrar.cadastrarUnidadeConsumidora();
                            }
                            case 6 ->{
                                cadastrar.cadastrarUnidadeDistribuidora();
                            }
                            case 7 ->{
                                cadastrar.cadastrarUnidadeTratamento();
                            }
                            case 8 ->{
                                cadastrar.cadastrarConexaoDeUnidadeConsumidoraDistribuidora();
                            }
                            case 9 ->{
                                cadastrar.cadastrarConexaoDeUnidadeConsumidoraTratamento();
                            }
                            case 10 ->{
                                cadastrar.cadastrarRuaLinhaAtendidaPorColetaSeletiva();
                            }
                            case 11 ->{
                                cadastrar.cadastarManutencaoUnidadeDistribuidora();
                            }
                            case 12 ->{
                                cadastrar.cadastrarManutencaoUnidadeTratamento();
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

                case 2 ->{
                    Atualizar atualizar = new Atualizar();
                    boolean continuar2 = true;
                    while(continuar2){
                        System.out.println("\n============/SELECIONE O QUE DESEJA ATUALIZAR");
                        System.out.println("[1]-Atualizar Atividade Principal");
                        System.out.println("[2]-Atualizar Cidade");
                        System.out.println("[3]-Atualizar Rua - Linha");
                        System.out.println("[4]-Atualizar Localidade");
                        System.out.println("[5]-Atualizar Unidade Consumidora");
                        System.out.println("[6]-Atualizar Unidade Distribuidora");
                        System.out.println("[7]-Atualizar Unidade de Tratamento");
                        System.out.println("[8]-Atualizar Conexao de Unidade Consumidora a uma Unidade Distribuidora");
                        System.out.println("[9]-Atualizar Conexao de Unidade Consumidora a uma Unidade de Tratamento");
                        System.out.println("[10]-Atualizar Rua Linha atendida Por Coleta Seletiva");
                        System.out.println("[11]-Atualizar Manutanção em Unidade Distribuidora");
                        System.out.println("[12]-Atualizar Manutenção em Unidade de tratamento");
                        System.out.println("[13]-Sair");
                        System.out.print("-->");
                        int op2 = scanner.nextInt();
                        scanner.nextLine();
                        switch(op2){
                            case 1 ->{
                                atualizar.atualizarAtividadeprincipal();
                            }
                            case 2 ->{
                                atualizar.atualizarCidade();
                            }
                            case 3 ->{
                                atualizar.atualizarRuaLinha();
                            }
                            case 4 ->{
                                atualizar.atualizarLocalidade();
                            }
                            case 5 ->{
                                atualizar.atualizarUnidadeConsumidora();
                            }
                            case 6 ->{
                                atualizar.atualizarUnidadeDistribuidora();
                            }
                            case 7 ->{
                                atualizar.atualizarUnidadeTratamento();
                            }
                            case 8 ->{
                                atualizar.atualizarConexaoDeUnidadeConsumidoraDistribuidora();
                            }
                            case 9 ->{
                                atualizar.atualizarConexaoDeUnidadeConsumidoraTratamento();
                            }
                            case 10 ->{
                                atualizar.atualizarRuaLinhaAtendidaPorColetaSeletiva();
                            }
                            case 11 ->{
                                atualizar.atualizarManutencaoUnidadeDistribuidora();
                            }
                            case 12 ->{
                                atualizar.atualizarManutencaoUnidadeTratamento();
                            }
                            case 13 ->{
                                continuar2 = false;
                            }
                            default ->{
                                System.out.println("Opção invalida!");
                            }
                        }
                    }
                }

                case 3 ->{
                    Inativar inativar = new Inativar();
                    boolean continuar3 = true;
                    while(continuar3){
                        System.out.println("\n============/SELECIONE O QUE DESEJA INATIVAR");
                        System.out.println("[1]-Inativar Unidade Consumidora");
                        System.out.println("[2]-Inativar Unidade Distribuidora");
                        System.out.println("[3]-Inativar Unidade de Tratamento");
                        System.out.println("[999]-Remover Cidade");
                        System.out.println("[4]-Sair");
                        System.out.print("-->");
                        int op3 = scanner.nextInt();
                        switch(op3){
                            case 1 ->{
                                inativar.inativarUnidadeConsumidora();
                            }
                            case 2 ->{
                                inativar.inativarUnidadeDistribuidora();
                            }
                            case 3 ->{
                                inativar.inativarUnidadeDeTratamento();
                            }
                            case 999 ->{
                                inativar.removerCidade();
                            }
                            case 4 ->{
                                continuar3 = false;
                            }
                            default ->{
                                System.out.println("Opção invalida!");
                            }
                        }
                    }
                }

                case 4 ->{
                    continuar = false;
                }

                default -> {
                    System.out.println("Opção invalida!");
                }
            }
        }

    }


}
