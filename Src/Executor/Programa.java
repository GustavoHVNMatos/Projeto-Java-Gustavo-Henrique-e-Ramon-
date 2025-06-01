package Src.Executor;
import java.util.Scanner;
import Src.Entidades.Gerenciadores.GerenciadorProdutos;


public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorProdutos gerenciador = new GerenciadorProdutos();
        gerenciador.iniciarLista();
        
       int Menu;
        do{
        //menu interativo funcionando, ligado ao gerenciadorprodutos e ao produtos classes dai do lado
        System.out.println("Selecione o número correspondente ao que deseja!");
        System.out.println("1 - Listar Produtos Disponíveis");
        System.out.println("2 - Adicionar Produtos");
        System.out.println("3 - Alterar Produtos");
        System.out.println("4 - Retirar Produto");
        System.out.println("0 - Sair");
        Menu = sc.nextInt();
        sc.nextLine();
        switch (Menu){
        case 1:
            gerenciador.listarProdutos(); //isso aqui ta chamando funçao da lista la no produto
            break;
        case 2:
            gerenciador.adicionarProdutos();// é o primeira coisa a se fazer antes de descomentaro case 3
            break;
            //quem for mexer nisso, preciso que faça essa funçao ser chamada no gerenciadorprodutos
            //puxe a arraylist de tipos de madeira, nome no caso pra ser adicionada.
        /*case 3: esse case antes de descomentar, tem q puxar as 3 arrays,e poder mudar uma delas, seja valor cor ou tipo d madeira
            gerenciador.alterarProdutos();
            break;
        case 4: e esse aqui ta intuitivo né
            gerenciador.retirarProdutos();
            break;*/
        case 0:
            break;
        }
        }while (Menu != 0);
        
    }
    
}


 /*ordem de venda - 
    1 - menu
    3 - gerenciar produtos nisso vai pra listagem de tipos de madeiras disponiveis. / eucalipto,jatobá,ipê, peroba-rosa,cerejeira, pinho, massaranduba
    4 - na seleção disso, vai pra fornecedores que tem esse tipo disponivel
    5 - depois disso vai pras cores que tem disponivel dessa madeira já com valores e a quantidade
    6 - depois de selecionar, vai pro cadastro de clientesCNPJ, se nao tiver, cadastra novo
    7 - depois disso vai pra aba de pedidos a serem entregues com id do pedido (4 a 6 digitos)
    8 - depois de finalizado, volta pro menu.
  */