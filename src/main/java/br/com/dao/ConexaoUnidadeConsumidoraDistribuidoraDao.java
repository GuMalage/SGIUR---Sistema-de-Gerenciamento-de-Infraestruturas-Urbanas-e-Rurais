package br.com.dao;

import br.com.model.ConexaoUnidadeConsumidoraDistribuidora;
import jakarta.persistence.EntityManager;

public class ConexaoUnidadeConsumidoraDistribuidoraDao extends GenericDao<ConexaoUnidadeConsumidoraDistribuidora> {

    public ConexaoUnidadeConsumidoraDistribuidoraDao(EntityManager em) {
        super(em, ConexaoUnidadeConsumidoraDistribuidora.class);
    }
}
