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

public class Atualizar {
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

    public void atualizarAtividadeprincipal(){
        System.out.print("\nInforme o id da Atividade que deseja alterar: ");
        int idAtividadePrincipal = scanner.nextInt();
        scanner.nextLine();
        atividadePrincipal = atividadePrincipalService.buscarAtividadePrinciaplPorId(idAtividadePrincipal);

        if(atividadePrincipal != null){
            System.out.print("Informe o nome do atividade: ");
            atividadePrincipal.setNomeAtividade(scanner.nextLine());
            System.out.print("Informe a descrição da atividade:  ");
            atividadePrincipal.setDescricaoAtividade(scanner.nextLine());

            atividadePrincipalService.atualizarAtividadePrincipal(atividadePrincipal);

            System.out.println("\nAtividade principal alterada com sucesso!\n");
        } else {
            System.out.println("Atividade não encontrada.\n");
        }
    }

    public void atualizarCidade(){
        System.out.print("\nInforme o id da Cidade que deseja atualizar o registro: ");
        int idCidade = scanner.nextInt();
        scanner.nextLine();
        cidade = cidadeService.buscarCidadePorId(idCidade);

        if(cidade != null){
            System.out.print("Informe o nome da cidade: ");
            cidade.setNomeCidade(scanner.nextLine());
            System.out.print("Informe a unidade federativa:  ");
            cidade.setNomeCidade(scanner.nextLine());
            System.out.print("Informe a estimação atualizada: ");
            cidade.setPopulacao(scanner.nextInt());

            cidadeService.atualizarCidade(cidade);

            System.out.println("\nCidade atualizada com sucesso!\n");
        }else {
            System.out.println("\nCidade não encontrada.\n");
        }
    }

    public void atualizarRuaLinha(){
        boolean possuiAsfaltamento;

        System.out.print("\nInforme o id da Rua - Linha que deseja alterar: ");
        int idRuaLinha = scanner.nextInt();
        scanner.nextLine();
        ruaLinha = ruaLinhaService.buscarRuaLinhaPorNome(idRuaLinha);

        if(ruaLinha != null){
            System.out.print("Informe o nome da Rua - Linha: ");
            ruaLinha.setNomeRua(scanner.nextLine());
            System.out.print("Informe o cep:  ");
            ruaLinha.setCepRua(scanner.nextLine());
            System.out.print("Informe a extensão da Rua - Linha:  ");
            ruaLinha.setExtensao(scanner.nextFloat());

            System.out.print("Informe se a rua possui asfaltamento \n[1]-Sim\n[2]-Nao\n-->");
            int asfaltamento = scanner.nextInt();
            if(asfaltamento == 1){
                possuiAsfaltamento = true;
            } else if(asfaltamento == 2){
                possuiAsfaltamento = false;
            } else {
                possuiAsfaltamento = false;
            }
            ruaLinha.setPossuiAsfaltamento(possuiAsfaltamento);

            System.out.print("Informe a criticidade de locomoção: ");
            ruaLinha.setCriticidadeLocomocao(scanner.nextLine());
            System.out.print("Informe o tipo do logradouro: ");
            ruaLinha.setTipoLogradouro(scanner.nextLine());

            System.out.println("Informe o id da localidade da Rua Linha: ");
            int idLocalidade = scanner.nextInt();
            localidade = localidadeService.buscarLocalidadePorId(idLocalidade);
            ruaLinha.setLocalidade(localidade);

            ruaLinhaService.atualizarRuaLinha(ruaLinha);

            System.out.println("\nRua - Linha alterada com sucesso!\n");
        } else {
            System.out.println("\nRua - linha não encontrada.\n");
        }
    }

