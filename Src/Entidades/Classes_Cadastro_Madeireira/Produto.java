package Src.Entidades.Classes_Cadastro_Madeireira;

/**
 * Classe abstrata que representa um produto genérico da madeireira.
 * Serve como base para Madeira e Movel.
 */
public abstract class Produto implements Buscavel {
    protected int codigo;
    protected String nome;
    protected double preco;
    protected String descricao;

    public Produto(int codigo, String nome, double preco, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    // Método abstrato que será implementado pelas subclasses
    public abstract double calcularPreco();

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nome: " + nome + ", Preço: R$" + preco;
    }
}
