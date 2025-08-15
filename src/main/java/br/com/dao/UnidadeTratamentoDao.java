package br.com.dao;

import br.com.exceptions.DataException;
import br.com.model.UnidadeTratamento;
import br.com.relatorios.ManutencoesPorUnidadeDeTratamento;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UnidadeTratamentoDao extends GenericDao<UnidadeTratamento> {

    public UnidadeTratamentoDao(EntityManager em) {
        super(em, UnidadeTratamento.class);
    }

}
