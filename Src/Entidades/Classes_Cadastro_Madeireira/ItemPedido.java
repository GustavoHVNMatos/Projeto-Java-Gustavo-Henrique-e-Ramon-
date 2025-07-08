package Src.Entidades.Classes_Cadastro_Madeireira;

/**
 * Classe que representa um item de um pedido.
 * Relaciona um produto com sua quantidade no pedido (composição).
 * Calcula automaticamente o subtotal quando criado ou alterado.
 */
public class ItemPedido {
    private Produto produto;
    private Integer quantidade;
    private double subtotal;

    /**
     * Construtor do item do pedido
     * 
     * @param produto    Produto associado ao item
     * @param quantidade Quantidade do produto
     */
    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.subtotal = produto.getPreco() * quantidade;
    }

    // Getters
    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return subtotal;
    }

    /**
     * Altera a quantidade e recalcula o subtotal
     * 
     * @param quantidade Nova quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.subtotal = produto.getPreco() * quantidade;
    }

    /**
     * Representação textual do item
     * 
     * @return String com nome, quantidade e subtotal
     */
    @Override
    public String toString() {
        return produto.getNome() + " - Quantidade: " + quantidade + " - Subtotal: R$" + subtotal;
    }
}