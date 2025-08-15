package br.com.enums;

public enum Tipo_Tratamento {
    AGUA("Tratamento de Água"),
    ESGOTO("Tratamento de Esgoto"),
    LIXO("Coleta e Tratamento de Lixo");

    private final String tipo_tratamento_descricao;

    Tipo_Tratamento(String tipo_tratamento_descricao){
        this.tipo_tratamento_descricao = tipo_tratamento_descricao;
    }

    public String getTipo_Tratamento_Descricao() {
        return tipo_tratamento_descricao;
    }
}
