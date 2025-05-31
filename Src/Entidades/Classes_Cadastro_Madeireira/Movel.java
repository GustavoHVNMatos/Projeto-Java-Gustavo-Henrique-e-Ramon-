package Src.Entidades.Classes_Cadastro_Madeireira;

/**
 * Classe que representa um produto do tipo Móvel.
 * Herda da classe abstrata Produto.
 */
public class Movel extends Produto {
    private String tipo;
    private String materiaisUsados;
    private int prazoEntrega; // em dias

    public Movel(int codigo, String nome, double precoBase, String descricao, 
                String tipo, String materiaisUsados, int prazoEntrega) {
        super(codigo, nome, precoBase, descricao);
        this.tipo = tipo;
        this.materiaisUsados = materiaisUsados;
        this.prazoEntrega = prazoEntrega;
        this.preco = calcularPreco(); // Calcula o preço final
    }

    @Override
    public double calcularPreco() {
        // Preço base + ajustes por complexidade
        double precoCalculado = preco;
        
        // Ajuste por tipo de móvel
        switch (tipo.toLowerCase()) {
            case "armário": precoCalculado *= 1.5; break;
            case "mesa": precoCalculado *= 1.3; break;
            case "cadeira": precoCalculado *= 1.1; break;
            default: break;
        }
        
        return precoCalculado;
    }

    // Getters específicos
    public String getTipo() {
        return tipo;
    }

    public String getMateriaisUsados() {
        return materiaisUsados;
    }

    public int getPrazoEntrega() {
        return prazoEntrega;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + tipo + ", Materiais: " + materiaisUsados + ", Prazo: " + prazoEntrega + " dias";
    }
}
