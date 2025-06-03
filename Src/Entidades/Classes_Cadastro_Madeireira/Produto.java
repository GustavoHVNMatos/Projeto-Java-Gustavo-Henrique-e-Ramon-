package Src.Entidades.Classes_Cadastro_Madeireira;
/*import Src.Entidades.Interfaces.Buscavel;*/

/**
 * Classe abstrata que representa um produto genérico da madeireira.
 * Serve como base para Madeira.
 */

 public abstract class Produto {
    //apenas definiçãos de variáveis
    protected Integer ID;
    protected String nome;
    protected double preco;
    protected String cor;
    // atribuiçãos da classe
    public Produto(int ID, String nome, String cor, double preco) {
        this.ID = ID;
        this.nome = nome;
        this.cor = cor;
        this.preco = preco;
    }

    // Método abstrato que será implementado pelas subclasses
   /*public abstract double calcularPreco();*/

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
        return String.format("ID: %d, Nome: %s, Cor: %s, Preço: R$%.2f", ID, nome, cor, preco);
    }
        // o que vai ser printado apenas
    
 /*@Override
    public boolean contemTermo(String termoBusca) {
        return nome.toLowerCase().contains(termoBusca.toLowerCase()) ||
               cores.toLowerCase().contains(termoBusca.toLowerCase());
    }*/
}
