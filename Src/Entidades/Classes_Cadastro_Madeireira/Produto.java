package Src.Entidades.Classes_Cadastro_Madeireira;

/**
 * Classe abstrata que representa um produto genérico da madeireira.
 * Define atributos e comportamentos comuns a todos os produtos.
 * As classes concretas (Madeira e Ferragem) devem implementar o cálculo
 * específico de preço.
 */
public abstract class Produto implements Comparable<Produto> {
    protected Integer ID;
    protected String nome;
    protected double preco;
    protected String cor;

    /**
     * Construtor da classe base Produto
     * 
     * @param ID    Identificador único do produto
     * @param nome  Nome do produto
     * @param cor   Cor do produto
     * @param preco Preço base do produto
     */
    public Produto(int ID, String nome, String cor, double preco) {
        this.ID = ID;
        this.nome = nome;
        this.cor = cor;
        this.preco = preco;
    }

    /**
     * Método abstrato para cálculo de preço final do produto.
     * Deve ser implementado pelas subclasses com regras específicas.
     * 
     * @return Preço final do produto após cálculos específicos
     */
    public abstract double calcularPreco();

    /**
     * Implementação da interface Comparable para ordenação de produtos.
     * Compara produtos por preço calculado.
     * 
     * @param outro Outro produto a ser comparado
     * @return Valor negativo, zero ou positivo se este produto for menor, igual ou
     *         maior
     */
    @Override
    public int compareTo(Produto outro) {
        return Double.compare(this.calcularPreco(), outro.calcularPreco());
    }

    // Getters e Setters com comentários explicativos
    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public double getPreco() {
        return preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * Define o preço base do produto
     * 
     * @param preco Novo preço (deve ser positivo)
     */
    public void setPreco(double preco) {
        if (preco > 0) {
            this.preco = preco;
        }
    }

    /**
     * Representação textual do produto
     * 
     * @return String formatada com informações do produto
     */
    @Override
    public String toString() {
        return String.format("ID: %d, Nome: %s, Cor: %s, Preço: R$%.2f", ID, nome, cor, calcularPreco());
    }
}
