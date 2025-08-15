package br.com.dao;

import br.com.exceptions.DataException;
import br.com.model.UnidadeDistribuidora;
import br.com.relatorios.EmitirComunicadoDesligamentoDeAgua;
import br.com.relatorios.PessoasAtendidasPorUnidadeDistribuidoraLuz;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UnidadeDistribuidoraDao extends GenericDao<UnidadeDistribuidora> {

    public UnidadeDistribuidoraDao(EntityManager em) {
        super(em, UnidadeDistribuidora.class);
    }

    public List<PessoasAtendidasPorUnidadeDistribuidoraLuz> pessoasAtendidasPorUnidadeDistribuidoraLuz() {
        try{
            String jpql = "SELECT new br.com.relatorios.PessoasAtendidasPorUnidadeDistribuidoraLuz(" +
                    "und.nomeUnidade, " +
                    "und.localizacaoUnidade, " +
                    "und.capacidadeOperacionalMaxima, " +
                    "SUM(unc.qntPessoas)) " +
                    "FROM ConexaoUnidadeConsumidoraDistribuidora cuncd " +
                    "JOIN cuncd.unidadeConsumidora unc " +
                    "JOIN cuncd.unidadeDistribuidora und " +
                    "WHERE und.tipoDistribuicao = 'LUZ' " +
                    "GROUP BY und.nomeUnidade, und.localizacaoUnidade, und.capacidadeOperacionalMaxima " +
                    "ORDER BY SUM(unc.qntPessoas) DESC";
            return em.createQuery(jpql, PessoasAtendidasPorUnidadeDistribuidoraLuz.class)
                    .getResultList();
        }catch(Exception e) {
            throw new DataException("Erro ao gerar relatório de pessoas atendidas da unidade distribuidora.", e);
        }

    }

    public List<EmitirComunicadoDesligamentoDeAgua> listarContatosParaEmissaoDeComunicadoDeDesligamentoDeAgua(String nomeUnidade) {
            try {
                String jpql = "SELECT new br.com.relatorios.EmitirComunicadoDesligamentoDeAgua( " +
                        "unc.nomeResponsavel, " +
                        "unc.contato ) " +
                        "FROM ConexaoUnidadeConsumidoraDistribuidora cuncd " +
                        "JOIN cuncd.unidadeDistribuidora und " +
                        "JOIN cuncd.unidadeConsumidora unc " +
                        "WHERE und.nomeUnidade = :nomeUnidade AND und.tipoDistribuicao = 'AGUA'";

                return em.createQuery(jpql, EmitirComunicadoDesligamentoDeAgua.class)
                        .setParameter("nomeUnidade", nomeUnidade)
                        .getResultList();
            }catch(Exception e) {
                throw new DataException("Erro ao gerar relação dos contatos para notificação de desligamento do fornecimento de água.", e);
            }
    }

    public void converterListaDeContatosParaEmissaoDeComunicadoDeDesligamentoDeAguaEmArquivoJson(String nomeArquivoJson, List<EmitirComunicadoDesligamentoDeAgua> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(nomeArquivoJson), lista);

            System.out.println("Arquivo JSON gerado com sucesso: " + nomeArquivoJson);
        } catch (IOException e) {
            throw new DataException("Erro ao converter a lista para arquivo JSON: " + nomeArquivoJson, e);
        }
    }

}
