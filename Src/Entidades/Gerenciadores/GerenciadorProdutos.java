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

    public GerenciadorProdutos() {}

    public void iniciarLista() {
        String[] nomesMadeira = {
            "Jatobá", "Ipê", "Cerejeira", "Massaranduba", 
            "MDF", "MDF Naval", "Pinho", "Eucalipto", "Cedro"
        };
        String[] coresMadeira = {
            "cobalto", "branco", "basalto-cinza", "amadeirado", 
            "preto", "rosê", "avermelhado", "natural", "envernizado"
        };
        Double[] precosMadeira = {1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00};
        
        String[] nomesFerragem = {
            "Parafuso 5mm", "Prego 3mm", "Dobradiça", "Fechadura", 
            "Haste Metálica", "Pregador", "Parafuso 10mm", "Arruela", "Porca"
        };
        String[] coresFerragem = {
            "prata", "dourado", "preto", "prata", 
            "cinza", "bronze", "cobre", "latão", "inox"
        };
        String[] metais = {
            "Aço", "Ferro", "Alumínio", "Latão", 
            "Aço Inox", "Bronze", "Cobre", "Metalon", "Zinco"
        };
        Double[] precosFerragem = {0.5, 0.3, 2.5, 8.0, 4.0, 3.5, 1.0, 0.8, 1.2};

        // Adiciona madeiras
        for (int i = 0; i < nomesMadeira.length; i++) {
            produtos.add(new Madeira(i + 1, nomesMadeira[i], coresMadeira[i], precosMadeira[i]));
        }
        
        // Adiciona ferragens (IDs a partir de 10)
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
                produto.calcularPreco());
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
        
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Cor: ");
        String cor = scanner.nextLine();
        
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        int novoId = produtos.get(produtos.size() - 1).getID() + 1;
        
        if (tipo == 2) {
            System.out.print("Tipo de Metal: ");
            String metal = scanner.nextLine();
            produtos.add(new Ferragem(novoId, nome, cor, preco, metal));
        } else {
            produtos.add(new Madeira(novoId, nome, cor, preco));
        }
        System.out.println("Produto adicionado!");
    }

    public void alterarProdutos() {
        listarProdutos();
        System.out.print("\nID do produto a alterar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getID() == id) {
                System.out.print("Novo nome (" + produto.getNome() + "): ");
                produto.setNome(scanner.nextLine());
                
                System.out.print("Nova cor (" + produto.getCor() + "): ");
                produto.setCor(scanner.nextLine());
                
                System.out.print("Novo preço (" + produto.getPreco() + "): ");
                produto.setPreco(scanner.nextDouble());
                scanner.nextLine();
                
                System.out.println("Produto atualizado!");
                return;
            }
        }
        System.out.println("ID não encontrado!");
    }

    public void retirarProdutos() {
        listarProdutos();
        System.out.print("\nID do produto a remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getID() == id) {
                produtos.remove(produto);
                System.out.println("Produto removido!");
                return;
            }
        }
        System.out.println("ID não encontrado!");
    }

    public void buscarProduto() {
        System.out.print("\nTermo de busca (nome/cor): ");
        String termo = scanner.nextLine().toLowerCase();
        
        System.out.println("\n=== RESULTADOS ===");
        boolean encontrado = false;
        
        for (Produto p : produtos) {
            if (p.getNome().toLowerCase().contains(termo) || p.getCor().toLowerCase().contains(termo)) {
                System.out.printf("ID: %d | Nome: %s | Cor: %s | Preço: R$%.2f\n",
                    p.getID(), p.getNome(), p.getCor(), p.calcularPreco());
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("Nenhum produto encontrado.");
        }
    }

    public void ordenarProdutos() {
        System.out.println("\nOrdenar por:");
        System.out.println("1 - Nome (A-Z)");
        System.out.println("2 - Preço (menor-maior)");
        System.out.println("3 - ID");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == 1) {
            Collections.sort(produtos, (p1, p2) -> p1.getNome().compareToIgnoreCase(p2.getNome()));
        } else if (opcao == 2) {
            Collections.sort(produtos);
        } else if (opcao == 3) {
            Collections.sort(produtos, (p1, p2) -> Integer.compare(p1.getID(), p2.getID()));
        } else {
            System.out.println("Opção inválida!");
            return;
        }
        System.out.println("Produtos ordenados!");
        listarProdutos();
    }

    public Produto getProdutoByIndex(int index) {
        if (index >= 0 && index < produtos.size()) {
            return produtos.get(index);
        }
        return null;
    }
}