    public void atualizarLocalidade(){
        Tipo_Localidade tipoLocalidade = null;

        System.out.print("\nInforme o id Localidade que deseja alterar: ");
        int idLocalidade = scanner.nextInt();
        scanner.nextLine();
        localidade = localidadeService.buscarLocalidadePorId(idLocalidade);

        if(localidade != null){
            System.out.print("Informe o nome da Rua - Linha: ");
            localidade.setNomeLocalidade(scanner.nextLine());
            System.out.print("Informe o cep:  ");
            localidade.setCep(scanner.nextLine());

            System.out.print("Informe o tipo da localidade \n[1]-Urbana\n[2]-Rural\n-->");
            int localidadeTipo = scanner.nextInt();
            if(localidadeTipo == 1){
                tipoLocalidade = Tipo_Localidade.URBANA;
            } else if(localidadeTipo == 2){
                tipoLocalidade = Tipo_Localidade.RURAL;
            }
            localidade.setTipoLocalidade(tipoLocalidade);

            if (scanner.hasNextLine()) scanner.nextLine();
            System.out.print("Informe a populacao estimada da localidade: ");
            localidade.setPopulacaoEstimada(scanner.nextInt());
            System.out.print("Informe a area estimada da localidade: ");
            localidade.setAreaEstimada(scanner.nextFloat());

            System.out.print("Informe o id da Cidade em que se encontra a Localidade: ");
            int idCidade = scanner.nextInt();
            cidade = cidadeService.buscarCidadePorId(idCidade);
            localidade.setCidade(cidade);

            System.out.print("Informe o id da Atividade Principal da Localidade: ");
            int idAtividadePrincipal = scanner.nextInt();
            atividadePrincipalService.buscarAtividadePrinciaplPorId(idAtividadePrincipal);
            localidade.setAtividadePrincipal(atividadePrincipal);

            localidadeService.atualizarLocalidade(localidade);

            System.out.println("\nLocalidade atualizada com sucesso!\n");
        }else {
            System.out.println("\nLocalidade não encontrada.\n");
        }
    }

    public void atualizarUnidadeConsumidora(){
        boolean status;

        System.out.print("\nInforme o id Unidade Consumidora que deseja alterar: ");
        int idUnidade = scanner.nextInt();
        scanner.nextLine();
        unidadeConsumidora = unidadeConsumidoraService.buscarUnidadeConsumidoraPorId(idUnidade);

        if(unidadeConsumidora != null){
            System.out.print("Informe o nome do responsável pela unidade consumidora: ");
            unidadeConsumidora.setNomeResponsavel(scanner.nextLine());
            System.out.print("Informe o cpf do responsável pela unidade consumidora: ");
            unidadeConsumidora.setCpfResponsavel(scanner.nextLine());
            System.out.print("Informe a quantidade de pessoas residentes na unidade consumidora:");
            unidadeConsumidora.setQntPessoas(scanner.nextInt());

            System.out.print("Informe o status da unidade consumidora \n[1]-Ativa\n[2]-Inativa\n-->");
            int statusUnidade = scanner.nextInt();
            if(statusUnidade == 1){
                status = true;
            } else if(statusUnidade == 2){
                status = false;
            } else {
                status = true;
            }
            unidadeConsumidora.setStatus(status);

            if (scanner.hasNextLine()) scanner.nextLine();
            if (scanner.hasNextLine()) scanner.nextLine();
            System.out.print("Informe o contato (telefone ou Email) da unidade consumidora: ");
            unidadeConsumidora.setContato(scanner.nextLine());

            System.out.print("Informe o id da Rua - Linha em que a unidade consumidora se localiza: ");
            int idRua = scanner.nextInt();
            ruaLinha = ruaLinhaService.buscarRuaLinhaPorNome(idRua);
            unidadeConsumidora.setRuaLinha(ruaLinha);

            unidadeConsumidoraService.atualizarUnidadeConsumidora(unidadeConsumidora);

            System.out.println("\nUnidade Consumidora atualizada com sucesso!\n");
        } else  {
            System.out.println("\nUnidade Consumidora não encontrada.");
        }
    }

