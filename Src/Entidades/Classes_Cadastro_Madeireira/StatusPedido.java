package Src.Entidades.Classes_Cadastro_Madeireira;

/**
 * Enum que representa os estados de um pedido
 */
public enum StatusPedido {
    EM_ABERTO("Em Aberto"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado");
    
    private String descricao;
    
    StatusPedido(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
