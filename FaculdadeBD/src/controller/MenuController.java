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
            usuarioEcolheuUmaOpcaoQueNaoExiste(opcao);
            opcaoValidada = valaidaSeUsuarioEscolheuAlgumaOpcao(opcao);
            switch (opcaoValidada) {
                case 1 -> SubMenuController.show("Aluno");
                case 2 -> SubMenuController.show("Curso");
                case 3 -> SubMenuController.show("Disciplina");
                case 4 -> System.out.println("Saindo...");
                default -> validaOpcao();
            }

        } while (opcaoValidada < 4);

    }

    public static int valaidaSeUsuarioEscolheuAlgumaOpcao(String opcao) {
        if (opcao.isEmpty()) {
            System.out.println("Digite algum valor para navegar no menu!");
            show();
        }
        return Integer.parseInt(opcao);
    }

    public static void usuarioEcolheuUmaOpcaoQueNaoExiste(String opcaoValidada) {
        try {
            Integer.parseInt(opcaoValidada);
        } catch (NumberFormatException e) {
            System.out.println("Não temos essa opção em nosso menu");
            show();
        }
    }

    public static void validaOpcao() {
        System.out.println("Opcao invalida");
        show();

    }


}