    public void atualizarUnidadeDistribuidora(){
        boolean status;
        LocalDate dataInicio = null;
        Tipo_Distribuicao tipoDistribuicao = null;

        System.out.print("\nInforme o id Unidade Distribuidora que deseja alterar: ");
        int idUnidade  = scanner.nextInt();
        scanner.nextLine();
        unidadeDistribuidora = unidadeDistribuidoraService.buscarUnidadeDistribuidoraPorId(idUnidade);

        if(unidadeDistribuidora != null){
            System.out.print("Informe o nome da unidade distribuidora: ");
            unidadeDistribuidora.setNomeUnidade(scanner.nextLine());
            System.out.print("Descrição: ");
            unidadeDistribuidora.setDescricaoUnidade(scanner.nextLine());
            System.out.print("Informe a localização geografica da unidade: ");
            unidadeDistribuidora.setLocalizacaoUnidade(scanner.nextLine());

            System.out.print("Informe o status da unidade distribuidora \n[1]-Ativa\n[2]-Inativa\n-->");
            int statusUnidade = scanner.nextInt();
            if(statusUnidade == 1){
                status = true;
            } else if(statusUnidade == 2){
                status = false;
            } else {
                status = false;
            }
            unidadeDistribuidora.setStatus(status);

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
            unidadeDistribuidora.setDataAtivacao(dataInicio);

            System.out.print("\nInforme o responsavel tecnico da unidade distribuidora: ");
            unidadeDistribuidora.setResponsavelTecnico(scanner.nextLine());

            System.out.print("Informe o tipo da unidade distribuidora \n[1]-Agua\n[2]-Luz\n-->");
            int unidadeTipo = scanner.nextInt();
            if(unidadeTipo == 1){
                tipoDistribuicao = Tipo_Distribuicao.AGUA;
            } else if(unidadeTipo == 2){
                tipoDistribuicao = Tipo_Distribuicao.LUZ;
            }
            unidadeDistribuidora.setTipoDistribuicao(tipoDistribuicao);

            if (scanner.hasNextLine()) scanner.nextLine();
            System.out.print("Informe a capacidade maxima de distribuição em MVA: ");
            unidadeDistribuidora.setCapacidadeOperacionalMaxima(scanner.nextFloat());

            unidadeDistribuidoraService.atualizarUnidadeDistribuidora(unidadeDistribuidora);

            System.out.println("\nUnidade Distribuidora atualizada com sucesso!\n");
        } else{
            System.out.println("\nUnidade Distribuidora não encontrada.\n");
        }
    }

    public void atualizarUnidadeTratamento(){
        boolean status;
        LocalDate dataInicio = null;
        Tipo_Tratamento tipoTratamento = null;

        System.out.print("\nInforme o id Unidade de Tratamento que deseja alterar: ");
        int idUnidade  = scanner.nextInt();
        scanner.nextLine();
        unidadeTratamento = unidadeTratamentoService.buscarUnidadeTratamentoPorId(idUnidade);

        if(unidadeTratamento != null){
            System.out.print("Informe o nome da unidade de tratamento: ");
            unidadeTratamento.setNomeUnidade(scanner.nextLine());
            System.out.print("Descrição: ");
            unidadeTratamento.setDescricaoUnidade(scanner.nextLine());
            System.out.print("Informe a localização geografica da unidade: ");
            unidadeTratamento.setLocalizacaoUnidade(scanner.nextLine());

            System.out.print("Informe o status da unidade de tratamento \n[1]-Ativa\n[2]-Inativa\n-->");
            int statusUnidade = scanner.nextInt();
            if(statusUnidade == 1){
                status = true;
            } else if(statusUnidade == 2){
                status = false;
            } else {
                status = false;
            }
            unidadeTratamento.setStatus(status);

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
            unidadeTratamento.setDataAtivacao(dataInicio);

            System.out.print("\nInforme o responsavel tecnico da unidade distribuidora: ");
            unidadeTratamento.setResponsavelTecnico(scanner.nextLine());

            System.out.print("Informe o tipo da unidade distribuidora \n[1]-Agua\n[2]-Esgoto\n[3]Lixo\n-->");
            int unidadeTipo = scanner.nextInt();
            if(unidadeTipo == 1){
                tipoTratamento = Tipo_Tratamento.AGUA;
            } else if(unidadeTipo == 2){
                tipoTratamento = Tipo_Tratamento.ESGOTO;
            } else if(unidadeTipo == 3){
                tipoTratamento = Tipo_Tratamento.LIXO;
            }
            unidadeTratamento.setTipoTratamento(tipoTratamento);

            if (scanner.hasNextLine()) scanner.nextLine();
            System.out.print("Informe a capacidade maxima de tratamento em um dia: ");
            unidadeTratamento.setCapacidadeTratamento(scanner.nextFloat());
            System.out.print("Informe o nivel de eficiencia em porcentagem (não é necessário o formatador '%'): ");
            unidadeTratamento.setNivelEficiencia(scanner.nextFloat());

            unidadeTratamentoService.atualizarUnidadeTratamento(unidadeTratamento);

            System.out.println("\nUnidade Tratamento atualizada com sucesso!\n");
        } else {
            System.out.println("\nUnidade de Tratamento não encontrada.\n");
        }
    }

