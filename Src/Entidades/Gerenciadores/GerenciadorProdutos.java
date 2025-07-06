package Src.Entidades.Gerenciadores;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Src.Entidades.Classes_Cadastro_Madeireira.Ferragem;
import Src.Entidades.Classes_Cadastro_Madeireira.Madeira;
import Src.Entidades.Classes_Cadastro_Madeireira.Produto;

public class GerenciadorProdutos {
    private List<Produto> produtos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    //cria uma lista

    public GerenciadorProdutos(){

    }//construtor
    public void iniciarLista() {        
        String[] nomesMadeira = {"Jatobá", "Ipê", "Cerejeira", "Massaranduba", "MDF", "MDF Naval", "Pinho"};
        String[] coresMadeira = {"cobalto","branco","basalto-cinza","amadeirado","preto","rosê", "avermelhado"};
        Double[] precosMadeira = {1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00};
        
        String[] nomesFerragem = {"Parafuso 5mm", "Prego 3mm", "Dobradiça", "Fechadura", "Haste Metálica"};
        String[] coresFerragem = {"prata", "dourado", "preto", "prata", "cinza"};
        String[] metais = {"Aço", "Ferro", "Alumínio", "Latão", "Aço Inox"};
        Double[] precosFerragem = {0.5, 0.3, 2.5, 8.0, 4.0};

        // Adiciona madeiras
        for (int i = 0; i < nomesMadeira.length; i++) {
            produtos.add(new Madeira(i+1, nomesMadeira[i], coresMadeira[i], precosMadeira[i]));
        }
        
        // Adiciona ferragens (começando do ID 8)
        for (int i = 0; i < nomesFerragem.length; i++) {
            produtos.add(new Ferragem(
                nomesMadeira.length + i + 1,
                nomesFerragem[i],
                coresFerragem[i],
                precosFerragem[i],
                metais[i]
            ));
        }
    }

    public void listarProdutos() {
        System.out.println("\n=== LISTA DE PRODUTOS ===");
        System.out.println("+-----+---------------------+-----------------+------------+");
        System.out.println("| ID  | Nome                | Cor             | Preço      |");
        System.out.println("+-----+---------------------+-----------------+------------+");
        
        for (Produto produto : produtos) {
            String nomeExibicao = produto.getNome();
            if (nomeExibicao.length() > 18) {
                nomeExibicao = nomeExibicao.substring(0, 15) + "...";
            }
            
            System.out.printf("| %-3d | %-19s | %-15s | R$%8.2f |\n",
                produto.getID(),
                nomeExibicao,
                produto.getCor(),
                produto.calcularPreco()); // Mostra o preço calculado
        }
        
        System.out.println("+-----+---------------------+-----------------+------------+");
    }

    public void adicionarProdutos() {
        System.out.println("\n=== TIPO DE PRODUTO ===");
        System.out.println("1 - Madeira");
        System.out.println("2 - Ferragem");
        System.out.print("Opção: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("\nDigite os dados do novo produto:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Cor: ");
        String cor = scanner.nextLine();
        
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        int novoId = produtos.isEmpty() ? 1 : produtos.get(produtos.size() - 1).getID() + 1;
        Produto novoProduto;
        
        if (tipo == 2) {
            System.out.print("Tipo de Metal: ");
            String metal = scanner.nextLine();
            novoProduto = new Ferragem(novoId, nome, cor, preco, metal);
        } else {
            novoProduto = new Madeira(novoId, nome, cor, preco);
        }
        
        produtos.add(novoProduto);
        System.out.println("Produto adicionado com sucesso!");
    }

    public void alterarProdutos() {
        listarProdutos();
    System.out.print("\nDigite o ID do produto a alterar: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    for (Produto produto : produtos) {
        if (produto.getID() == id) {
            System.out.print("Novo nome (" + produto.getNome() + "): ");
            String novoNome = scanner.nextLine();
            
            System.out.print("Nova cor (" + produto.getCor() + "): ");
            String novaCor = scanner.nextLine();
            
            System.out.print("Novo preço (" + produto.getPreco() + "): ");
            double novoPreco = scanner.nextDouble();
            scanner.nextLine();
            

            
            produto.setNome(novoNome);
        
           
            produto.setCor(novaCor);
            
            produto.setPreco(novoPreco);
            
            System.out.println("Produto alterado com sucesso!");
            return;
        }
    }
    System.out.println("Produto não encontrado!");
}

   public void retirarProdutos() {
    listarProdutos(); // Exibe a lista antes da remoção

    System.out.print("\nDigite o ID do produto a remover: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    Produto produto = getById(id);
    if (produto == null) {
        System.out.println("Produto não encontrado!");
    } else {
        produtos.remove(produto);
        System.out.println("Produto removido com sucesso!");
    }
}

    public void buscarProduto() {
        System.out.print("\nDigite o termo de busca (nome ou cor): ");
        String termo = scanner.nextLine();
        
        System.out.println("\n=== RESULTADOS DA BUSCA ===");
        System.out.println("+-----+-----------------+-----------------+---------+");
        System.out.println("| ID  | Nome            | Cor             | Preço   |");
        System.out.println("+-----+-----------------+-----------------+---------+");
        
        boolean encontrado = false;
        for (Produto p : produtos) {
            if (p.getNome().toLowerCase().contains(termo.toLowerCase()) || 
                p.getCor().toLowerCase().contains(termo.toLowerCase())) {
                System.out.printf("| %3d | %-15s | %-15s | R$%5.2f |\n",
                    p.getID(), p.getNome(), p.getCor(), p.getPreco());
                encontrado = true;
            }
        }
        
        System.out.println("+-----+-----------------+-----------------+---------+");
        if (!encontrado) {
            System.out.println("Nenhum produto encontrado com: " + termo);
        }
    }

    public void ordenarProdutos() {
        System.out.println("\nOrdenar por:");
        System.out.println("1 - Nome (A-Z)");
        System.out.println("2 - Preço Final (Menor-Maior)");
        System.out.println("3 - ID (Ordem Original)");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        switch(opcao) {
            case 1:
                Collections.sort(produtos, (p1, p2) -> p1.getNome().compareToIgnoreCase(p2.getNome()));
                break;
            case 2:
                Collections.sort(produtos); // Usa o compareTo de Produto
                break;
            case 3:
                Collections.sort(produtos, (p1, p2) -> Integer.compare(p1.getID(), p2.getID()));
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        
        System.out.println("Produtos ordenados com sucesso!");
        listarProdutos();
    }
private Produto getById(int id) {
    for (Produto p : produtos) {
        if (p.getID() == id) {
            return p;
        }
    }
    return null;
}
public Produto getProdutoByIndex(int index) {
    if(index >= 0 && index < produtos.size()) {
        return produtos.get(index);
    }
    return null;
}
}


