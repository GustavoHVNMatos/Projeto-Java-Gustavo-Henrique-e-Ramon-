package Src.Entidades.Gerenciadores;
import java.util.ArrayList;
import java.util.List;
import Src.Entidades.Classes_Cadastro_Madeireira.Produto;

public class GerenciadorProdutos {
    List<Produto> produtos = new ArrayList<>();



    public GerenciadorProdutos(){

    }
    public void iniciarLista(){        
        String[] nomes = {"Jatobá", "Ipê", "Cerejeira", "Massaranduba", "MDF", "MDF Naval", "Pinho"};
        String[] cores = {"cobalto","branco","basalto-cinza","amadeirado","preto","rosê", "naosei"};
        Double[] precos = {1.00,2.00,3.00,4.00,5.00,6.00,7.00};
        
        for (int i = 0; i < 7; i++){
            Produto produto = new Produto(i + 1, nomes[i], cores[i], precos[i]);
            produtos.add(produto);
            //nome, cor, preco
        }
        }

        public void listarProdutos(){
        System.out.println("Lista de Madeiras Cadastradas:");
        for (Produto p : produtos) {
            System.out.println("- " + p.toString());


        }
    
       
    }

}
