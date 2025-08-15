package br.com.dao;

import br.com.model.ColetaSeletivaPorRuaLinha;
import jakarta.persistence.EntityManager;

public class ColetaSeletivaPorRuaLinhaDao extends GenericDao<ColetaSeletivaPorRuaLinha> {
    public ColetaSeletivaPorRuaLinhaDao(EntityManager em) {
        super(em, ColetaSeletivaPorRuaLinha.class);
    }
}
