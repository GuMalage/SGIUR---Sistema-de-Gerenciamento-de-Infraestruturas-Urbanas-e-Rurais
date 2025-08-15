package br.com.enums;

public enum Tipo_Distribuicao {
    AGUA("Distribuidora de Água"),
    LUZ("Distribuidora de Luz");

    private final String tipo_distribuicao_descricao;

    Tipo_Distribuicao(String tipo_distribuicao_descricao){
        this.tipo_distribuicao_descricao = tipo_distribuicao_descricao;
    }

    public String getTipo_Distribuicao_Descricao(){
        return tipo_distribuicao_descricao;
    }
}
