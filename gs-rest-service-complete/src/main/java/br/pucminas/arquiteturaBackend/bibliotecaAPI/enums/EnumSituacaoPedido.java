package br.pucminas.arquiteturaBackend.bibliotecaAPI.enums;

public enum EnumSituacaoPedido {

	SEPARADO("S", "Separado"),
    DISTRIBUIDO("D", "Distribuído"),
    ENTREGUE("E", "Entregue"),
    CANCELADO("X", "Cancelado"),
    ;

    public String tipo;
    public String descricao;

    EnumSituacaoPedido(String situacao, String descricao) {
        this.tipo = situacao;
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static EnumSituacaoPedido retornaEnumSelecionado(String enumSelecionado) {
        for (EnumSituacaoPedido en : EnumSituacaoPedido.values()) {
            if (en.getTipo().contains(enumSelecionado)) {
                return en;
            }
        }

        return null;
    }


}
