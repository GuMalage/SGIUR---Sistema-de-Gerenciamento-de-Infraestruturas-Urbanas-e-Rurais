package br.com.main;

import br.com.moduloCadastro.ModuloCadastro;
import br.com.moduloConsultas.ModuloConsultas;
import br.com.moduloRelatorios.ModuloRelatorios;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;

        while(continuar){
            System.out.println("\n============/SELECIONE O MÓDULO");
            System.out.println("[1]-Módulo Cadastro");
            System.out.println("[2]-Módulo Consultas");
            System.out.println("[3]-Módulo Relatórios");
            System.out.println("[4]-Sair");
            System.out.print("-->");
            int op = scanner.nextInt();

            switch(op){
                case 1 ->{
                    ModuloCadastro moduloCadastro = new ModuloCadastro();
                    moduloCadastro.iniciarModuloCadastro();
                }

                case 2 ->{
                    ModuloConsultas moduloConsultas = new ModuloConsultas();
                    moduloConsultas.iniciarModuloConsultas();
                }

                case 3 ->{
                    ModuloRelatorios moduloRelatorios = new ModuloRelatorios();
                    moduloRelatorios.iniciarRelatorio();
                }

                case 4 ->{
                    System.exit(0);
                }

                default -> {
                    System.out.println("Opção invalida!");
                }
            }
        }

    }
}