package Src.Entidades.Classes_Cadastro_Madeireira;

/**
 * Classe que representa produtos do tipo ferragem
 */
public class Ferragem extends Produto {
    private String tipoMetal;

    public Ferragem(int ID, String nome, String cor, double preco, String tipoMetal) {
        super(ID, nome, cor, preco);
        this.tipoMetal = tipoMetal;
    }

    /**
     * Calcula preço com acréscimo de 5% + R$2 fixo para ferragens
     */
    @Override
    public double calcularPreco() {
        return getPreco() * 1.05 + 2.0;
    }

    public String getTipoMetal() {
        return tipoMetal;
    }

    public void setTipoMetal(String tipoMetal) {
        this.tipoMetal = tipoMetal;
    }

    @Override
    public String toString() {
        return super.toString() + ", Metal: " + tipoMetal;
    }
}
