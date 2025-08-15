package br.com.service;

import br.com.dao.ColetaSeletivaPorRuaLinhaDao;
import br.com.model.ColetaSeletivaPorRuaLinha;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ColetaSeletivaPorRuaLinhaService {
    private ColetaSeletivaPorRuaLinhaDao coletaSeletivaPorRuaLinhaDao;
    private static EntityManager em;

    public ColetaSeletivaPorRuaLinhaService(EntityManager em) {
        coletaSeletivaPorRuaLinhaDao = new ColetaSeletivaPorRuaLinhaDao(em);
    }

    public void cadastrarColetaSeletivaPorRuaLinhaService(ColetaSeletivaPorRuaLinha coletaSeletivaPorRuaLinha) {
        this.coletaSeletivaPorRuaLinhaDao.cadastrar(coletaSeletivaPorRuaLinha);
    }

    public void atualizarColetaSeletivaPorRuaLinhaService(ColetaSeletivaPorRuaLinha coletaSeletivaPorRuaLinha) {
        this.coletaSeletivaPorRuaLinhaDao.atualizar(coletaSeletivaPorRuaLinha);
    }

    public void removerColetaSeletivaPorRuaLinhaService(ColetaSeletivaPorRuaLinha coletaSeletivaPorRuaLinha) {
        this.coletaSeletivaPorRuaLinhaDao.remover(coletaSeletivaPorRuaLinha);
    }

    public ColetaSeletivaPorRuaLinha buscarColetaSeletivaPorRuaLinhaPorId(int id) {
        return coletaSeletivaPorRuaLinhaDao.buscarPorId(id);
    }

    public List<ColetaSeletivaPorRuaLinha> listarTodasAsRuasLinhasComColetaSeletiva() {
        return coletaSeletivaPorRuaLinhaDao.buscarTodos();
    }

}
