package br.com.service;

import br.com.dao.UnidadeConsumidoraDao;
import br.com.model.UnidadeConsumidora;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UnidadeConsumidoraService {
    private UnidadeConsumidoraDao unidadeConsumidoraDao;

    public UnidadeConsumidoraService(EntityManager em) {
        unidadeConsumidoraDao = new UnidadeConsumidoraDao(em);
    }

    public void cadastrarUnidadeConsumidora(UnidadeConsumidora unidadeConsumidora) {
        unidadeConsumidoraDao.cadastrar(unidadeConsumidora);
    }

    public void atualizarUnidadeConsumidora(UnidadeConsumidora unidadeConsumidora) {
        unidadeConsumidoraDao.atualizar(unidadeConsumidora);
    }

    public void removerUnidadeConsumidora(UnidadeConsumidora unidadeConsumidora) {
        unidadeConsumidoraDao.remover(unidadeConsumidora);
    }

    public UnidadeConsumidora buscarUnidadeConsumidoraPorId(int id) {
        return unidadeConsumidoraDao.buscarPorId(id);
    }

    public List<UnidadeConsumidora> listarTodasAsUnidadeConsumidoras() {
        return unidadeConsumidoraDao.buscarTodos();
    }

    public UnidadeConsumidora buscarUnidadeConsumidoraPorCpfResponsavel(String cpf) {
        return unidadeConsumidoraDao.buscarUnidadeConsumidoraPorCpfResponsavel(cpf);
    }
}
