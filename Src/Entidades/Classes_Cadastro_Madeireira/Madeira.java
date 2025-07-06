package Src.Entidades.Classes_Cadastro_Madeireira;

/**
 * Classe que representa um produto do tipo Madeira
 */
public class Madeira extends Produto {
    public Madeira(int ID, String nome, String cor, double preco) {
        super(ID, nome, cor, preco);
    }

    /**
     * Calcula preço com acréscimo de 10% para madeiras
     */
    @Override
    public double calcularPreco() {
        return getPreco() * 1.10;
    }
}
