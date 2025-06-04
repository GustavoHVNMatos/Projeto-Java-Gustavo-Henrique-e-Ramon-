package Src.Entidades.Gerenciadores;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Src.Entidades.Classes_Cadastro_Madeireira.Madeira;
import Src.Entidades.Classes_Cadastro_Madeireira.Produto;

public class GerenciadorProdutos {
    private List<Produto> produtos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    //cria uma lista

    public GerenciadorProdutos(){

    }//construtor
    public void iniciarLista(){        
        String[] nomes = {"Jatobá", "Ipê", "Cerejeira", "Massaranduba", "MDF", "MDF Naval", "Pinho"};
        String[] cores = {"cobalto","branco","basalto-cinza","amadeirado","preto","rosê", "naosei"};
        Double[] precos = {1.00,2.00,3.00,4.00,5.00,6.00,7.00};
        //o iniciador de vetores com o tipo de madeira cor e preco
        for (int i = 0; i < nomes.length; i++) {
            Madeira madeira = new Madeira(i+1, nomes[i], cores[i], precos[i]);
            produtos.add(madeira);
            //nome, cor, preco
        }
        }

       public void listarProdutos() {
        System.out.println("Lista de Produtos Cadastrados:");
        for (Produto produto : produtos) {
            System.out.println("- " + produto.toString());
        }
    
            //printa a lista apenas
    }
   
    public void adicionarProdutos() {
        System.out.println("\nDigite os dados do novo produto:");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Cor: ");
        String cor = scanner.nextLine();
        
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        int novoId;
            if (produtos.size() == 0) {
             novoId = 1;
            } else {
                novoId = produtos.get(produtos.size() - 1).getID() + 1;
            }
        Produto novoProduto = new Madeira(novoId, nome, cor, preco);
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

    /*private Produto buscarPorID(int id) {
        for (Produto p : produtos) {
            if (p.getID() == id) {
                return p;
            }
        }
        return null;
    } */
}


