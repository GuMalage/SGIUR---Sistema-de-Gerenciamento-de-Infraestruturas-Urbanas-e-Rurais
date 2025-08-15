package br.com.dao;

import br.com.exceptions.DataException;
import br.com.model.UnidadeConsumidora;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

public class UnidadeConsumidoraDao extends GenericDao<UnidadeConsumidora> {

    public UnidadeConsumidoraDao(EntityManager em) {
        super(em, UnidadeConsumidora.class);
    }

    public UnidadeConsumidora buscarUnidadeConsumidoraPorCpfResponsavel(String cpf) {
        try {
            String jpql = "SELECT e FROM UnidadeConsumidora e WHERE e.cpfResponsavel = :cpf";
            return em.createQuery(jpql, UnidadeConsumidora.class)
                    .setParameter("cpf", cpf)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new DataException("Erro ao buscar por CPF do responsável na entidade: UnidadeConsumidora", e);
        }
    }

}
