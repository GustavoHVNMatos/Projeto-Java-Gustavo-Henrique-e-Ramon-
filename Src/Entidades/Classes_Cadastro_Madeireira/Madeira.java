package Src.Entidades.Classes_Cadastro_Madeireira;

/**
 * Classe que representa um produto do tipo Madeira.
 * Herda da classe abstrata Produto.
 */
public class Madeira extends Produto {
    public Madeira(int ID, String nome, String cor, double preco) {
        super(ID, nome, cor, preco);
    }
    /*private String tipo;
    private double comprimento; // em metros
    private double espessura; // em centímetros
    private String qualidade; // A, B ou C

    public Madeira(int codigo, String nome, double precoBase, String descricao, 
                  String tipo, double comprimento, double espessura, String qualidade) {
        super(codigo, nome, precoBase, descricao);
        this.tipo = tipo;
        this.comprimento = comprimento;
        this.espessura = espessura;
        this.qualidade = qualidade;
        this.preco = calcularPreco(); // Calcula o preço final
    }

    @Override
    public double calcularPreco() {
        // Preço base + ajustes por dimensão e qualidade
        double precoCalculado = preco;
        precoCalculado *= comprimento; // Quanto maior, mais caro
        
        // Ajuste por qualidade
        switch (qualidade) {
            case "A": precoCalculado *= 1.3; break;
            case "B": precoCalculado *= 1.1; break;
            case "C": break; // Mantém o preço base
        }
        
        return precoCalculado;
    }

    // Getters específicos
    public String getTipo() {
        return tipo;
    }

    public double getComprimento() {
        return comprimento;
    }

    public double getEspessura() {
        return espessura;
    }

    public String getQualidade() {
        return qualidade;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + tipo + ", Comprimento: " + comprimento + "m, Espessura: " + espessura + "cm";
    }*/
    
}
