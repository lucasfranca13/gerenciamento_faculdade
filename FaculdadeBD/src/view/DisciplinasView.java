package view;

import controller.SubMenuController;
import model.Disciplinas;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class DisciplinasView {

    public static void Criar(Disciplinas disciplinas) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Nome: ");
        disciplinas.setNome(scan.next());

        System.out.print("Carga: ");
        disciplinas.setCarga(scan.nextInt());

        System.out.print("Código disciplinas: ");
        disciplinas.setCodigoDisciplina(scan.next());

    }
    public static int validaValorIdade(String idade) {
        try  {
            Integer.parseInt(idade);
        } catch (NumberFormatException e) {
            System.out.println("A idade não pode conter letras ou caracteres especiais");
            SubMenuController.show("Aluno");
        }
        return Integer.parseInt(idade);
    };
    public static void Atualizar(Disciplinas disciplinas) {
        Scanner scan = new Scanner(System.in);

        System.out.print("("+ disciplinas.getNome() + ") - Nome: ");
        String nome = scan.next();
        validaNomeAluno(nome, disciplinas);

        System.out.print("("+ disciplinas.getCarga() + ") - Carga: ");
        String carga = scan.next();
        validaValorIdade(carga);
        validaIdadeAluno(carga, disciplinas);

    }

    public static void validaNomeAluno(String nome, Disciplinas disciplinas){
        if (!nome.isEmpty()) {
            disciplinas.setNome(nome);
        }
        else {
            System.out.print("Digite algum valor para nome!");
            SubMenuController.show("Disciplina");
        }
    }

    public static void validaIdadeAluno(String carga, Disciplinas disciplinas){
        if (!carga.isEmpty()) {
            int idadeValidada = validaValorIdade(carga);
            disciplinas.setCarga(idadeValidada);
        }
        else {
            System.out.print("Digite algum valor para carga!");
            SubMenuController.show("Disciplina");
        }
    }

    public static void Listar(List<Disciplinas> disciplinas) {
        for(Disciplinas a : disciplinas) {
            Consultar(a);
        }
    }

    public static void Consultar(Disciplinas disciplinas) {
        System.out.println("Disciplina: " + disciplinas.getCodigoDisciplina());
        System.out.println("Nome: " + disciplinas.getNome());
        System.out.println("Idade: " + disciplinas.getCarga());
        System.out.println();
    }

    public static String GetMatricula() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe sua o código da disciplina: ");
        String matricula = scan.next();
        return matricula;
    }

}
