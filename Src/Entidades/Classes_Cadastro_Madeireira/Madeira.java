package Src.Entidades.Classes_Cadastro_Madeireira;

/**
 * Classe que representa um produto do tipo Madeira.
 * Herda da classe abstrata Produto e implementa cálculo de preço específico
 * para madeiras.
 * Madeiras têm acréscimo de 10% no preço base.
 */
public class Madeira extends Produto {
    /**
     * Construtor da classe Madeira
     * 
     * @param ID    Identificador único
     * @param nome  Nome da madeira (ex: Jatobá, Ipê)
     * @param Cor   Cor da madeira
     * @param preco Preço base por chapa
     */
    public Madeira(int ID, String nome, String cor, double preco) {
        super(ID, nome, cor, preco);
    }

    /**
     * Calcula preço final com acréscimo de 10% para madeiras
     * 
     * @return Preço final da madeira
     */
    @Override
    public double calcularPreco() {
        return getPreco() * 1.10;
    }
}