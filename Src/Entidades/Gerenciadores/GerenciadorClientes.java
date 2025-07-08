package Src.Entidades.Gerenciadores;

import Src.Entidades.Classes_Cadastro_Madeireira.Cliente;
import Src.Entidades.Classes_Cadastro_Madeireira.Cliente.TipoCliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável por gerenciar todas as operações relacionadas a clientes.
 * Implementa cadastro, listagem, busca e seleção de clientes.
 */
public class GerenciadorClientes {
    private List<Cliente> clientes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int proximoId = 1;

    /**
     * Inicializa o gerenciador com clientes de teste (7 PF e 7 PJ)
     */
    public void iniciarClientesTeste() {
        // 7 clientes PF
        clientes.add(new Cliente(proximoId++, "João Silva", "12345678901", TipoCliente.PF, "11987654321",
                "Rua das Flores, 123"));
        clientes.add(new Cliente(proximoId++, "Maria Oliveira", "98765432109", TipoCliente.PF, "21976543210",
                "Avenida Brasil, 456"));
        clientes.add(new Cliente(proximoId++, "Carlos Souza", "45678912345", TipoCliente.PF, "31965432109",
                "Rua das Palmeiras, 789"));
        clientes.add(new Cliente(proximoId++, "Ana Santos", "78912345678", TipoCliente.PF, "41954321098",
                "Avenida Paulista, 1011"));
        clientes.add(new Cliente(proximoId++, "Pedro Costa", "32165498701", TipoCliente.PF, "51943210987",
                "Rua dos Pinheiros, 1213"));
        clientes.add(new Cliente(proximoId++, "Lucia Ferreira", "65498732109", TipoCliente.PF, "61932109876",
                "Avenida Rio Branco, 1415"));
        clientes.add(new Cliente(proximoId++, "Marcos Rocha", "98732165401", TipoCliente.PF, "71921098765",
                "Rua das Acácias, 1617"));

        // 7 clientes PJ
        clientes.add(new Cliente(proximoId++, "Madeira Ltda", "12345678000199", TipoCliente.PJ, "1133334444",
                "Av. das Indústrias, 456"));
        clientes.add(new Cliente(proximoId++, "Construção S.A.", "98765432000111", TipoCliente.PJ, "2133335555",
                "Rua Comercial, 789"));
        clientes.add(new Cliente(proximoId++, "Móveis Planejados", "45678912000122", TipoCliente.PJ, "3133336666",
                "Avenida Industrial, 1011"));
        clientes.add(new Cliente(proximoId++, "Serralheria Moderna", "78912345000133", TipoCliente.PJ, "4133337777",
                "Rua dos Ferreiros, 1213"));
        clientes.add(new Cliente(proximoId++, "Marcenaria Arte e Madeira", "32165498000144", TipoCliente.PJ,
                "5133338888", "Avenida das Artes, 1415"));
        clientes.add(new Cliente(proximoId++, "Distribuidora de Materiais", "65498732000155", TipoCliente.PJ,
                "6133339999", "Rua dos Distribuidores, 1617"));
        clientes.add(new Cliente(proximoId++, "Ferragens e Acessórios", "98732165000166", TipoCliente.PJ, "7133330000",
                "Avenida Metalúrgica, 1819"));
    }

    /**
     * Cadastra um novo cliente a partir de entrada do usuário
     */
    public void cadastrarCliente() {
        System.out.println("\n=== CADASTRO DE CLIENTE ===");
        System.out.print("Tipo (1-PF / 2-PJ / 0-Cancelar): ");
        String opcao = scanner.nextLine();

        TipoCliente tipo = null;
        if (opcao.equals("1")) {
            tipo = TipoCliente.PF;
        } else if (opcao.equals("2")) {
            tipo = TipoCliente.PJ;
        } else {
            return;
        }

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
            System.out.println("Cliente cadastrado! ID: " + novoCliente.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    /**
     * Lista todos os clientes em formato tabular
     */
    public void listarClientes() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        System.out.println(
                "+-----+----------------------+---------------------+------+----------------+----------------------+");
        System.out.println(
                "| ID  | Nome/Razão Social    | Documento           | Tipo | Telefone       | Endereço             |");
        System.out.println(
                "+-----+----------------------+---------------------+------+----------------+----------------------+");

        for (Cliente cliente : clientes) {
            System.out.printf("| %3d | %-20s | %-19s | %-4s | %-14s | %-20s |\n",
                    cliente.getId(),
                    cliente.getNome(),
                    cliente.getDocumentoFormatado(),
                    cliente.getTipo(),
                    cliente.getTelefone(),
                    cliente.getEndereco());
        }
        System.out.println(
                "+-----+----------------------+---------------------+------+----------------+----------------------+");
    }

    /**
     * Lista clientes filtrando por tipo (PF/PJ)
     * 
     * @param tipo Tipo de cliente a ser listado
     */
    public void listarClientesPorTipo(TipoCliente tipo) {
        System.out.println("\n=== CLIENTES " + tipo + " ===");
        for (Cliente cliente : clientes) {
            if (cliente.getTipo() == tipo) {
                System.out.println(cliente);
            }
        }
    }

    /**
     * Busca um cliente pelo documento (CPF/CNPJ)
     * 
     * @param documento Documento a ser buscado (com ou sem formatação)
     * @return Cliente encontrado ou null se não existir
     */
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

    /**
     * Permite selecionar um cliente da lista pelo ID
     * 
     * @return Cliente selecionado ou null se cancelado
     */
    public Cliente selecionarCliente() {
        listarClientes();
        if (clientes.size() == 0) {
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

    /**
     * Obtém um cliente pelo ID
     * 
     * @param id ID do cliente a ser buscado
     * @return Cliente encontrado ou null se não existir
     */
    public Cliente getClienteById(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}