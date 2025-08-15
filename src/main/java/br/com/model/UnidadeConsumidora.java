package br.com.model;

import jakarta.persistence.*;

@Entity
@Table(name = "unidade_consumidora")
public class UnidadeConsumidora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUnidadeConsumidora;

    private String nomeResponsavel;
    private String cpfResponsavel;
    @Column(name = "qnt_pessoas")
    private int qntPessoas;
    private boolean status;
    private String contato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "idRuaLinha"
    )
    private RuaLinha ruaLinha;

    public UnidadeConsumidora() {
    }

    public UnidadeConsumidora(String nomeResponsavel, String cpfResponsavel, int qntPessoas,
                              boolean status, RuaLinha ruaLinha, String contato) {
        this.nomeResponsavel = nomeResponsavel;
        this.cpfResponsavel = cpfResponsavel;
        this.qntPessoas = qntPessoas;
        this.status = status;
        this.ruaLinha = ruaLinha;
        this.contato = contato;
    }

    public int getId() {
        return idUnidadeConsumidora;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    public int getQntPessoas() {
        return qntPessoas;
    }

    public void setQntPessoas(int qnt_pessoas) {
        this.qntPessoas = qnt_pessoas;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public RuaLinha getRuaLinha() {
        return ruaLinha;
    }

    public void setRuaLinha(RuaLinha ruaLinha) {
        this.ruaLinha = ruaLinha;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return  "\nID: " + idUnidadeConsumidora + "\n" +
                "Nome do responsável: " + nomeResponsavel
                + "\nCPF do responsável: " + cpfResponsavel
                + "\nStatus: " + (status ? "Ativo" : "Inativo")
                + "\nRua: " + ruaLinha.getNomeRua() + "\n";
    }
}
