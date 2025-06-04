package Src.Entidades.Gerenciadores;

import Src.Entidades.Classes_Cadastro_Madeireira.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorPedidos {
    private List<Produto> carrinho = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    
    public void efetuarPedido(GerenciadorProdutos gerenciadorProdutos) {
        int opcaoMadeira, opcaoCor, quantidade;
        double valorTotal = 0;
        boolean continuar = true;
        
        while(continuar) {
            // Menu de madeiras
            System.out.println("\nEscolha qual madeira deseja:");
            System.out.println("1 - Jatobá");
            System.out.println("2 - Ipê");
            System.out.println("3 - Cerejeira");
            System.out.println("4 - Massaranduba");
            System.out.println("5 - MDF");
            System.out.println("6 - MDF Naval");
            System.out.println("7 - Pinho");
            System.out.println("8 - Cancelar");
            System.out.print("Opção: ");
            opcaoMadeira = sc.nextInt();
            sc.nextLine();
            
            if(opcaoMadeira == 8) {
                carrinho.clear();
                return;
            }
            if(opcaoMadeira < 1 || opcaoMadeira > 7) {
                System.out.println("Opção inválida!");
                continue;
            }
            
            // Menu de cores
            System.out.println("\nEscolha qual cor deseja:");
            System.out.println("1 - cobalto");
            System.out.println("2 - branco");
            System.out.println("3 - basalto-cinza");
            System.out.println("4 - amadeirado");
            System.out.println("5 - preto");
            System.out.println("6 - rosê");
            System.out.println("7 - avermelhado");
            System.out.println("8 - Cancelar");
            System.out.print("Opção: ");
            opcaoCor = sc.nextInt();
            sc.nextLine();

            if(opcaoCor == 8) {
                carrinho.clear();
                return;
            }
            
            if(opcaoCor < 1 || opcaoCor > 7) {
                System.out.println("Opção inválida!");
                continue;
            }
            
            // Quantidade
            System.out.print("\nQuantidade de chapas: ");
            quantidade = sc.nextInt();
            sc.nextLine();
            
            // Busca o produto correspondente
            Produto produtoSelecionado = gerenciadorProdutos.getProdutoByIndex(opcaoMadeira-1);
            if(produtoSelecionado != null) {
                double valorItem = produtoSelecionado.getPreco() * quantidade;
                valorTotal += valorItem;
                
                System.out.println("\nItem adicionado:");
                System.out.println("Produto: " + produtoSelecionado.getNome());
                System.out.println("Cor: " + getCorByIndex(opcaoCor-1));
                System.out.println("Quantidade: " + quantidade);
                System.out.printf("Valor: R$%.2f\n", valorItem);
                
                carrinho.add(produtoSelecionado);
            }
            
            System.out.print("\nDeseja adicionar mais produtos? (S/N): ");
            String resposta = sc.nextLine();
            if(!resposta.equalsIgnoreCase("S")) {
                continuar = false;
            }
        }
        
        // Finalização do pedido
        if(carrinho.size() > 0) {
            System.out.println("\n=== RESUMO DO PEDIDO ===");
            for(Produto p : carrinho) {
                System.out.println(p.toString());
            }
            System.out.printf("\nVALOR TOTAL: R$%.2f\n", valorTotal);
            
           /* // Cadastro do cliente
            System.out.println("\n=== DADOS DO CLIENTE ===");
            System.out.print("Nome do cliente: ");
            String nomeCliente = sc.nextLine();
            System.out.print("CPF/CNPJ: ");
            String documento = sc.nextLine();
            */
            
            // Aqui você pode criar e armazenar o pedido
            System.out.println("\nPedido finalizado com sucesso!");
        }
    }
    
    private String getCorByIndex(int index) {
        String[] cores = {"cobalto", "branco", "basalto-cinza", "amadeirado", "preto", "rosê", "naosei"};
        return cores[index];
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