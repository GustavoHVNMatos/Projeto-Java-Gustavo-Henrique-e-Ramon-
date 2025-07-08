package Src.Entidades.Classes_Cadastro_Madeireira;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe que representa um pedido na madeireira.
 * Contém itens de pedido (composição) e gerencia status através de enum.
 */
public class Pedido {
    private Integer numero;
    private Cliente cliente;
    private Date data;
    private List<ItemPedido> itens;
    private double valorTotal;
    private StatusPedido status;

    /**
     * Construtor do pedido
     * 
     * @param numero  Número único do pedido
     * @param cliente Cliente associado ao pedido
     */
    public Pedido(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.data = new Date(); // Data atual
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
        this.status = StatusPedido.EM_ABERTO;
    }

    /**
     * Adiciona um item ao pedido e atualiza o total
     * 
     * @param item Item a ser adicionado
     */
    public void adicionarItem(ItemPedido item) {
        itens.add(item);
        calcularTotal();
    }

    /**
     * Remove um item do pedido e atualiza o total
     * 
     * @param item Item a ser removido
     */
    public void removerItem(ItemPedido item) {
        itens.remove(item);
        calcularTotal();
    }

    /**
     * Calcula o valor total do pedido somando todos os itens
     */
    private void calcularTotal() {
        valorTotal = 0.0;
        for (ItemPedido item : itens) {
            valorTotal += item.getSubtotal();
        }
    }

    /**
     * Finaliza o pedido, alterando seu status
     */
    public void finalizarPedido() {
        this.status = StatusPedido.FINALIZADO;
    }

    /**
     * Cancela o pedido, alterando seu status
     */
    public void cancelarPedido() {
        this.status = StatusPedido.CANCELADO;
    }

    // Getters
    public StatusPedido getStatus() {
        return status;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getData() {
        return data;
    }

    public List<ItemPedido> getItens() {
        return new ArrayList<>(itens); // Retorna cópia para evitar alterações externas
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getStatusString() {
        return status.getDescricao();
    }

    /**
     * Retorna a data formatada (DD/MM/AAAA)
     * 
     * @return String com data formatada
     */
    public String getDataFormatada() {
        return String.format("%td/%<tm/%<tY", data);
    }

    /**
     * Retorna a quantidade total de itens no pedido
     * 
     * @return Número de itens
     */
    public int getQuantidadeItens() {
        return itens.size();
    }

    /**
     * Retorna o nome do cliente ou "Não informado" se for nulo
     * 
     * @return Nome do cliente
     */
    public String getNomeCliente() {
        return cliente != null ? cliente.getNome() : "Não informado";
    }

    /**
     * Representação textual completa do pedido
     * 
     * @return String formatada com todos os dados
     */
    @Override
    public String toString() {
        return String.format("Pedido #%d - %s - %s - %d itens - R$%.2f - %s",
                numero,
                getDataFormatada(),
                getNomeCliente(),
                getQuantidadeItens(),
                valorTotal,
                status);
    }
}