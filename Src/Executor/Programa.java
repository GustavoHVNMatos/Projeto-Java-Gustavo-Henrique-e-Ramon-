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
        case 0:
            System.out.println("Saindo do sistema...");
            break;
        default:
            System.out.println("Opção inválida!");
        }
        }while (Menu != 0);
        sc.close();
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