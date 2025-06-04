package Src.Executor;
import java.util.Scanner;

import Src.Entidades.Gerenciadores.GerenciadorPedidos;
import Src.Entidades.Gerenciadores.GerenciadorProdutos;


public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciadorProdutos gerenciadorProdutos = new GerenciadorProdutos();
        GerenciadorPedidos gerenciadorPedidos = new GerenciadorPedidos();
        gerenciadorProdutos.iniciarLista();
        
       int Menu;
        do{
        //menu interativo funcionando, ligado ao gerenciadorprodutos e ao produtos classes dai do lado
        System.out.println("Selecione o número correspondente ao que deseja!");
        System.out.println("1 - Listar Produtos Disponíveis");
        System.out.println("2 - Adicionar Produtos");
        System.out.println("3 - Alterar Produtos");
        System.out.println("4 - Retirar Produtos");
        System.out.println("5 - Efetuar Pedido");
        System.out.println("0 - Sair");
        Menu = sc.nextInt();
        sc.nextLine();
        switch (Menu){
        case 1:
           gerenciadorProdutos.listarProdutos();
           break;
        case 2:
            gerenciadorProdutos.adicionarProdutos();
            break;
        case 3:
            gerenciadorProdutos.alterarProdutos();
            break;
        case 4:
            gerenciadorProdutos.retirarProdutos();
            break;
        case 5:
            gerenciadorPedidos.efetuarPedido(gerenciadorProdutos);
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
