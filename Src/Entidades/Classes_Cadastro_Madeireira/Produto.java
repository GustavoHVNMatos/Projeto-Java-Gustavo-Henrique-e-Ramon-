package Src.Entidades.Classes_Cadastro_Madeireira;

/**
 * Classe abstrata que representa um produto genérico da madeireira
 */
public abstract class Produto implements Comparable<Produto> {
    protected Integer ID;
    protected String nome;
    protected double preco;
    protected String cor;

    public Produto(int ID, String nome, String cor, double preco) {
        this.ID = ID;
        this.nome = nome;
        this.cor = cor;
        this.preco = preco;
    }

    /**
     * Método abstrato para cálculo de preço
     */
    public abstract double calcularPreco();

    /**
     * Implementação da interface Comparable
     */
    @Override
    public int compareTo(Produto outro) {
        return Double.compare(this.calcularPreco(), outro.calcularPreco());
    }

    // Getters e Setters
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

    public void setPreco(double preco) {
        if (preco > 0) {
            this.preco = preco;
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Nome: %s, Cor: %s, Preço: R$%.2f", ID, nome, cor, calcularPreco());
    }
}
