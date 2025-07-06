package Src.Entidades.Classes_Cadastro_Madeireira;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe que representa um pedido na madeireira
 */
public class Pedido {
    private Integer numero;
    private Cliente cliente;
    private Date data;
    private List<ItemPedido> itens;
    private double valorTotal;
    private StatusPedido status;

    public Pedido(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.data = new Date();
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
        this.status = StatusPedido.EM_ABERTO;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
        calcularTotal();
    }

    public void removerItem(ItemPedido item) {
        itens.remove(item);
        calcularTotal();
    }

    private void calcularTotal() {
        valorTotal = itens.stream()
                         .mapToDouble(ItemPedido::getSubtotal)
                         .sum();
    }

    public void finalizarPedido() {
        this.status = StatusPedido.FINALIZADO;
    }

    public void cancelarPedido() {
        this.status = StatusPedido.CANCELADO;
    }

    // Getters atualizados...
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
        return new ArrayList<>(itens);
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getStatusString() {
        return status.getDescricao();
    }
    

    /**
     * Retorna a data formatada resumida (DD/MM/AAAA)
     */
    public String getDataFormatada() {
        return String.format("%td/%<tm/%<tY", data);
    }

    /**
     * Retorna a quantidade total de itens no pedido
     */
    public int getQuantidadeItens() {
        return itens.size();
    }

    /**
     * Retorna o nome do cliente ou "Não informado" se for nulo
     */
    public String getNomeCliente() {
        return cliente != null ? cliente.getNome() : "Não informado";
    }

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