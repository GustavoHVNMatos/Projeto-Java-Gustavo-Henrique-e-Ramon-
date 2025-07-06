package Src.Executor;
import java.util.Scanner;

import Src.Entidades.Gerenciadores.GerenciadorPedidos;
import Src.Entidades.Gerenciadores.GerenciadorProdutos;
import Src.Entidades.Classes_Cadastro_Madeireira.Cliente;
import Src.Entidades.Gerenciadores.GerenciadorClientes;


public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorProdutos gerenciadorProdutos = new GerenciadorProdutos();
        GerenciadorPedidos gerenciadorPedidos = new GerenciadorPedidos();
        GerenciadorClientes gerenciadorClientes = new GerenciadorClientes();
        
        // Inicializa dados de teste
        gerenciadorProdutos.iniciarLista();
        gerenciadorClientes.iniciarClientesTeste();
        
        int opcao;
        do {
            System.out.println("\n=== SISTEMA MADEIREIRA ===");
            System.out.println("1 - Gerenciar Produtos");
            System.out.println("2 - Gerenciar Pedidos");
            System.out.println("3 - Gerenciar Clientes");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao) {
                case 1:
                    menuProdutos(gerenciadorProdutos, sc);
                    break;
                case 2:
                    menuPedidos(gerenciadorPedidos, gerenciadorProdutos, gerenciadorClientes, sc);
                    break;
                case 3:
                    menuClientes(gerenciadorClientes, sc);
                    break;
            }
        } while(opcao != 0);
        sc.close();
    }
    
    private static void menuClientes(GerenciadorClientes gerenciador, Scanner sc) {
        int opcao;
        do {
            System.out.println("\n=== MENU CLIENTES ===");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Todos Clientes");
            System.out.println("3 - Listar Clientes PF");
            System.out.println("4 - Listar Clientes PJ");
            System.out.println("5 - Buscar por Documento");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao) {
                case 1:
                    gerenciador.cadastrarCliente();
                    break;
                case 2:
                    gerenciador.listarClientes();
                    break;
                case 3:
                    gerenciador.listarClientesPorTipo(Cliente.TipoCliente.PF);
                    break;
                case 4:
                    gerenciador.listarClientesPorTipo(Cliente.TipoCliente.PJ);
                    break;
                case 5:
                    System.out.print("Digite CPF/CNPJ: ");
                    String doc = sc.nextLine();
                    gerenciador.buscarPorDocumento(doc);
                    break;
            }
        } while(opcao != 0);
    }
    
    private static void menuProdutos(GerenciadorProdutos gerenciador, Scanner sc) {
        int opcao;
        do {
            System.out.println("\n=== MENU PRODUTOS ===");
            System.out.println("1 - Listar Produtos");
            System.out.println("2 - Adicionar Produto");
            System.out.println("3 - Alterar Produto");
            System.out.println("4 - Remover Produto");
            System.out.println("5 - Buscar Produto");
            System.out.println("6 - Ordenar Produtos");
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();
            
            switch(opcao) {
                case 1:
                    gerenciador.listarProdutos();
                    break;
                case 2:
                    gerenciador.adicionarProdutos();
                    break;
                case 3:
                    gerenciador.alterarProdutos();
                    break;
                case 4:
                    gerenciador.retirarProdutos();
                    break;
                case 5:
                    gerenciador.buscarProduto();
                    break;
                case 6:
                    gerenciador.ordenarProdutos();
                    break;
            }
        } while(opcao != 0);
    }
    
    private static void menuPedidos(GerenciadorPedidos gerenciador, GerenciadorProdutos gerenProd,GerenciadorClientes gerenClientes, Scanner sc) {
        int opcao;
    do {
        System.out.println("\n=== MENU PEDIDOS ===");
        System.out.println("1 - Efetuar Pedido");
        System.out.println("2 - Listar Pedidos");
        System.out.println("3 - Cancelar Pedido");
        System.out.println("0 - Voltar");
        System.out.print("Opção: ");
        opcao = sc.nextInt();
        sc.nextLine();
        
        switch(opcao) {
            case 1:
                gerenciador.efetuarPedido(gerenProd, gerenClientes);
                break;
            case 2:
                gerenciador.listarPedidos(); // Mostra apenas não-cancelados
                break;
            case 3:
                gerenciador.cancelarPedido();
                break;
        }
    } while(opcao != 0);
}
}