    public void atualizarConexaoDeUnidadeConsumidoraDistribuidora(){
        LocalDate dataConexao = null;

        System.out.print("\nInforme o id da conexão entre Unidade Consumidora e Unidade Distribuidora que deseja alterar: ");
        int idConexao  = scanner.nextInt();
        scanner.nextLine();
        conexaoUnidadeConsumidoraDistribuidora = conexaoUnidadeConsumidoraDistribuidoraService.buscarConexaoUnidadeConsumidoraDistribuidoraPorId(idConexao);

        if(conexaoUnidadeConsumidoraDistribuidora != null){
            System.out.print("Informe o id da unidade distribuidora: ");
            int idUnidade = scanner.nextInt();
            unidadeDistribuidora = unidadeDistribuidoraService.buscarUnidadeDistribuidoraPorId(idUnidade);
            conexaoUnidadeConsumidoraDistribuidora.setUnidadeDistribuidora(unidadeDistribuidora);

            System.out.print("Informe o id da unidade consumidora: ");
            int idConsumidora = scanner.nextInt();
            unidadeConsumidora = unidadeConsumidoraService.buscarUnidadeConsumidoraPorId(idConsumidora);
            conexaoUnidadeConsumidoraDistribuidora.setIdUnidadeConsumidora(unidadeConsumidora);

            if (scanner.hasNextLine()) scanner.nextLine();
            while (dataConexao == null) {
                System.out.print("Informe a data da conexão (aaaa-mm-dd): ");
                String data = scanner.nextLine();
                try {
                    dataConexao = LocalDate.parse(data);
                } catch (DateTimeParseException e) {
                    System.out.println("Data inválida. Tente novamente no formato aaaa-mm-dd.");
                }
            }
            System.out.print("Data registrada: " + dataConexao);
            conexaoUnidadeConsumidoraDistribuidora.setDataConexao(dataConexao);

            conexaoUnidadeConsumidoraDistribuidoraService.atualizarConexaoUnidadeConsumidoraDistribuidora(conexaoUnidadeConsumidoraDistribuidora);

            System.out.println("\nConexão atualizada com sucesso!\n");
        } else{
            System.out.println("\nConexão não encontrada.\n");
        }
    }

    public void atualizarConexaoDeUnidadeConsumidoraTratamento(){
        LocalDate dataConexao = null;

        System.out.print("\nInforme o id da conexão entre Unidade Consumidora e Unidade de Tratamento que deseja alterar: ");
        int idConexao  = scanner.nextInt();
        scanner.nextLine();
        conexaoUnidadeConsumidoraTratamento = conexaoUnidadeConsumidoraTratamentoService.buscarConexaoUnidadeConsumidoraTratamentoPorId(idConexao);

        if(conexaoUnidadeConsumidoraTratamento !=null){
            System.out.print("Informe o id da unidade de tratamento: ");
            int idUnidade = scanner.nextInt();
            unidadeTratamentoService.buscarUnidadeTratamentoPorId(idUnidade);
            conexaoUnidadeConsumidoraTratamento.setUnidadeTratamento(unidadeTratamento);

            System.out.print("Informe o id da unidade consumidora: ");
            int idConsumidora = scanner.nextInt();
            unidadeConsumidora = unidadeConsumidoraService.buscarUnidadeConsumidoraPorId(idConsumidora);
            conexaoUnidadeConsumidoraTratamento.setIdUnidadeConsumidora(unidadeConsumidora);

            while (dataConexao == null) {
                System.out.print("Informe a data da conexão (aaaa-mm-dd): ");
                String data = scanner.nextLine();
                try {
                    dataConexao = LocalDate.parse(data);
                } catch (DateTimeParseException e) {
                    System.out.println("Data inválida. Tente novamente no formato aaaa-mm-dd.");
                }
            }
            System.out.print("Data registrada: " + dataConexao);
            conexaoUnidadeConsumidoraTratamento.setDataConexao(dataConexao);

            conexaoUnidadeConsumidoraTratamentoService.atualizarConexaoUnidadeConsumidoraTratamento(conexaoUnidadeConsumidoraTratamento);

            System.out.println("\nConexão atualizada com sucesso!\n");
        } else{
            System.out.println("\nConexão não encontrada.\n");
        }
    }

