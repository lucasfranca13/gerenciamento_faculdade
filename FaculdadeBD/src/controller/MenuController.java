package controller;

import view.MenuView;

import java.util.Scanner;

public class MenuController {

    public static void show() {
        Scanner scan = new Scanner(System.in);
        String opcao;
        int opcaoValidada;
        do {
            MenuView.print();
            opcao = scan.nextLine();
            opcaoValidada = valaidaSeUsuarioEscolheuAlgumaOpcao(opcao);
            switch (opcaoValidada) {
                case 1 -> SubMenuController.show("Aluno");
                case 2 -> SubMenuController.show("Curso");
                case 3 -> SubMenuController.show("Disciplina");
                default -> usuarioEcolheuUmaOpcaoQueNaoExiste(opcaoValidada);
            }

        } while (opcaoValidada < 4);

    }
    public static int valaidaSeUsuarioEscolheuAlgumaOpcao(String opcao) {
        if(opcao.isEmpty()){
            System.out.println("Digite algum valor para navegar no menu!");
            show();
        }
        return Integer.parseInt(opcao);
    }

    public static void usuarioEcolheuUmaOpcaoQueNaoExiste(int opcao){
        if(opcao != 4){
            System.out.println("Não temos essa opção em nosso menu");
            show();
        }
    }

}
