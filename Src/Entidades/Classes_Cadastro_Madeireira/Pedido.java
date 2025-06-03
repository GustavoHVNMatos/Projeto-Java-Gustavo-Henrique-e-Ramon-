package Src.Entidades.Classes_Cadastro_Madeireira;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe que representa um pedido de venda na madeireira.
 */
public class Pedido {
    private Integer numero;
    private Cliente cliente;
    private Date data;
    private List<ItemPedido> itens;
    private double valorTotal;
    private String status; // "Em aberto", "Finalizado", "Cancelado"

    public Pedido(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.data = new Date(); // Data atual
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
        this.status = "Em aberto";
    }

    // Método para adicionar um item ao pedido
    public void adicionarItem(ItemPedido item) {
        itens.add(item);
        calcularTotal();
    }

    // Método para remover um item do pedido
    public void removerItem(ItemPedido item) {
        itens.remove(item);
        calcularTotal();
    }

    // Método para calcular o valor total do pedido
    private void calcularTotal() {
        valorTotal = 0;
        for (ItemPedido item : itens) {
            valorTotal += item.getSubtotal();
        }
    }

    // Método para finalizar o pedido
    public void finalizarPedido() {
        this.status = "Finalizado";
    }

    // Método para cancelar o pedido
    public void cancelarPedido() {
        this.status = "Cancelado";
    }

    // Getters
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
        return new ArrayList<>(itens); // Retorna cópia para evitar modificações externas
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Pedido #" + numero + 
               " - Cliente: " + cliente.getNome() +
               " - Data: " + data +
               " - Total: R$" + valorTotal +
               " - Status: " + status +
               "\nItens: " + itens.size();
    }
}