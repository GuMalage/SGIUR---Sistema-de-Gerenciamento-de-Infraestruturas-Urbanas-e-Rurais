package br.com.dao;

import br.com.exceptions.DataException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericDao<T> {
    protected EntityManager em;
    private Class<T> entityClass;

    public GenericDao(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    public void cadastrar(T entity) {
        try{
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();

            throw new DataException("Erro ao cadastrar a entidade: " + entity.getClass().getSimpleName(), e);
        }
    }

    public void atualizar(T entity) {
        try{
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();

            throw new DataException("Erro ao atualizar a entidade: " + entity.getClass().getSimpleName(), e);
        }
    }

    public void remover(T entity) {
        try{
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();

            throw new DataException("Erro ao excluir a entidade: " + entity.getClass().getSimpleName(), e);
        }
    }

    public T buscarPorId(int id) {
        try{
            return em.find(entityClass, id);
        }catch(Exception e) {
            throw new DataException("Erro ao buscar o id: " + id + " da entidade: " + entityClass.getSimpleName(), e);
        }
    }

    public List<T> buscarTodos() {
        try {
            String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
            return em.createQuery(jpql, entityClass).getResultList();
        } catch (Exception e) {
            throw new DataException("Erro ao buscar todos de: "+ entityClass.getSimpleName(), e);
        }
    }

    public T buscarPorNome(String nomeAtributo, String valor) {
        try {
            String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e." + nomeAtributo + " = :valor";
            return em.createQuery(jpql, entityClass)
                    .setParameter("valor", valor)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new DataException("Erro ao buscar por " + nomeAtributo + " na entidade: " + entityClass.getSimpleName(), e);
        }
    }


    public <T> void salvarEmArquivoBinario(String nomeArquivo, List<T> lista) {
        if (lista != null && !lista.isEmpty()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
                oos.writeObject(lista);
                System.out.println("Arquivo salvo com sucesso.");
            } catch (IOException e) {
                System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
            }
        } else {
            System.out.println("Lista vazia!");
        }
    }


}
