package Src.Entidades.Classes_Cadastro_Madeireira;

/**
 * Classe que representa um item no estoque da madeireira.
 * Relaciona um produto com sua quantidade disponível.
 */
public class Estoque {
    private Produto produto;
    private int quantidadeDisponivel;
    private int estoqueMinimo;

    public Estoque(Produto produto, int quantidadeDisponivel, int estoqueMinimo) {
        this.produto = produto;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.estoqueMinimo = estoqueMinimo;
    }

    // Método para atualizar o estoque (pode ser positivo ou negativo)
    public void atualizarEstoque(int quantidade) {
        this.quantidadeDisponivel += quantidade;
    }

    // Método para verificar se o estoque está abaixo do mínimo
    public boolean estoqueBaixo() {
        return quantidadeDisponivel < estoqueMinimo;
    }

    // Método para verificar disponibilidade para um pedido
    public boolean disponivelParaVenda(int quantidadeDesejada) {
        return quantidadeDisponivel >= quantidadeDesejada;
    }

    // Getters e Setters
    public Produto getProduto() {
        return produto;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    @Override
    public String toString() {
        String status = estoqueBaixo() ? "ESTOQUE BAIXO" : "Disponível";
        return produto.getNome() + 
               " - Quantidade: " + quantidadeDisponivel + 
               " (Mín: " + estoqueMinimo + ")" +
               " - Status: " + status;
    }
}
