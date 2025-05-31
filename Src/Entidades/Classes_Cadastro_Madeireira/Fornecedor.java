package Src.Entidades.Classes_Cadastro_Madeireira;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um fornecedor de materiais para a madeireira.
 * Implementa a interface Buscavel para permitir pesquisas.
 */
public class Fornecedor implements Buscavel {
    private String nome;
    private String cnpj;
    private String telefone;
    private String endereco;
    private List<Produto> produtosFornecidos;

    public Fornecedor(String nome, String cnpj, String telefone, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.endereco = endereco;
        this.produtosFornecidos = new ArrayList<>();
    }

    // Método para adicionar um produto fornecido
    public void adicionarProdutoFornecido(Produto produto) {
        if (!produtosFornecidos.contains(produto)) {
            produtosFornecidos.add(produto);
        }
    }

    // Método para remover um produto fornecido
    public void removerProdutoFornecido(Produto produto) {
        produtosFornecidos.remove(produto);
    }

    // Implementação da interface Buscavel
    @Override
    public boolean contemTermo(String termoBusca) {
        return nome.toLowerCase().contains(termoBusca.toLowerCase()) ||
               cnpj.contains(termoBusca) ||
               endereco.toLowerCase().contains(termoBusca.toLowerCase());
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<Produto> getProdutosFornecidos() {
        return new ArrayList<>(produtosFornecidos); // Retorna cópia para evitar modificações externas
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Fornecedor: " + nome + " - CNPJ: " + cnpj + 
               "\nProdutos fornecidos: " + produtosFornecidos.size() +
               "\nContato: " + telefone;
    }
}
