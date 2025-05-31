package Src.Entidades.Classes_Cadastro_Madeireira;

/**
 * Classe que representa um item de um pedido.
 * Relaciona um produto com sua quantidade no pedido.
 */
public class ItemPedido {
    private Produto produto;
    private int quantidade;
    private double subtotal;

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

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.subtotal = produto.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return produto.getNome() + " - Quantidade: " + quantidade + " - Subtotal: R$" + subtotal;
    }
}