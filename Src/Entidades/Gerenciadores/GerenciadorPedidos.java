package Src.Entidades.Gerenciadores;

import Src.Entidades.Classes_Cadastro_Madeireira.Cliente;
import Src.Entidades.Classes_Cadastro_Madeireira.Pedido;
import Src.Entidades.Classes_Cadastro_Madeireira.Produto;
import Src.Entidades.Classes_Cadastro_Madeireira.ItemPedido;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável por gerenciar todas as operações relacionadas a pedidos na
 * madeireira.
 * Implementa funcionalidades para criação, cancelamento, listagem e finalização
 * de pedidos.
 * Utiliza composição com a classe ItemPedido e associação com
 * GerenciadorProdutos e GerenciadorClientes.
 */
public class GerenciadorPedidos {
    // Lista de todos os pedidos registrados no sistema
    private List<Pedido> pedidos = new ArrayList<>();

    // Carrinho temporário para itens sendo selecionados antes de finalizar o pedido
    private List<ItemPedido> carrinho = new ArrayList<>();

    // Scanner para entrada de dados do usuário
    private Scanner sc = new Scanner(System.in);

    /**
     * Processa um novo pedido desde a seleção de produtos até a finalização.
     * 
     * @param gerenciadorProdutos Referência ao gerenciador de produtos para seleção
     *                            dos itens
     * @param gerenciadorClientes Referência ao gerenciador de clientes para
     *                            associar ao pedido
     */
    public void efetuarPedido(GerenciadorProdutos gerenciadorProdutos, GerenciadorClientes gerenciadorClientes) {
        boolean continuar = true;

        System.out.println("\n=== NOVO PEDIDO ===");

        // Loop principal para adicionar múltiplos itens ao pedido
        while (continuar) {
            System.out.println("\n=== TIPO DE PRODUTO ===");
            System.out.println("1 - Madeira");
            System.out.println("2 - Ferragem");
            System.out.println("3 - Cancelar Pedido");
            System.out.print("Opção: ");
            int tipoProduto = sc.nextInt();
            sc.nextLine();

            // Opção para cancelar todo o pedido
            if (tipoProduto == 3) {
                carrinho.clear();
                System.out.println("Pedido cancelado!");
                return;
            }

            // Polimorfismo - comportamento diferente para cada tipo de produto
            switch (tipoProduto) {
                case 1:
                    adicionarMadeira(gerenciadorProdutos);
                    break;
                case 2:
                    adicionarFerragem(gerenciadorProdutos);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            System.out.print("\nDeseja adicionar mais produtos? (S/N): ");
            continuar = sc.nextLine().equalsIgnoreCase("S");
        }

        // Se houver itens no carrinho, finaliza o pedido
        if (!carrinho.isEmpty()) {
            finalizarPedido(gerenciadorClientes);
        }
    }

    /**
     * Método auxiliar para adicionar produtos do tipo Madeira ao carrinho.
     * Guia o usuário através das opções de madeira, cor e quantidade.
     * 
     * @param gerenciadorProdutos Referência ao gerenciador de produtos para obter
     *                            os itens
     */
    private void adicionarMadeira(GerenciadorProdutos gerenciadorProdutos) {
        System.out.println("\n=== ESCOLHA A MADEIRA ===");
        System.out.println("1 - Jatobá");
        System.out.println("2 - Ipê");
        System.out.println("3 - Cerejeira");
        System.out.println("4 - Massaranduba");
        System.out.println("5 - MDF");
        System.out.println("6 - MDF Naval");
        System.out.println("7 - Pinho");
        System.out.println("8 - Cancelar");
        System.out.print("Opção: ");
        int opcaoMadeira = sc.nextInt();
        sc.nextLine();

        // Verifica se o usuário cancelou
        if (opcaoMadeira == 8)
            return;
        if (opcaoMadeira < 1 || opcaoMadeira > 7) {
            System.out.println("Opção inválida!");
            return;
        }

        // Seleção da cor da madeira
        System.out.println("\n=== ESCOLHA A COR ===");
        System.out.println("1 - cobalto");
        System.out.println("2 - branco");
        System.out.println("3 - basalto-cinza");
        System.out.println("4 - amadeirado");
        System.out.println("5 - preto");
        System.out.println("6 - rosê");
        System.out.println("7 - avermelhado");
        System.out.println("8 - Cancelar");
        System.out.print("Opção: ");
        int opcaoCor = sc.nextInt();
        sc.nextLine();

        if (opcaoCor == 8)
            return;
        if (opcaoCor < 1 || opcaoCor > 7) {
            System.out.println("Opção inválida!");
            return;
        }

        // Seleção da quantidade
        System.out.print("\nQuantidade de chapas: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        if (quantidade <= 0) {
            System.out.println("Quantidade inválida!");
            return;
        }

        // Obtém o produto selecionado e adiciona ao carrinho
        Produto produtoSelecionado = gerenciadorProdutos.getProdutoByIndex(opcaoMadeira - 1);
        if (produtoSelecionado != null) {
            String corSelecionada = getCorMadeiraByIndex(opcaoCor - 1);
            carrinho.add(new ItemPedido(produtoSelecionado, quantidade));

            // Confirmação com detalhes do item adicionado
            System.out.println("\n=== ITEM ADICIONADO ===");
            System.out.println("Produto: " + produtoSelecionado.getNome());
            System.out.println("Cor: " + corSelecionada);
            System.out.println("Quantidade: " + quantidade);
            System.out.printf("Subtotal: R$%.2f\n", produtoSelecionado.calcularPreco() * quantidade);
        }
    }

    /**
     * Método auxiliar para adicionar produtos do tipo Ferragem ao carrinho.
     * Guia o usuário através das opções de ferragem, cor, metal e quantidade.
     * 
     * @param gerenciadorProdutos Referência ao gerenciador de produtos para obter
     *                            os itens
     */
    private void adicionarFerragem(GerenciadorProdutos gerenciadorProdutos) {
        System.out.println("\n=== ESCOLHA A FERRAGEM ===");
        System.out.println("1 - Parafuso 5mm");
        System.out.println("2 - Prego 3mm");
        System.out.println("3 - Dobradiça");
        System.out.println("4 - Fechadura");
        System.out.println("5 - Haste Metálica");
        System.out.println("6 - Cancelar");
        System.out.print("Opção: ");
        int opcaoFerragem = sc.nextInt();
        sc.nextLine();

        if (opcaoFerragem == 6)
            return;
        if (opcaoFerragem < 1 || opcaoFerragem > 5) {
            System.out.println("Opção inválida!");
            return;
        }

        // Seleção da cor da ferragem
        System.out.println("\n=== ESCOLHA A COR DA FERRAGEM ===");
        System.out.println("1 - prata");
        System.out.println("2 - dourado");
        System.out.println("3 - preto");
        System.out.println("4 - prata");
        System.out.println("5 - cinza");
        System.out.println("6 - Cancelar");
        System.out.print("Opção: ");
        int opcaoCorFerragem = sc.nextInt();
        sc.nextLine();

        if (opcaoCorFerragem == 6)
            return;
        if (opcaoCorFerragem < 1 || opcaoCorFerragem > 5) {
            System.out.println("Opção inválida!");
            return;
        }

        // Seleção do tipo de metal
        System.out.println("\n=== ESCOLHA O METAL ===");
        System.out.println("1 - Aço");
        System.out.println("2 - Ferro");
        System.out.println("3 - Alumínio");
        System.out.println("4 - Latão");
        System.out.println("5 - Aço Inox");
        System.out.println("6 - Cancelar");
        System.out.print("Opção: ");
        int opcaoMetal = sc.nextInt();
        sc.nextLine();

        if (opcaoMetal == 6)
            return;
        if (opcaoMetal < 1 || opcaoMetal > 5) {
            System.out.println("Opção inválida!");
            return;
        }

        // Seleção da quantidade
        System.out.print("\nQuantidade de unidades: ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        if (quantidade <= 0) {
            System.out.println("Quantidade inválida!");
            return;
        }

        // Obtém o produto selecionado e adiciona ao carrinho
        Produto produtoSelecionado = gerenciadorProdutos.getProdutoByIndex(opcaoFerragem + 6);
        if (produtoSelecionado != null) {
            String corSelecionada = getCorFerragemByIndex(opcaoCorFerragem - 1);
            String metalSelecionado = getMetalByIndex(opcaoMetal - 1);
            carrinho.add(new ItemPedido(produtoSelecionado, quantidade));

            // Confirmação com detalhes do item adicionado
            System.out.println("\n=== ITEM ADICIONADO ===");
            System.out.println("Produto: " + produtoSelecionado.getNome());
            System.out.println("Cor: " + corSelecionada);
            System.out.println("Metal: " + metalSelecionado);
            System.out.println("Quantidade: " + quantidade);
            System.out.printf("Subtotal: R$%.2f\n", produtoSelecionado.calcularPreco() * quantidade);
        }
    }

    /**
     * Exibe um resumo detalhado de todos os itens no carrinho atual com o valor
     * total.
     */
    public void exibirResumoPedido() {
        if (carrinho.size() == 0) {
            System.out.println("\nCarrinho vazio!");
            return;
        }

        System.out.println("\n=== RESUMO DO PEDIDO ===");
        double total = 0;

        // Lista todos os itens do carrinho com seus subtotais
        for (int i = 0; i < carrinho.size(); i++) {
            ItemPedido item = carrinho.get(i);
            Produto produto = item.getProduto();
            int quantidade = item.getQuantidade();
            double subtotal = produto.calcularPreco() * quantidade;

            System.out.printf("- %s (Qtd: %d) - R$%.2f\n",
                    produto.getNome(),
                    quantidade,
                    subtotal);
            total += subtotal;
        }

        System.out.println("----------------------");
        System.out.printf("TOTAL: R$%.2f\n", total);
    }

    /**
     * Finaliza o pedido atual, associando um cliente e registrando no sistema.
     * 
     * @param gerenciadorClientes Referência ao gerenciador de clientes para seleção
     */
    private void finalizarPedido(GerenciadorClientes gerenciadorClientes) {
        // Mostra resumo antes de finalizar
        exibirResumoPedido();

        System.out.println("\n=== SELECIONE O CLIENTE ===");
        Cliente cliente = gerenciadorClientes.selecionarCliente();
        if (cliente == null) {
            System.out.println("Operação cancelada.");
            carrinho.clear();
            return;
        }

        // Cria novo pedido com número sequencial
        Pedido novoPedido = new Pedido(pedidos.size() + 1, cliente);

        // Adiciona todos os itens do carrinho ao pedido
        for (ItemPedido item : carrinho) {
            novoPedido.adicionarItem(item);
        }

        // Finaliza e armazena o pedido
        novoPedido.finalizarPedido();
        pedidos.add(novoPedido);
        carrinho.clear();

        // Confirmação com dados do cliente
        System.out.println("\nPedido #" + novoPedido.getNumero() + " registrado para:");
        System.out.println(cliente.getTipo() == Cliente.TipoCliente.PF ? "CPF: " + cliente.getDocumentoFormatado()
                : "CNPJ: " + cliente.getDocumentoFormatado());
    }

    /**
     * Permite cancelar um pedido existente que ainda não foi cancelado.
     * Mostra lista de pedidos ativos e permite selecionar qual cancelar.
     */
    public void cancelarPedido() {
        // Filtra apenas pedidos não cancelados
        List<Pedido> pedidosAtivos = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (!pedido.getStatus().toString().equals("CANCELADO")) {
                pedidosAtivos.add(pedido);
            }
        }

        if (pedidosAtivos.isEmpty()) {
            System.out.println("\nNenhum pedido disponível para cancelamento.");
            return;
        }

        // Lista pedidos disponíveis para cancelamento
        System.out.println("\n=== PEDIDOS PARA CANCELAMENTO ===");
        for (Pedido pedido : pedidosAtivos) {
            System.out.println("Nº " + pedido.getNumero() + " - " + pedido.getNomeCliente() +
                    " - R$" + pedido.getValorTotal() + " - " + pedido.getStatus());
        }

        System.out.print("\nDigite o número do pedido a cancelar (ou 0 para voltar): ");
        int numeroPedido = sc.nextInt();
        sc.nextLine();

        if (numeroPedido == 0)
            return;

        // Busca e cancela o pedido selecionado
        boolean encontrado = false;
        for (Pedido pedido : pedidos) {
            if (pedido.getNumero() == numeroPedido &&
                    !pedido.getStatus().toString().equals("CANCELADO")) {
                pedido.cancelarPedido();
                System.out.println("\nPedido #" + numeroPedido + " cancelado com sucesso!");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Pedido não encontrado ou já cancelado!");
        }
    }

    /**
     * Lista todos os pedidos ativos (não cancelados) com seus itens.
     */
    public void listarPedidos() {
        System.out.println("\n=== LISTA DE PEDIDOS ===");
        boolean encontrados = false;

        for (Pedido pedido : pedidos) {
            if (!pedido.getStatus().toString().equals("CANCELADO")) {
                System.out.println(pedido.toString());
                System.out.println("Itens do pedido:");
                for (ItemPedido item : pedido.getItens()) {
                    System.out.printf("- %s (Qtd: %d) - R$%.2f\n",
                            item.getProduto().getNome(),
                            item.getQuantidade(),
                            item.getSubtotal());
                }
                System.out.println("----------------------");
                encontrados = true;
            }
        }

        if (!encontrados) {
            System.out.println("Nenhum pedido ativo registrado.");
        }
    }

    // Métodos auxiliares para obter descrições a partir de índices

    /**
     * Retorna a cor da madeira correspondente ao índice
     * 
     * @param index Índice da cor (0-based)
     * @return Nome da cor
     */
    private String getCorMadeiraByIndex(int index) {
        String[] cores = { "cobalto", "branco", "basalto-cinza", "amadeirado", "preto", "rosê", "avermelhado" };
        return cores[index];
    }

    /**
     * Retorna a cor da ferragem correspondente ao índice
     * 
     * @param index Índice da cor (0-based)
     * @return Nome da cor
     */
    private String getCorFerragemByIndex(int index) {
        String[] cores = { "prata", "dourado", "preto", "prata", "cinza" };
        return cores[index];
    }

    /**
     * Retorna o tipo de metal correspondente ao índice
     * 
     * @param index Índice do metal (0-based)
     * @return Nome do metal
     */
    private String getMetalByIndex(int index) {
        String[] metais = { "Aço", "Ferro", "Alumínio", "Latão", "Aço Inox" };
        return metais[index];
    }
}

// lógica: printar lista - opções de vender escolhendo cor, tipo de madeira,
// mostrar valores e pedir cadastro. se não houver cadastro, ele cria cadastro.

/*
 * scanner = new Scanner(System.in);
 * import java.util.Scanner;
 * 
 * 
 * system.out.println("escolha qual madeira deseja:"); /// chamar a funçao de
 * madeiras
 * System.out.println("1 - Jatobá");
 * System.out.println("2 - Ipê");
 * System.out.println("3 - Cerejeira");
 * System.out.println("4 - Massaranduba");
 * System.out.println("5 - MDF");
 * System.out.println("6 - MDF Naval");
 * System.out.println("7 - Pinho");
 * System.out.println("8 - Sair");
 * System.out.println("9 - Voltar");
 * sc.nextInt();
 * sc.nextLine();
 * system.out.println("escolha qual cor deseja:"); /// chamar a funçao de cores
 * System.out.println("1 - cobalto");
 * System.out.println("2 - branco");
 * System.out.println("3 - basalto-cinza");
 * System.out.println("4 - amadeirado");
 * System.out.println("5 - preto");
 * System.out.println("6 - rosê");
 * System.out.println("7 - naosei");
 * System.out.println("8 - Sair");
 * System.out.println("9 - Voltar");
 * sc.nextInt();
 * sc.nextLine();
 * system.out.println("quantidade de chapas:"); ///
 * sc.nextInt();
 * sc.nextLine();
 * calculo do valor = preco * quantidade de chapas
 * system.out.println = "deseja mais algum produto?" /// com opçao de fazer mais
 * um pedido se der
 * ou criar um looping while com novo menu. oq for mais facil
 * system.out.println = printar a opção escolhida,a cor, a quantidade e o valor
 * total ao lado de valor
 * se possivel, mandar pra pra classe pedido ou item pedido.
 * fim de nota, mostrar pedidos numerados por id e vender.
 * 
 * 
 * 
 * 
 */