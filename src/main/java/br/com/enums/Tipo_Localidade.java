package br.com.enums;

public enum Tipo_Localidade {
    URBANA("Urbana"),
    RURAL("Rural");

    private final String tipo_localidade_descricao;

    Tipo_Localidade(String tipo_localidade_descricao){
        this.tipo_localidade_descricao = tipo_localidade_descricao;
    }

    public String getTipo_Localidade_Descricao() {
        return tipo_localidade_descricao;
    }
}
