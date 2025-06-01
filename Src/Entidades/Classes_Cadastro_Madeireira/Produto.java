package Src.Entidades.Classes_Cadastro_Madeireira;
import Src.Entidades.Interfaces.Buscavel;

/**
 * Classe abstrata que representa um produto genérico da madeireira.
 * Serve como base para Madeira.
 */

 public class Produto{
    //apenas definiçãos de variáveis
    protected String nome;
    protected double preco;
    protected String cores;
    // atribuiçãos da classe
    public Produto(int ID, String nomes, String cores, double precos) {
        this.nome = nomes;
        this.preco = precos;
        this.cores = cores;
    }

    // Método abstrato que será implementado pelas subclasses
   /*public abstract double calcularPreco();

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
    }*/

    @Override
    public String toString() {
        return "Cores: " + cores + ", Tipo de Madeira: " + nome + ", Preço: R$" + preco;
        // o que vai ser printado apenas
    }


 

    
        
  
            



}
