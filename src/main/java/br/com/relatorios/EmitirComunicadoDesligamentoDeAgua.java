package br.com.relatorios;

import java.io.Serializable;

public class EmitirComunicadoDesligamentoDeAgua implements Serializable {
    private String nomeResponsavel;
    private String contato;

    public EmitirComunicadoDesligamentoDeAgua(String nomeResponsavel, String contato) {
        this.nomeResponsavel = nomeResponsavel;
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "\nNome Responsavel : " + nomeResponsavel + " || Contato: " + contato  + "\n";
    }
}
