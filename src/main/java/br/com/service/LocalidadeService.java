package br.com.service;

import br.com.dao.LocalidadeDao;
import br.com.model.Localidade;
import br.com.relatorios.*;
import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.List;

public class LocalidadeService {
    private LocalidadeDao localidadeDao;

    public LocalidadeService(EntityManager em) {
        this.localidadeDao = new LocalidadeDao(em);
    }

    public void cadastrarLocalidade(Localidade localidade) {
        localidadeDao.cadastrar(localidade);
    }

    public void atualizarLocalidade(Localidade localidade) {
        localidadeDao.atualizar(localidade);
    }

    public void removerLocalidade(Localidade localidade) {
        localidadeDao.remover(localidade);
    }

    public Localidade buscarLocalidadePorId(int id) {
        return localidadeDao.buscarPorId(id);
    }

    public List<Localidade> listarTodasAsLocalidades() {
        return localidadeDao.buscarTodos();
    }

    public Localidade buscarLocalidadeNome(String nome) {
        return localidadeDao.buscarPorNome("nomeLocalidade", nome);
    }

    public List<FalhasUnidadeDistribuidoraDeLuzPorLocalidade> listarFalhasUnidadeDistribuidoraDeLuzPorLocalidade(){
        return localidadeDao.listarFalhasUnidadeDistribuidoraDeLuzPorLocalidade();
    }

    public void salvarFalhasUnidadeDistribuidoraDeLuzPorLocalidadeEmArquivoBinario(String nomeArquivoBinario) {
        localidadeDao.salvarEmArquivoBinario(nomeArquivoBinario, listarFalhasUnidadeDistribuidoraDeLuzPorLocalidade());
    }

    public String relatorioColetaSeletivaPorLocalidadeCompleto(
            List<RuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade> listarRuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade,
            List<RuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade> listarRuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade) {

        int total = listarRuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade.size() +
                listarRuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade.size();
        int naoAtendida = listarRuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade.size();
        int atendida = listarRuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade.size();

        double porcentagemAtendidas = total > 0 ? (atendida * 100.0) / total : 0.0;
        double porcentagemNaoAtendidas = total > 0 ? (naoAtendida * 100.0) / total : 0.0;

        StringBuilder sb = new StringBuilder();


        sb.append("\n\nRuas/linhas que possuem coleta seletiva de lixo:\n");
        listarRuasLinhasAtendidasPorColetaETratamentoDeLixoPorLocalidade.forEach(rua ->
                sb.append("- ").append(rua.getNomeRuaLinha()).append("\n")
        );

        sb.append("\nRuas/linhas que NÃO possuem coleta seletiva de lixo:\n");
        listarRuasLinhasNaoAtendidasPorColetaETratamentoDeLixoPorLocalidade.forEach(rua ->
                sb.append("- ").append(rua.getNomeRuaLinha()).append("\n")
        );

        sb.append("\nConclusão:\n");
        sb.append("- Total de ruas/linhas: ").append(total).append("\n");
        sb.append("- Com coleta seletiva: ").append(atendida).append(" (")
                .append(String.format("%.2f", porcentagemAtendidas)).append("%)\n");
        sb.append("- Sem coleta seletiva: ").append(naoAtendida).append(" (")
                .append(String.format("%.2f", porcentagemNaoAtendidas)).append("%)\n");

        return sb.toString();
    }

    public List<CriticidadeDeLocomocaoPorLocalidade> listarCriticidadeDeLocomocaoPorLocalidade(String nomeLocalidade){
        return localidadeDao.listarCriticidadeDeLocomocaoPorLocalidade(nomeLocalidade);
    }

    public void salvarCriticidadeDeLocomocaoPorLocalidadeEmArquivoBinario(String nomeArquivoBinario, String nomeLocalidade) {
        localidadeDao.salvarEmArquivoBinario(nomeArquivoBinario, listarCriticidadeDeLocomocaoPorLocalidade(nomeLocalidade));
    }


}
