package Src.Executor;
import java.util.Scanner;
import Src.Entidades.Gerenciadores.GerenciadorProdutos;


public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorProdutos gerenciador = new GerenciadorProdutos();
       
       int Menu;
        do{
        
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
            break;
        }
        }while (Menu != 0);

    }
    
}
 /*plano mental meu consagrado gugs. cadastrar um estoque de chapas de madeira com cores marcas diferentes, cada marca com suas cores diferentes
  um sistema de pedidos dos clientes, pra sair a nota e ser pago no caixa. pedido inclui valor de chapa inteira e meia chapa.
  um cadastro obvio nesse estoque pra fitas de borda das cores e marcas apresentadas pra caso cliente queira comprar fitada ou nao
  listar todos esses itens pra apresentar ao cliente, e poder buscar o tipo de marca e cor das peças pras saber se ainda tem e so dar baixa na compra
  listar registros é fogo mas a gente da um jeito. da pra ordenar por ID numerado em ordem crescente. é o jeito mais facil
  fazer um menu com incluir alterar excluir listar e sair , basico de todo programa
  quando iniciar a gente deixa pronto ja imbutido 7 objetos de cada classe
  uma matriz pra alguma coisa, a gente ve isso ai
  deixar tudo comentado!
 */


 /*ordem de venda - 
    1 - menu
    3 - gerenciar produtos nisso vai pra listagem de tipos de madeiras disponiveis. / eucalipto,jatobá,ipê, peroba-rosa,cerejeira, pinho, massaranduba
    4 - na seleção disso, vai pra fornecedores que tem esse tipo disponivel
    5 - depois disso vai pras cores que tem disponivel dessa madeira já com valores e a quantidade
    6 - depois de selecionar, vai pro cadastro de clientesCNPJ, se nao tiver, cadastra novo
    7 - depois disso vai pra aba de pedidos a serem entregues com id do pedido (4 a 6 digitos)
    8 - depois de finalizado, volta pro menu.
  */