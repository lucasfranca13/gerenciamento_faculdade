package controller;

import view.MenuView;
import view.SubMenuView;

import java.util.Scanner;

public class SubMenuController {

    public static void show(String value) {
        Scanner scan = new Scanner(System.in);
        String opcao;
        int opcaoValidada;
        do {
            SubMenuView.print(value);
            opcao = scan.nextLine();
            opcaoValidada = MenuController.valaidaSeUsuarioEscolheuAlgumaOpcao(opcao);
            if (value.equals("Aluno")) {
                switch (opcaoValidada) {
                    case 1 -> AlunoController.Criar();
                    case 2 -> AlunoController.Consultar();
                    case 3 -> AlunoController.Listar();
                    case 4 -> AlunoController.Atualizar();
                    case 5 -> AlunoController.Deletar();
                    case 6 -> MenuController.show();
                    default -> System.out.println("\nInsira um valor válido!\n");
                }
            }
            if (value.equals("Curso")) {
                switch (opcaoValidada) {
                        case 1 -> CursoController.Criar();
                        case 2 -> CursoController.Consultar();
                        case 3 -> CursoController.ListarCursoAll();
                        case 4 -> CursoController.Atualizar();
                        case 5 -> CursoController.Deletar();
                        case 6 -> MenuController.show();
                        default -> System.out.println("\nInsira um valor válido!\n");
                }
            }
            if (value.equals("Disciplina")) {
                switch (opcaoValidada) {
                    case 1 -> DisciplinaController.Criar();
                    case 2 -> DisciplinaController.Consultar();
                    case 3 -> DisciplinaController.ListarDisciplinasAll();
                    case 4 -> DisciplinaController.Atualizar();
                    case 5 -> DisciplinaController.Deletar();
                    case 6 -> MenuController.show();
                    default -> System.out.println("\nInsira um valor válido!\n");
                }
            }

        } while (opcaoValidada < 5);
    }

}
