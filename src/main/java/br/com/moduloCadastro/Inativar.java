package br.com.moduloCadastro;

import br.com.model.Cidade;
import br.com.model.UnidadeConsumidora;
import br.com.model.UnidadeDistribuidora;
import br.com.model.UnidadeTratamento;
import br.com.service.CidadeService;
import br.com.service.UnidadeConsumidoraService;
import br.com.service.UnidadeDistribuidoraService;
import br.com.service.UnidadeTratamentoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Scanner;

public class Inativar {
    private static final Scanner scanner = new Scanner(System.in);
    private static EntityManager em;

    static {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PostgresPU");
        em = emf.createEntityManager();
    }

    Cidade cidade;
    CidadeService cidadeService = new CidadeService(em);

    UnidadeConsumidora unidadeConsumidora;
    UnidadeConsumidoraService unidadeConsumidoraService = new UnidadeConsumidoraService(em);

    UnidadeDistribuidora unidadeDistribuidora;
    UnidadeDistribuidoraService unidadeDistribuidoraService = new UnidadeDistribuidoraService(em);

    UnidadeTratamento unidadeTratamento;
    UnidadeTratamentoService unidadeTratamentoService = new UnidadeTratamentoService(em);


    public void removerCidade(){
        cidade = new Cidade("Cidade Teste", "PR", 500000);
        cidadeService = new CidadeService(em);
        cidadeService.cadastrarCidade(cidade);

        System.out.println("\nId da cidade cadastrada: " + cidade.getId());

        Cidade cidade2;
        System.out.print("Informe o id da cidade cujo deseja remover registro: ");
        int id = scanner.nextInt();
        cidade2 = cidadeService.buscarCidadePorId(id);
        cidadeService.removerCidade(cidade2);

        System.out.println("Cidade removida com sucesso!");
    }

    public void inativarUnidadeConsumidora(){
        System.out.print("\nInforme o id da Unidade Consumidora, cujo deseja inativar: ");
        int id = scanner.nextInt();
        unidadeConsumidora = unidadeConsumidoraService.buscarUnidadeConsumidoraPorId(id);

        if(unidadeConsumidora != null && unidadeConsumidora.isStatus() == true){
            unidadeConsumidora.setStatus(false);
            unidadeConsumidoraService.atualizarUnidadeConsumidora(unidadeConsumidora);

            System.out.println("Unidade Consumidora Inativada com sucesso!");

        } else if (unidadeConsumidora != null && unidadeConsumidora.isStatus() != true) {
            System.out.println("A Unidade Consumidora já se encontra inativa.");

        } else{
            System.out.println("Unidade Consumidora não encontrada!");
        }
    }

    public void inativarUnidadeDistribuidora(){
        System.out.print("\nInforme o id da Unidade Distribuidora, cujo deseja inativar: ");
        int id = scanner.nextInt();
        unidadeDistribuidora = unidadeDistribuidoraService.buscarUnidadeDistribuidoraPorId(id);

        if(unidadeDistribuidora != null && unidadeDistribuidora.getStatus() == true){
            unidadeDistribuidora.setStatus(false);
            unidadeDistribuidoraService.atualizarUnidadeDistribuidora(unidadeDistribuidora);

            System.out.println("Unidade Distribuidora Inativada com sucesso!");

        } else if (unidadeDistribuidora != null && unidadeDistribuidora.getStatus() != true) {
            System.out.println("A Unidade Distribuidora já se encontra inativa.");

        } else{
            System.out.println("Unidade Distribuidora não encontrada!");
        }
    }

    public void inativarUnidadeDeTratamento(){
        System.out.print("\nInforme o id da Unidade de Tratamento, cujo deseja inativar: ");
        int id = scanner.nextInt();
        unidadeTratamento = unidadeTratamentoService.buscarUnidadeTratamentoPorId(id);

        if(unidadeTratamento != null && unidadeTratamento.getStatus() == true){
            unidadeTratamento.setStatus(false);
            unidadeTratamentoService.atualizarUnidadeTratamento(unidadeTratamento);

            System.out.println("Unidade de Tratamento Inativada com sucesso!");

        } else if (unidadeTratamento != null && unidadeTratamento.getStatus() != true) {
            System.out.println("A Unidade de Tratamento já se encontra inativa.");

        } else{
            System.out.println("Unidade de Tratamento não encontrada!");
        }
    }
}