    public void atualizarRuaLinhaAtendidaPorColetaSeletiva(){
        LocalDate dataInicio = null;

        System.out.print("\nInforme o id do registro da Rua - Linha atendida por coleta seletiva que deseja alterar: ");
        int idColeta  = scanner.nextInt();
        scanner.nextLine();
        coletaSeletivaPorRuaLinha = coletaSeletivaPorRuaLinhaService.buscarColetaSeletivaPorRuaLinhaPorId(idColeta);

        if(coletaSeletivaPorRuaLinha !=null){
            System.out.print("Informe o id da unidade de tratamento: ");
            int idUnidade = scanner.nextInt();
            unidadeTratamentoService.buscarUnidadeTratamentoPorId(idUnidade);
            coletaSeletivaPorRuaLinha.setUnidadeTratamento(unidadeTratamento);

            System.out.print("Informe o id da Rua - Linha em que a unidade consumidora se localiza: ");
            int idRua = scanner.nextInt();
            ruaLinha = ruaLinhaService.buscarRuaLinhaPorNome(idRua);
            coletaSeletivaPorRuaLinha.setRuaLinha(ruaLinha);

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
            coletaSeletivaPorRuaLinha.setInicioColeta(dataInicio);

            System.out.print("\nInforme os dias da coleta: ");
            coletaSeletivaPorRuaLinha.setDiasColeta(scanner.nextLine());

            coletaSeletivaPorRuaLinhaService.atualizarColetaSeletivaPorRuaLinhaService(coletaSeletivaPorRuaLinha);

            System.out.println("\nRegistro atualizado com sucesso!\n");
        } else{
            System.out.println("\nRegistro não encontrado.\n");
        }
    }

    public void atualizarManutencaoUnidadeDistribuidora(){
        LocalDate dataManutencao = null;

        System.out.print("\nInforme o id do registro da manutenção em Unidade Distribuidora que deseja alterar: ");
        int idManutencao  = scanner.nextInt();
        scanner.nextLine();
        manutencaoUnidadeDistribuidora = manutencaoUnidadeDistribuidoraService.buscarManutencaoUnidadeDistribuidoraPorId(idManutencao);

        if(manutencaoUnidadeDistribuidora !=null){
            System.out.print("Informe o que foi realizada na manutenção da unidade distribuidora: ");
            manutencaoUnidadeDistribuidora.setDescricaoManutencao(scanner.nextLine());

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
            manutencaoUnidadeDistribuidora.setDataManutencaoUnidadadeDistribuidora(dataManutencao);

            System.out.print("\nInforme o id da unidade de distribuição, cujo a manutenção foi realizada: ");
            int idDistribuidora = scanner.nextInt();
            unidadeDistribuidora = unidadeDistribuidoraService.buscarUnidadeDistribuidoraPorId(idDistribuidora);
            manutencaoUnidadeDistribuidora.setUnidade_distribuidora(unidadeDistribuidora);

            manutencaoUnidadeDistribuidoraService.atualizarManutencaoUnidadeDistribuidora(manutencaoUnidadeDistribuidora);

            System.out.println("\nRegistro atualizado com sucesso!\n");
        } else{
            System.out.println("\nRegistro não encontrado.\n");
        }
    }

    public void atualizarManutencaoUnidadeTratamento(){
        LocalDate dataManutencao = null;

        System.out.print("\nInforme o id do registro da manutenção em Unidade Distribuidora que deseja alterar: ");
        int idManutencao  = scanner.nextInt();
        scanner.nextLine();
        manutencaoUnidadeTratamento = manutencaoUnidadeTratamentoService.buscarManutencaoUnidadeTratamentoPorId(idManutencao);

        if(manutencaoUnidadeTratamento !=null){
            System.out.print("Informe o que foi realizada na manutenção da unidade de tratamento: ");
            manutencaoUnidadeTratamento.setDescricaoManutencao(scanner.nextLine());

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
            manutencaoUnidadeTratamento.setDataManutencaoUnidadadeTratamento(dataManutencao);

            System.out.print("\nInforme o id da unidade de tratamento, cujo a manutenção foi realizada: ");
            int idTratamento = scanner.nextInt();
            unidadeTratamento = unidadeTratamentoService.buscarUnidadeTratamentoPorId(idTratamento);
            manutencaoUnidadeTratamento.setUnidade_tratamento(unidadeTratamento);

            manutencaoUnidadeTratamentoService.atualizarManutencaoUnidadeTratamento(manutencaoUnidadeTratamento);

            System.out.println("\nRegistro atualizado com sucesso!\n");
        } else{
            System.out.println("\nRegistro não encontrado.\n");
        }
    }
}

