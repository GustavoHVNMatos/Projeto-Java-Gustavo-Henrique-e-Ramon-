package Src.Entidades.Classes_Cadastro_Madeireira;

/**
 * Classe que representa um cliente da madeireira, que pode ser pessoa física
 * (PF) ou jurídica (PJ).
 * Armazena informações básicas do cliente e formata documentos conforme o tipo.
 */
public class Cliente {
    public enum TipoCliente {
        PF, PJ
    }

    private int id;
    private String nome;
    private String documento; // CPF ou CNPJ
    private TipoCliente tipo; // PF ou PJ
    private String telefone;
    private String endereco;

    /**
     * Construtor completo do cliente
     * 
     * @param id        Identificador único
     * @param nome      Nome ou razão social
     * @param documento CPF ou CNPJ (com ou sem formatação)
     * @param tipo      PF (pessoa física) ou PJ (pessoa jurídica)
     * @param telefone  Telefone para contato
     * @param endereco  Endereço completo
     */
    public Cliente(int id, String nome, String documento, TipoCliente tipo,
            String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        setDocumento(documento, tipo);
        this.tipo = tipo;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    /**
     * Valida e armazena o documento (CPF/CNPJ) removendo formatação
     * 
     * @param documento Documento a ser armazenado
     * @param tipo      Tipo do cliente (PF/PJ) para validação
     * @throws IllegalArgumentException Se o documento for inválido para o tipo
     */
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
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    /**
     * Retorna o documento formatado (CPF: 123.456.789-01 / CNPJ:
     * 12.345.678/0001-99)
     * 
     * @return String com documento formatado
     */
    public String getDocumentoFormatado() {
        if (tipo == TipoCliente.PF) {
            return documento.substring(0, 3) + "." +
                    documento.substring(3, 6) + "." +
                    documento.substring(6, 9) + "-" +
                    documento.substring(9);
        } else {
            return documento.substring(0, 2) + "." +
                    documento.substring(2, 5) + "." +
                    documento.substring(5, 8) + "/" +
                    documento.substring(8, 12) + "-" +
                    documento.substring(12);
        }
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Representação textual completa do cliente
     * 
     * @return String formatada com todas informações
     */
    @Override
    public String toString() {
        return String.format("ID: %d | %s | %s | %s | Tel: %s | End: %s",
                id, nome, getDocumentoFormatado(), tipo, telefone, endereco);
    }
}