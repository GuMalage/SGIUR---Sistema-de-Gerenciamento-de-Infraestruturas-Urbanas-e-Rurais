package br.com.dao;

import br.com.model.ManutencaoUnidadeDistribuidora;
import jakarta.persistence.EntityManager;

public class ManutencaoUnidadeDistribuidoraDao extends GenericDao<ManutencaoUnidadeDistribuidora> {

    public ManutencaoUnidadeDistribuidoraDao(EntityManager em) {
        super(em, ManutencaoUnidadeDistribuidora.class);
    }
}
