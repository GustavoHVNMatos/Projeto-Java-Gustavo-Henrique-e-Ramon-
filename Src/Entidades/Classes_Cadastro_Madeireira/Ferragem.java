package Src.Entidades.Classes_Cadastro_Madeireira;

/**
 * Classe que representa produtos do tipo ferragem.
 * Herda de Produto e adiciona atributo específico (tipo de metal).
 * Ferragens têm cálculo de preço diferente: 5% de acréscimo + R$2 fixo.
 */
public class Ferragem extends Produto {
    private String tipoMetal;

    /**
     * Construtor da classe Ferragem
     * 
     * @param ID        Identificador único
     * @param nome      Nome da ferragem (ex: Parafuso, Dobradiça)
     * @param cor       Cor da ferragem
     * @param preco     Preço base por unidade
     * @param tipoMetal Tipo de metal (Aço, Ferro, etc)
     */
    public Ferragem(int ID, String nome, String cor, double preco, String tipoMetal) {
        super(ID, nome, cor, preco);
        this.tipoMetal = tipoMetal;
    }

    /**
     * Calcula preço com acréscimo de 5% + R$2 fixo para ferragens
     * 
     * @return Preço final da ferragem
     */
    @Override
    public double calcularPreco() {
        return getPreco() * 1.05 + 2.0;
    }

    // Getters e Setters específicos
    public String getTipoMetal() {
        return tipoMetal;
    }

    public void setTipoMetal(String tipoMetal) {
        this.tipoMetal = tipoMetal;
    }

    /**
     * Representação textual incluindo o tipo de metal
     * 
     * @return String formatada com todas informações
     */
    @Override
    public String toString() {
        return super.toString() + ", Metal: " + tipoMetal;
    }
}
