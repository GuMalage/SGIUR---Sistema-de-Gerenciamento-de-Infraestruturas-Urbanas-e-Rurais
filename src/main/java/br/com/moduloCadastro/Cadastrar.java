package br.com.moduloCadastro;

import br.com.enums.Tipo_Distribuicao;
import br.com.enums.Tipo_Localidade;
import br.com.enums.Tipo_Tratamento;
import br.com.model.*;
import br.com.service.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Cadastrar {
    private static final Scanner scanner = new Scanner(System.in);
    private static EntityManager em;

    static {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PostgresPU");
        em = emf.createEntityManager();
    }

    AtividadePrincipal atividadePrincipal = new AtividadePrincipal();
    AtividadePrincipalService atividadePrincipalService = new AtividadePrincipalService(em);

    Cidade cidade;
    CidadeService cidadeService = new CidadeService(em);

    Localidade localidade;
    LocalidadeService localidadeService = new LocalidadeService(em);

    RuaLinha ruaLinha;
    RuaLinhaService ruaLinhaService = new RuaLinhaService(em);

    UnidadeConsumidora unidadeConsumidora;
    UnidadeConsumidoraService unidadeConsumidoraService = new UnidadeConsumidoraService(em);

    UnidadeDistribuidora unidadeDistribuidora;
    UnidadeDistribuidoraService unidadeDistribuidoraService = new UnidadeDistribuidoraService(em);

    UnidadeTratamento unidadeTratamento;
    UnidadeTratamentoService unidadeTratamentoService = new UnidadeTratamentoService(em);

    ConexaoUnidadeConsumidoraDistribuidora conexaoUnidadeConsumidoraDistribuidora;
    ConexaoUnidadeConsumidoraDistribuidoraService conexaoUnidadeConsumidoraDistribuidoraService = new ConexaoUnidadeConsumidoraDistribuidoraService(em);

    ConexaoUnidadeConsumidoraTratamento conexaoUnidadeConsumidoraTratamento;
    ConexaoUnidadeConsumidoraTratamentoService conexaoUnidadeConsumidoraTratamentoService = new ConexaoUnidadeConsumidoraTratamentoService(em);

    ColetaSeletivaPorRuaLinha coletaSeletivaPorRuaLinha;
    ColetaSeletivaPorRuaLinhaService coletaSeletivaPorRuaLinhaService = new ColetaSeletivaPorRuaLinhaService(em);

    ManutencaoUnidadeDistribuidora manutencaoUnidadeDistribuidora;
    ManutencaoUnidadeDistribuidoraService manutencaoUnidadeDistribuidoraService = new ManutencaoUnidadeDistribuidoraService(em);

    ManutencaoUnidadeTratamento manutencaoUnidadeTratamento;
    ManutencaoUnidadeTratamentoService manutencaoUnidadeTratamentoService = new ManutencaoUnidadeTratamentoService(em);


    public void cadastrarAtividadeprincipal(){
        System.out.print("\nInforme o nome do atividade: ");
        String nomeAtividade = scanner.nextLine();
        System.out.print("Informe a descrição da atividade:  ");
        String descricaoAtividade = scanner.nextLine();

        AtividadePrincipal atividadePrincipal = new AtividadePrincipal(nomeAtividade, descricaoAtividade);
        atividadePrincipalService.cadastrarAtividadePrincipal(atividadePrincipal);

        System.out.println("\nAtividade cadastrada com sucesso!\n");

    }

    public void cadastrarCidade(){
        System.out.print("\nInforme o nome da cidade: ");
        String nomeCidade = scanner.nextLine();
        System.out.print("Informe a unidade federativa: ");
        String uf = scanner.nextLine();
        System.out.print("Informe a populacao estimada da cidade: ");
        int populacaoEstimada = scanner.nextInt();

        cidade = new Cidade(nomeCidade, uf, populacaoEstimada);
        cidadeService.cadastrarCidade(cidade);

        System.out.println("\nCidade cadastrada com sucesso!\n");
    }

    public void cadastrarRuaLinha(){
        boolean possuiAsfaltamento;

        System.out.print("\nInforme o nome da Rua - Linha: ");
        String nomeRuaLinha = scanner.nextLine();
        System.out.print("Informe o cep:  ");
        String cep = scanner.nextLine();
        System.out.print("Informe a extensão da Rua - Linha:  ");
        float extensao = scanner.nextFloat();

        System.out.print("Informe se a rua possui asfaltamento \n[1]-Sim\n[2]-Nao\n-->");
        int asfaltamento = scanner.nextInt();
        if(asfaltamento == 1){
            possuiAsfaltamento = true;
        } else if(asfaltamento == 2){
            possuiAsfaltamento = false;
        } else {
            possuiAsfaltamento = false;
        }

        if (scanner.hasNextLine()) scanner.nextLine();
        System.out.print("Informe a criticidade de locomoção: ");
        String criticidadeLocomocao = scanner.nextLine();
        System.out.print("Informe o tipo do logradouro: ");
        String tipoLogradouro = scanner.nextLine();

        System.out.print("Informe o id da localidade da Rua Linha: ");
        int idLocalidade = scanner.nextInt();
        localidade = localidadeService.buscarLocalidadePorId(idLocalidade);

        ruaLinha = new RuaLinha(nomeRuaLinha, cep, extensao, possuiAsfaltamento, criticidadeLocomocao, tipoLogradouro, localidade);
        ruaLinhaService.cadastrarRuaLinha(ruaLinha);

        System.out.println("\nRua - linha cadastrada com sucesso!\n");
    }

    public void cadastrarLocalidade(){
        Tipo_Localidade tipoLocalidade = null;

        System.out.print("\nInforme o nome da localidade: ");
        String nomeLocalidade = scanner.nextLine();
        System.out.print("Informe o cep:  ");
        String cep = scanner.nextLine();

        System.out.print("Informe o tipo da localidade \n[1]-Urbana\n[2]-Rural\n-->");
        int localidadeTipo = scanner.nextInt();
        if(localidadeTipo == 1){
            tipoLocalidade = Tipo_Localidade.URBANA;
        } else if(localidadeTipo == 2){
            tipoLocalidade = Tipo_Localidade.RURAL;
        }

        if (scanner.hasNextLine()) scanner.nextLine();
        System.out.print("Informe a populacao estimada da localidade: ");
        int populacaoEstimada = scanner.nextInt();
        System.out.print("Informe a area estimada da localidade: ");
        float areaEstimada = scanner.nextFloat();

        System.out.print("Informe o id da Cidade em que se encontra a Localidade: ");
        int idCidade = scanner.nextInt();
        cidade = cidadeService.buscarCidadePorId(idCidade);

        System.out.print("Informe o id da Atividade Principal da Localidade: ");
        int idAtividadePrincipal = scanner.nextInt();
        atividadePrincipal = atividadePrincipalService.buscarAtividadePrinciaplPorId(idAtividadePrincipal);

        localidade = new Localidade(nomeLocalidade, cep, tipoLocalidade, populacaoEstimada, areaEstimada, cidade, atividadePrincipal);
        localidadeService.cadastrarLocalidade(localidade);

        System.out.println("\nLocalidade cadastrada com sucesso!\n");

    }

    public void cadastrarUnidadeConsumidora(){
        boolean status;

        System.out.print("\nInforme o nome do responsável pela unidade consumidora: ");
        String nomeResponsavel = scanner.nextLine();
        System.out.print("Informe o cpf do responsável pela unidade consumidora: ");
        String cpf = scanner.nextLine();
        System.out.print("Informe a quantidade de pessoas residentes na unidade consumidora: ");
        int qtdPessoasResidentes = scanner.nextInt();

        System.out.print("Informe o status da unidade consumidora \n[1]-Ativa\n[2]-Inativa\n-->");
        int statusUnidade = scanner.nextInt();
        if(statusUnidade == 1){
            status = true;
        } else if(statusUnidade == 2){
            status = false;
        } else {
            status = true;
        }

        if (scanner.hasNextLine()) scanner.nextLine();
        System.out.print("Informe o contato (telefone ou Email) da unidade consumidora: ");
        String contato = scanner.nextLine();

        System.out.print("Informe o id da Rua - Linha em que a unidade consumidora se localiza: ");
        int idRua = scanner.nextInt();
        ruaLinha = ruaLinhaService.buscarRuaLinhaPorNome(idRua);

        unidadeConsumidora = new UnidadeConsumidora(nomeResponsavel, cpf, qtdPessoasResidentes, status, ruaLinha, contato);
        unidadeConsumidoraService.cadastrarUnidadeConsumidora(unidadeConsumidora);

        System.out.println("\nUnidade Consumidora cadastrada com sucesso!\n");
    }

    public void cadastrarUnidadeDistribuidora(){
        boolean status;
        LocalDate dataInicio = null;
        Tipo_Distribuicao tipoDistribuicao = null;

        System.out.print("\nInforme o nome da unidade distribuidora: ");
        String nomeUnidade = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Informe a localização geografica da unidade: ");
        String localizacaoGeografica = scanner.nextLine();

        System.out.print("Informe o status da unidade distribuidora \n[1]-Ativa\n[2]-Inativa\n-->");
        int statusUnidade = scanner.nextInt();
        if(statusUnidade == 1){
            status = true;
        } else if(statusUnidade == 2){
            status = false;
        } else {
            status = false;
        }

        if (scanner.hasNextLine()) scanner.nextLine();
        if (scanner.hasNextLine()) scanner.nextLine();
        while (dataInicio == null) {
            System.out.print("Informe a data do início das atividades da unidade (aaaa-mm-dd): ");
            String data = scanner.nextLine();
            try {
                dataInicio = LocalDate.parse(data);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente no formato aaaa-mm-dd.");
            }
        }
        System.out.print("Data registrada: " + dataInicio);
        System.out.print("\nInforme o responsavel tecnico da unidade distribuidora: ");
        String responsavelTecnico = scanner.nextLine();

        System.out.print("Informe o tipo da unidade distribuidora \n[1]-Agua\n[2]-Luz\n-->");
        int unidadeTipo = scanner.nextInt();
        if(unidadeTipo == 1){
             tipoDistribuicao = Tipo_Distribuicao.AGUA;
        } else if(unidadeTipo == 2){
            tipoDistribuicao = Tipo_Distribuicao.LUZ;
        }

        if (scanner.hasNextLine()) scanner.nextLine();
        System.out.print("Informe a capacidade maxima de distribuição em MVA: ");
        float capacidadeMaxima = scanner.nextFloat();

        unidadeDistribuidora = new UnidadeDistribuidora(nomeUnidade, descricao, localizacaoGeografica, status, dataInicio, responsavelTecnico, tipoDistribuicao, capacidadeMaxima);
        unidadeDistribuidoraService.cadastrarUnidadeDistribuidora(unidadeDistribuidora);

        System.out.println("\nUnidade Distribuidora cadastrada com sucesso!\n");
    }

    public void cadastrarUnidadeTratamento(){
        boolean status;
        LocalDate dataInicio = null;
        Tipo_Tratamento tipoTratamento = null;

        System.out.print("\nInforme o nome da unidade de tratamento: ");
        String nomeUnidade = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Informe a localização geografica da unidade: ");
        String localizacaoGeografica = scanner.nextLine();

        System.out.print("Informe o status da unidade de tratamento \n[1]-Ativa\n[2]-Inativa\n-->");
        int statusUnidade = scanner.nextInt();
        if(statusUnidade == 1){
            status = true;
        } else if(statusUnidade == 2){
            status = false;
        } else {
            status = false;
        }

        if (scanner.hasNextLine()) scanner.nextLine();
        if (scanner.hasNextLine()) scanner.nextLine();
        while (dataInicio == null) {
            scanner.nextLine();
            System.out.print("Informe a data do início das atividades da unidade (aaaa-mm-dd): ");
            String data = scanner.nextLine();
            try {
                dataInicio = LocalDate.parse(data);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente no formato aaaa-mm-dd.");
            }
        }
        System.out.print("Data registrada: " + dataInicio);

        System.out.print("\nInforme o responsavel tecnico da unidade de tratamento: ");
        String responsavelTecnico = scanner.nextLine();

        System.out.print("Informe o tipo da unidade distribuidora \n[1]-Agua\n[2]-Esgoto\n[3]-Lixo\n-->");
        int unidadeTipo = scanner.nextInt();
        if(unidadeTipo == 1){
            tipoTratamento = Tipo_Tratamento.AGUA;
        } else if(unidadeTipo == 2){
            tipoTratamento = Tipo_Tratamento.ESGOTO;
        } else if(unidadeTipo == 3){
            tipoTratamento = Tipo_Tratamento.LIXO;
        }

        System.out.print("Informe a capacidade maxima de tratamento em um dia: ");
        float capacidadeMaxima = scanner.nextFloat();
        System.out.print("Informe o nivel de eficiencia em porcentagem (não é necessário o formatador '%'): ");
        float nivelEficiencia = scanner.nextFloat();

        unidadeTratamento = new UnidadeTratamento(nomeUnidade, descricao, localizacaoGeografica, status, dataInicio, responsavelTecnico, tipoTratamento, capacidadeMaxima, nivelEficiencia);
        unidadeTratamentoService.cadastrarUnidadeTratamento(unidadeTratamento);

        System.out.println("\nUnidade de Tratamento cadastrada com sucesso!\n");
    }

    public void cadastrarConexaoDeUnidadeConsumidoraDistribuidora(){
        LocalDate dataConexao = null;

        System.out.print("\nInforme o id da unidade distribuidora: ");
        int idUnidade = scanner.nextInt();
        unidadeDistribuidora = unidadeDistribuidoraService.buscarUnidadeDistribuidoraPorId(idUnidade);

        System.out.print("Informe o id da unidade consumidora: ");
        int idConsumidora = scanner.nextInt();
        unidadeConsumidora = unidadeConsumidoraService.buscarUnidadeConsumidoraPorId(idConsumidora);

        while (dataConexao == null) {
            System.out.print("Informe a data da conexão (aaaa-mm-dd): ");
            String data = scanner.nextLine();
            try {
                dataConexao = LocalDate.parse(data);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente no formato aaaa-mm-dd.");
            }
        }
        System.out.print("Data registrada: " + dataConexao + "\n");

        conexaoUnidadeConsumidoraDistribuidora = new ConexaoUnidadeConsumidoraDistribuidora(unidadeDistribuidora, unidadeConsumidora, dataConexao);
        conexaoUnidadeConsumidoraDistribuidoraService.cadastrarConexaoUnidadeConsumidoraDistribuidora(conexaoUnidadeConsumidoraDistribuidora);

        System.out.println("\nConexão entre Unidade Consumidora e Unidade Distribuidora cadastrada com sucesso!\n");
    }

    public void cadastrarConexaoDeUnidadeConsumidoraTratamento(){
        LocalDate dataConexao = null;

        System.out.print("\nInforme o id da unidade de tratamento: ");
        int idUnidade = scanner.nextInt();
        unidadeTratamentoService.buscarUnidadeTratamentoPorId(idUnidade);

        System.out.print("Informe o id da unidade consumidora: ");
        int idConsumidora = scanner.nextInt();
        unidadeConsumidora = unidadeConsumidoraService.buscarUnidadeConsumidoraPorId(idConsumidora);

        while (dataConexao == null) {
            System.out.print("Informe a data da conexão (aaaa-mm-dd): ");
            String data = scanner.nextLine();
            try {
                dataConexao = LocalDate.parse(data);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente no formato aaaa-mm-dd.");
            }
        }
        System.out.print("Data registrada: " + dataConexao + "\n");

        conexaoUnidadeConsumidoraTratamento = new ConexaoUnidadeConsumidoraTratamento(unidadeTratamento, unidadeConsumidora, dataConexao);
        conexaoUnidadeConsumidoraTratamentoService.cadastrarConexaoUnidadeConsumidoraTratamento(conexaoUnidadeConsumidoraTratamento);

        System.out.println("\nConexão entre Unidade Consumidora e Unidade de Tratamento cadastrada com sucesso!\n");
    }


    public void cadastrarRuaLinhaAtendidaPorColetaSeletiva(){
        LocalDate dataInicio = null;

        System.out.print("\nInforme o id da unidade de tratamento: ");
        int idUnidade = scanner.nextInt();
        unidadeTratamentoService.buscarUnidadeTratamentoPorId(idUnidade);

        System.out.print("Informe o id da Rua - Linha em que a unidade consumidora se localiza: ");
        int idRua = scanner.nextInt();
        ruaLinha = ruaLinhaService.buscarRuaLinhaPorNome(idRua);

        while (dataInicio == null) {
            System.out.print("Informe a data do início da coleta (aaaa-mm-dd): ");
            String data = scanner.nextLine();
            try {
                dataInicio = LocalDate.parse(data);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente no formato aaaa-mm-dd.");
            }
        }
        System.out.print("Data registrada: " + dataInicio);

        System.out.print("\nInforme os dias da coleta: ");
        String diasColeta = scanner.nextLine();

        coletaSeletivaPorRuaLinha = new ColetaSeletivaPorRuaLinha(unidadeTratamento, ruaLinha, dataInicio, diasColeta);
        coletaSeletivaPorRuaLinhaService.cadastrarColetaSeletivaPorRuaLinhaService(coletaSeletivaPorRuaLinha);

        System.out.println("\nConexão entre Rua - Linha e Coleta Seletiva de Lixo cadastrada com sucesso!\n");

    }

    public void cadastarManutencaoUnidadeDistribuidora(){
        LocalDate dataManutencao = null;

        System.out.print("\nInforme o que foi realizada na manutenção da unidade distribuidora: ");
        String descricao = scanner.nextLine();

        while (dataManutencao == null) {
            System.out.print("Informe a data da manutenção (aaaa-mm-dd): ");
            String data = scanner.nextLine();
            try {
                dataManutencao = LocalDate.parse(data);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente no formato aaaa-mm-dd.");
            }
        }
        System.out.print("Data registrada: " + dataManutencao);

        System.out.print("\nInforme o id da unidade de distribuição, cujo a manutenção foi realizada: ");
        int idDistribuidora = scanner.nextInt();
        unidadeDistribuidora = unidadeDistribuidoraService.buscarUnidadeDistribuidoraPorId(idDistribuidora);

        manutencaoUnidadeDistribuidora = new ManutencaoUnidadeDistribuidora(descricao, dataManutencao, unidadeDistribuidora);
        manutencaoUnidadeDistribuidoraService.cadastrarManutencaoUnidadeDistribuidora(manutencaoUnidadeDistribuidora);

        System.out.println("\nManutenção de Unidade Distribuidora cadastrada com sucesso!\n");
    }

    public void cadastrarManutencaoUnidadeTratamento(){
        LocalDate dataManutencao = null;

        System.out.print("\nInforme o que foi realizada na manutenção da unidade de tratamento: ");
        String descricao = scanner.nextLine();

        while (dataManutencao == null) {
            System.out.print("Informe a data da manutenção (aaaa-mm-dd): ");
            String data = scanner.nextLine();
            try {
                dataManutencao = LocalDate.parse(data);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Tente novamente no formato aaaa-mm-dd.");
            }
        }
        System.out.print("Data registrada: " + dataManutencao);

        System.out.print("\nInforme o id da unidade de tratamento, cujo a manutenção foi realizada: ");
        int idTratamento = scanner.nextInt();
        unidadeTratamento = unidadeTratamentoService.buscarUnidadeTratamentoPorId(idTratamento);

        manutencaoUnidadeTratamento = new ManutencaoUnidadeTratamento(descricao, dataManutencao, unidadeTratamento);
        manutencaoUnidadeTratamentoService.cadastrarManutencaoUnidadeTratamento(manutencaoUnidadeTratamento);

        System.out.println("\nManutenção de Unidade de Tratamento cadastrada com sucesso!\n");
    }
}
