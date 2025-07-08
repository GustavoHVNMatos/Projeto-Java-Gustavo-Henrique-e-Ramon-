package Src.Executor;

import java.util.Scanner;
import Src.Entidades.Gerenciadores.GerenciadorPedidos;
import Src.Entidades.Gerenciadores.GerenciadorProdutos;
import Src.Entidades.Classes_Cadastro_Madeireira.Cliente;
import Src.Entidades.Gerenciadores.GerenciadorClientes;

/**
 * Classe principal do Sistema de Gerenciamento da Madeireira.
 * Responsável por iniciar a aplicação, exibir menus e coordenar as operações
 * entre os diferentes gerenciadores (Produtos, Pedidos e Clientes).
 * 
 * Implementa o padrão de projeto Facade, fornecendo uma interface simplificada
 * para o sistema complexo composto pelos diversos gerenciadores.
 */
public class Programa {

    /**
     * Método principal que inicia a execução do programa.
     * Cria as instâncias dos gerenciadores e inicia o menu principal.
     * 
     * @param args Argumentos de linha de comando (não utilizados neste sistema)
     */
    public static void main(String[] args) {
        // Inicializa os componentes principais do sistema
        Scanner sc = new Scanner(System.in);
        GerenciadorProdutos gerenciadorProdutos = new GerenciadorProdutos();
        GerenciadorPedidos gerenciadorPedidos = new GerenciadorPedidos();
        GerenciadorClientes gerenciadorClientes = new GerenciadorClientes();

        // Carrega dados iniciais para demonstração (requisito 8)
        gerenciadorProdutos.iniciarLista();
        gerenciadorClientes.iniciarClientesTeste();

        // Exibe o menu principal em loop até que o usuário escolha sair
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

            // Encaminha para o submenu correspondente à opção selecionada
            switch (opcao) {
                case 1:
                    menuProdutos(gerenciadorProdutos, sc);
                    break;
                case 2:
                    menuPedidos(gerenciadorPedidos, gerenciadorProdutos, gerenciadorClientes, sc);
                    break;
                case 3:
                    menuClientes(gerenciadorClientes, sc);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        // Libera recursos do scanner antes de encerrar
        sc.close();
    }

    /**
     * Exibe e gerencia o menu de operações para clientes.
     * Permite cadastrar, listar, buscar e filtrar clientes.
     * 
     * @param gerenciador Referência ao gerenciador de clientes
     * @param sc          Scanner para entrada de dados do usuário
     */
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

            switch (opcao) {
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
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    /**
     * Exibe e gerencia o menu de operações para produtos.
     * Permite listar, adicionar, alterar, remover, buscar e ordenar produtos.
     * 
     * @param gerenciador Referência ao gerenciador de produtos
     * @param sc          Scanner para entrada de dados do usuário
     */
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

            switch (opcao) {
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
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    /**
     * Exibe e gerencia o menu de operações para pedidos.
     * Permite efetuar novos pedidos, listar pedidos existentes e cancelar pedidos.
     * 
     * @param gerenciador   Referência ao gerenciador de pedidos
     * @param gerenProd     Referência ao gerenciador de produtos para seleção de
     *                      itens
     * @param gerenClientes Referência ao gerenciador de clientes para associação
     * @param sc            Scanner para entrada de dados do usuário
     */
    private static void menuPedidos(GerenciadorPedidos gerenciador,
            GerenciadorProdutos gerenProd,
            GerenciadorClientes gerenClientes,
            Scanner sc) {
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

            switch (opcao) {
                case 1:
                    gerenciador.efetuarPedido(gerenProd, gerenClientes);
                    break;
                case 2:
                    gerenciador.listarPedidos();
                    break;
                case 3:
                    gerenciador.cancelarPedido();
                    break;
                case 0:
                    System.out.println("Retornando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}