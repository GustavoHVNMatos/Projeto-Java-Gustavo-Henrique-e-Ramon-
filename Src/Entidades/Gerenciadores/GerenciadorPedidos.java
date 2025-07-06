package Src.Entidades.Gerenciadores;

import Src.Entidades.Classes_Cadastro_Madeireira.Cliente;
import Src.Entidades.Classes_Cadastro_Madeireira.Pedido;
import Src.Entidades.Classes_Cadastro_Madeireira.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorPedidos {
    private List<Pedido> pedidos = new ArrayList<>();
    private List<ItemPedido> carrinho = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    private class ItemPedido {
        private Produto produto;
        private int quantidade;
        private String corSelecionada;
        private String metalSelecionado; // Apenas para ferragens

        public ItemPedido(Produto produto, int quantidade, String corSelecionada, String metalSelecionado) {
            this.produto = produto;
            this.quantidade = quantidade;
            this.corSelecionada = corSelecionada;
            this.metalSelecionado = metalSelecionado;
        }

        public double getSubtotal() {
            return produto.calcularPreco() * quantidade;
        }

        public Produto getProduto() { return produto; }
        public int getQuantidade() { return quantidade; }
        public String getCorSelecionada() { return corSelecionada; }
        public String getMetalSelecionado() { return metalSelecionado; }
    }

    public void efetuarPedido(GerenciadorProdutos gerenciadorProdutos, GerenciadorClientes gerenciadorClientes) {
        boolean continuar = true;
        
        System.out.println("\n=== NOVO PEDIDO ===");
        
        while(continuar) {
            System.out.println("\n=== TIPO DE PRODUTO ===");
            System.out.println("1 - Madeira");
            System.out.println("2 - Ferragem");
            System.out.println("3 - Cancelar Pedido");
            System.out.print("Opção: ");
            int tipoProduto = sc.nextInt();
            sc.nextLine();
            
            if(tipoProduto == 3) {
                carrinho.clear();
                System.out.println("Pedido cancelado!");
                return;
            }
            
            switch(tipoProduto) {
                case 1:
                    adicionarMadeira(gerenciadorProdutos);
                    break;
                case 2:
                    adicionarFerragem(gerenciadorProdutos);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }
            
            System.out.print("\nDeseja adicionar mais produtos? (S/N): ");
            continuar = sc.nextLine().equalsIgnoreCase("S");
        }
        
        if(!carrinho.isEmpty()) {
            finalizarPedido(gerenciadorClientes);
        }
    }
    
    private void adicionarMadeira(GerenciadorProdutos gerenciadorProdutos) {
        // Menu de madeiras
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
        
        if(opcaoMadeira == 8) return;
        if(opcaoMadeira < 1 || opcaoMadeira > 7) {
            System.out.println("Opção inválida!");
            return;
        }
        
        // Menu de cores para madeiras
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

        if(opcaoCor == 8) return;
        if(opcaoCor < 1 || opcaoCor > 7) {
            System.out.println("Opção inválida!");
            return;
        }
        
        // Quantidade de chapas
        System.out.print("\nQuantidade de chapas: ");
        int quantidade = sc.nextInt();
        sc.nextLine();
        
        if(quantidade <= 0) {
            System.out.println("Quantidade inválida!");
            return;
        }
        
        // Adiciona ao carrinho
        Produto produtoSelecionado = gerenciadorProdutos.getProdutoByIndex(opcaoMadeira-1);
        if(produtoSelecionado != null) {
            String corSelecionada = getCorMadeiraByIndex(opcaoCor-1);
            carrinho.add(new ItemPedido(produtoSelecionado, quantidade, corSelecionada, null));
            
            System.out.println("\n=== ITEM ADICIONADO ===");
            System.out.println("Produto: " + produtoSelecionado.getNome());
            System.out.println("Cor: " + corSelecionada);
            System.out.println("Quantidade: " + quantidade);
            System.out.printf("Subtotal: R$%.2f\n", produtoSelecionado.calcularPreco() * quantidade);
        }
    }
    
    private void adicionarFerragem(GerenciadorProdutos gerenciadorProdutos) {
        // Menu de ferragens
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
        
        if(opcaoFerragem == 6) return;
        if(opcaoFerragem < 1 || opcaoFerragem > 5) {
            System.out.println("Opção inválida!");
            return;
        }
        
        // Menu de cores para ferragens
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

        if(opcaoCorFerragem == 6) return;
        if(opcaoCorFerragem < 1 || opcaoCorFerragem > 5) {
            System.out.println("Opção inválida!");
            return;
        }
        
        // Menu de metais para ferragens
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

        if(opcaoMetal == 6) return;
        if(opcaoMetal < 1 || opcaoMetal > 5) {
            System.out.println("Opção inválida!");
            return;
        }
        
        // Quantidade de unidades
        System.out.print("\nQuantidade de unidades: ");
        int quantidade = sc.nextInt();
        sc.nextLine();
        
        if(quantidade <= 0) {
            System.out.println("Quantidade inválida!");
            return;
        }
        
        // Adiciona ao carrinho (ferragens estão a partir do índice 7 no gerenciador)
        Produto produtoSelecionado = gerenciadorProdutos.getProdutoByIndex(opcaoFerragem+6);
        if(produtoSelecionado != null) {
            String corSelecionada = getCorFerragemByIndex(opcaoCorFerragem-1);
            String metalSelecionado = getMetalByIndex(opcaoMetal-1);
            carrinho.add(new ItemPedido(produtoSelecionado, quantidade, corSelecionada, metalSelecionado));
            
            System.out.println("\n=== ITEM ADICIONADO ===");
            System.out.println("Produto: " + produtoSelecionado.getNome());
            System.out.println("Cor: " + corSelecionada);
            System.out.println("Metal: " + metalSelecionado);
            System.out.println("Quantidade: " + quantidade);
            System.out.printf("Subtotal: R$%.2f\n", produtoSelecionado.calcularPreco() * quantidade);
        }
    }
    
    private void finalizarPedido(GerenciadorClientes gerenciadorClientes) {
        exibirResumoPedido();
        
        System.out.println("\n=== SELECIONE O CLIENTE ===");
        Cliente cliente = gerenciadorClientes.selecionarCliente();
        if (cliente == null) {
            System.out.println("Operação cancelada.");
            carrinho.clear();
            return;
        }
        
        Pedido novoPedido = new Pedido(pedidos.size() + 1, cliente);
        
        for (ItemPedido item : carrinho) {
            Src.Entidades.Classes_Cadastro_Madeireira.ItemPedido itemReal = 
                new Src.Entidades.Classes_Cadastro_Madeireira.ItemPedido(
                    item.getProduto(), 
                    item.getQuantidade()
                );
            novoPedido.adicionarItem(itemReal);
        }
        
        novoPedido.finalizarPedido();
        pedidos.add(novoPedido);
        carrinho.clear();
        
        System.out.println("\nPedido #" + novoPedido.getNumero() + " registrado para:");
        System.out.println(cliente.getTipo() == Cliente.TipoCliente.PF ? 
                         "CPF: " + cliente.getDocumentoFormatado() :
                         "CNPJ: " + cliente.getDocumentoFormatado());
    }

    private void exibirResumoPedido() {
        System.out.println("\n=== RESUMO DO PEDIDO ===");
        System.out.println("+--------+---------------------+------------+------------+----------+-----------+");
        System.out.println("| Código | Produto             | Cor        | Metal      | Quant.   | Subtotal  |");
        System.out.println("+--------+---------------------+------------+------------+----------+-----------+");
        
        double valorTotal = 0;
        for(ItemPedido item : carrinho) {
            Produto p = item.getProduto();
            double subtotal = item.getSubtotal();
            valorTotal += subtotal;
            
            System.out.printf("| %6d | %-19s | %-10s | %-10s | %8d | R$%7.2f |\n",
                p.getID(),
                p.getNome(),
                item.getCorSelecionada(),
                item.getMetalSelecionado() != null ? item.getMetalSelecionado() : "-",
                item.getQuantidade(),
                subtotal);
        }
        
        System.out.println("+--------+---------------------+------------+------------+----------+-----------+");
        System.out.printf("| TOTAL: | %53s | R$%7.2f |\n", "", valorTotal);
        System.out.println("+--------+---------------------+------------+------------+----------+-----------+");
    }

    // Métodos auxiliares para obter cores e metais
    private String getCorMadeiraByIndex(int index) {
        String[] cores = {"cobalto", "branco", "basalto-cinza", "amadeirado", "preto", "rosê", "avermelhado"};
        return cores[index];
    }
    
    private String getCorFerragemByIndex(int index) {
        String[] cores = {"prata", "dourado", "preto", "prata", "cinza"};
        return cores[index];
    }
    
    private String getMetalByIndex(int index) {
        String[] metais = {"Aço", "Ferro", "Alumínio", "Latão", "Aço Inox"};
        return metais[index];
    }

    public void cancelarPedido() {
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

        System.out.println("\n=== PEDIDOS PARA CANCELAMENTO ===");
        for (Pedido pedido : pedidosAtivos) {
            System.out.println("Nº " + pedido.getNumero() + " - " + pedido.getNomeCliente() + 
                             " - R$" + pedido.getValorTotal() + " - " + pedido.getStatus());
        }

        System.out.print("\nDigite o número do pedido a cancelar (ou 0 para voltar): ");
        int numeroPedido = sc.nextInt();
        sc.nextLine();

        if (numeroPedido == 0) return;

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
    
    public void listarPedidos() {
        System.out.println("\n=== LISTA DE PEDIDOS ===");
        boolean encontrados = false;
        
        for (Pedido pedido : pedidos) {
            if (!pedido.getStatus().toString().equals("CANCELADO")) {
                System.out.println(pedido.toString());
                System.out.println("Itens do pedido:");
                for (Src.Entidades.Classes_Cadastro_Madeireira.ItemPedido item : pedido.getItens()) {
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
}



//lógica: printar lista - opções de vender escolhendo cor, tipo de madeira, mostrar valores e pedir cadastro. se não houver cadastro, ele cria cadastro.

/*scanner = new Scanner(System.in);
import java.util.Scanner;


system.out.println("escolha qual madeira deseja:"); /// chamar a funçao de madeiras
    System.out.println("1 - Jatobá");
    System.out.println("2 - Ipê");
    System.out.println("3 - Cerejeira");
    System.out.println("4 - Massaranduba");
    System.out.println("5 - MDF");
    System.out.println("6 - MDF Naval");
    System.out.println("7 - Pinho");
    System.out.println("8 - Sair");
    System.out.println("9 - Voltar");
    sc.nextInt();
    sc.nextLine();
    system.out.println("escolha qual cor deseja:"); /// chamar a funçao de cores
    System.out.println("1 - cobalto");
    System.out.println("2 - branco");
    System.out.println("3 - basalto-cinza");
    System.out.println("4 - amadeirado");
    System.out.println("5 - preto");
    System.out.println("6 - rosê");
    System.out.println("7 - naosei");
    System.out.println("8 - Sair");
    System.out.println("9 - Voltar");
    sc.nextInt();
    sc.nextLine();
    system.out.println("quantidade de chapas:"); ///
    sc.nextInt();
    sc.nextLine();
    calculo do valor = preco * quantidade de chapas
    system.out.println = "deseja mais algum produto?" /// com opçao de fazer mais um pedido se der
    ou criar um looping while com novo menu. oq for mais facil
    system.out.println = printar a opção escolhida,a cor, a quantidade e o valor total ao lado de valor
    se possivel, mandar pra pra classe pedido ou item pedido.
    fim de nota, mostrar pedidos numerados por id e vender.
    



 */