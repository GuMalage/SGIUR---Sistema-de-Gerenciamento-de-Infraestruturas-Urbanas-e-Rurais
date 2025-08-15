package br.com.dao;

import br.com.model.AtividadePrincipal;
import jakarta.persistence.EntityManager;

public class AtividadePrincipalDao extends GenericDao<AtividadePrincipal> {

    public AtividadePrincipalDao(EntityManager em) {
        super(em, AtividadePrincipal.class);
    }
}
