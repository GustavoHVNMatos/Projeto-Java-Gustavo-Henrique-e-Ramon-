package Src.Entidades.Classes_Cadastro_Madeireira;

/**
 * Classe que representa um cliente da madeireira.
 * Pode ser pessoa física ou jurídica.
 */
public class Cliente {
    public enum TipoCliente { PF, PJ }

    private int id;
    private String nome;
    private String documento; // CPF ou CNPJ
    private TipoCliente tipo; // PF ou PJ
    private String telefone;
    private String endereco;

    public Cliente(int id, String nome, String documento, TipoCliente tipo, 
                 String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        setDocumento(documento, tipo);
        this.tipo = tipo;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    private void setDocumento(String documento, TipoCliente tipo) {
        String docLimpo = documento.replaceAll("[^0-9]", "");
        
        if ((tipo == TipoCliente.PF && docLimpo.length() == 11) || 
            (tipo == TipoCliente.PJ && docLimpo.length() == 14)) {
            this.documento = docLimpo;
        } else {
            throw new IllegalArgumentException("Documento inválido para o tipo " + tipo);
        }
    }

    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getDocumento() { return documento; }
    public TipoCliente getTipo() { return tipo; }
    public String getTelefone() { return telefone; }
    public String getEndereco() { return endereco; }

    public String getDocumentoFormatado() {
    if (tipo == TipoCliente.PF) {
        // Formata CPF exemplo: 123.456.789-01
        return documento.substring(0, 3) + "." + 
               documento.substring(3, 6) + "." + 
               documento.substring(6, 9) + "-" + 
               documento.substring(9);
    } else {
        // Formata CNPJ exemplo: 12.345.678/0001-99
        return documento.substring(0, 2) + "." + 
               documento.substring(2, 5) + "." + 
               documento.substring(5, 8) + "/" + 
               documento.substring(8, 12) + "-" + 
               documento.substring(12);
    }
}

    // Setters
    public void setNome(String nome) { this.nome = nome; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    @Override
    public String toString() {
        return String.format("ID: %d | %s | %s | %s | Tel: %s | End: %s",
            id, nome, getDocumentoFormatado(), tipo, telefone, endereco);
    }
}