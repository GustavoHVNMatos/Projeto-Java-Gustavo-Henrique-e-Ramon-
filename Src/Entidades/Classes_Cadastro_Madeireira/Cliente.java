package Src.Entidades.Classes_Cadastro_Madeireira;

/**
 * Classe que representa um cliente da madeireira.
 * Pode ser pessoa física ou jurídica.
 */
public class Cliente implements Buscavel {
    private String nome;
    private String documento; // CPF ou CNPJ
    private String endereco;
    private String telefone;
    private String tipo; // "PF" ou "PJ"

    public Cliente(String nome, String documento, String endereco, String telefone, String tipo) {
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Documento: " + documento + ", Tipo: " + tipo + 
               ", Telefone: " + telefone + ", Endereço: " + endereco;
    }
}