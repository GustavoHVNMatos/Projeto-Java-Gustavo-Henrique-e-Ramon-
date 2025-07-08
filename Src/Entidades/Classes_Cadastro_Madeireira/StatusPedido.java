package Src.Entidades.Classes_Cadastro_Madeireira;

/**
 * Enum que representa os estados de um pedido.
 * Segue o padrão mostrado nos slides de POO.
 */
public enum StatusPedido {
    EM_ABERTO("Em Aberto"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado");

    private String descricao;

    /**
     * Construtor do enum
     * 
     * @param descricao Descrição textual do status
     */
    StatusPedido(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna a descrição do status
     * 
     * @return String com descrição
     */
    public String getDescricao() {
        return descricao;
    }
}