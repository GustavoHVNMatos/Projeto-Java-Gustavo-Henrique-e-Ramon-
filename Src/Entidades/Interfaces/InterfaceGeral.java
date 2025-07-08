package Src.Entidades.Interfaces;

/**
 * Interface que define os métodos básicos que todos os gerenciadores do sistema
 * devem implementar.
 * Serve como um contrato para garantir consistência entre as diferentes
 * operações CRUD do sistema.
 */
public interface InterfaceGeral {

    /**
     * Inicializa a lista de itens com dados padrão para testes
     */
    public void iniciarLista();

    /**
     * Lista todos os itens cadastrados no formato tabular
     */
    public void listarProdutos();

    /**
     * Adiciona um novo item à lista
     */
    public void adicionarProdutos();

    /**
     * Altera os dados de um item existente
     */
    public void alterarProdutos();

    /**
     * Remove um item da lista
     */
    public void retirarProdutos();

    /**
     * Busca itens por um termo de pesquisa
     * 
     * @param termo Texto para busca (pode ser nome, cor, etc)
     */
    public void buscarProduto(String termo);

    /**
     * Ordena os itens por um critério específico
     */
    public void ordenarProdutos();
}