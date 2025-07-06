package Src.Entidades.Gerenciadores;

import Src.Entidades.Classes_Cadastro_Madeireira.Cliente;
import Src.Entidades.Classes_Cadastro_Madeireira.Cliente.TipoCliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorClientes {
    private List<Cliente> clientes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int proximoId = 1;

    public void iniciarClientesTeste() {
        clientes.add(new Cliente(proximoId++, "João Silva", "12345678901", TipoCliente.PF, 
                               "11987654321", "Rua das Flores, 123"));
        clientes.add(new Cliente(proximoId++, "Madeira Ltda", "12345678000199", TipoCliente.PJ, 
                               "1133334444", "Av. das Indústrias, 456"));
    }

    public void cadastrarCliente() {
        System.out.println("\n=== CADASTRO DE CLIENTE ===");
        
        TipoCliente tipo = selecionarTipoCliente();
        if (tipo == null) return;
        
        System.out.print(tipo == TipoCliente.PF ? "Nome: " : "Razão Social: ");
        String nome = scanner.nextLine();
        
        System.out.print(tipo == TipoCliente.PF ? "CPF: " : "CNPJ: ");
        String documento = scanner.nextLine();
        
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        try {
            Cliente novoCliente = new Cliente(proximoId++, nome, documento, tipo, telefone, endereco);
            clientes.add(novoCliente);
            System.out.println("Cliente cadastrado com sucesso! ID: " + novoCliente.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        }
    }

    private TipoCliente selecionarTipoCliente() {
        System.out.print("Tipo (1-PF / 2-PJ / 0-Cancelar): ");
        String opcao = scanner.nextLine();
        
        switch (opcao) {
            case "1": return TipoCliente.PF;
            case "2": return TipoCliente.PJ;
            default: return null;
        }
    }

    public void listarClientes() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        System.out.println("+-----+----------------------+---------------------+------+----------------+----------------------+");
        System.out.println("| ID  | Nome/Razão Social    | Documento           | Tipo | Telefone       | Endereço             |");
        System.out.println("+-----+----------------------+---------------------+------+----------------+----------------------+");
        
        for (Cliente cliente : clientes) {
            System.out.printf("| %3d | %-20s | %-19s | %-4s | %-14s | %-20s |\n",
                cliente.getId(),
                cliente.getNome(),
                cliente.getDocumentoFormatado(),
                cliente.getTipo(),
                cliente.getTelefone(),
                cliente.getEndereco());
        }
        System.out.println("+-----+----------------------+---------------------+------+----------------+----------------------+");
    }

    public void listarClientesPorTipo(TipoCliente tipo) {
        System.out.println("\n=== CLIENTES " + tipo + " ===");
        clientes.stream()
                .filter(c -> c.getTipo() == tipo)
                .forEach(System.out::println);
    }

    public Cliente buscarPorDocumento(String documento) {
        String docLimpo = documento.replaceAll("[^0-9]", "");
        
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento().equals(docLimpo)) {
                System.out.println("Cliente encontrado:\n" + cliente);
                return cliente;
            }
        }
        
        System.out.println("Cliente não encontrado!");
        return null;
    }

    public Cliente selecionarCliente() {
        listarClientes();
        if (clientes.isEmpty()) {
            return null;
        }

        System.out.print("\nDigite o ID do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }

        System.out.println("Cliente não encontrado!");
        return null;
    }

    public Cliente getClienteById(int id) {
        return clientes.stream()
                      .filter(c -> c.getId() == id)
                      .findFirst()
                      .orElse(null);
    }
}