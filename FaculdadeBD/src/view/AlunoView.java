package view;

import controller.MenuController;
import controller.SubMenuController;
import model.Aluno;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class AlunoView {

    public static void Criar(Aluno aluno) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scan.nextLine();
        validaNomeAluno(nome, aluno);

        System.out.print("Idade: ");
        String idade = scan.nextLine();
        validaIdadeAluno(idade, aluno);

        System.out.print("Matricula: ");
        String matricula = scan.nextLine();
        validaMatriculaAluno(matricula, aluno);

    }

    public static void Atualizar(Aluno aluno) {
        Scanner scan = new Scanner(System.in);

        System.out.print("("+ aluno.getNome() + ") - Nome: ");
        String nome = scan.nextLine();
        validaNomeAluno(nome, aluno);

        System.out.print("("+ aluno.getIdade() + ") - Idade: ");
        String idade = scan.nextLine();
        validaIdadeAluno(idade, aluno);

    }

    public static void Listar(List<Aluno> alunos) {
        for(Aluno a : alunos) {
            Consultar(a);
        }
    }

    public static void Consultar(Aluno aluno) {
        System.out.println("Matricula: " + aluno.getMatricula());
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Idade: " + aluno.getIdade());
        System.out.println();
    }

    public static String GetMatricula() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe sua matricula: ");
        String matricula = scan.nextLine();
        if(matricula.isEmpty()){
            System.out.println("Digite algum valor para matricula!");
            SubMenuController.show("Aluno");
        }
        return matricula;
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

    public static void validaNomeAluno(String nome, Aluno aluno){
        if (!nome.isEmpty()) {
            aluno.setNome(nome);
        }
        else {
            System.out.println("Digite algum valor para nome!");
            SubMenuController.show("Aluno");
        }
    }

    public static void validaMatriculaAluno(String matricula, Aluno aluno){
        if (!matricula.isEmpty()) {
            aluno.setMatricula(matricula);
        }
        else {
            System.out.println("Digite algum valor para matricula!");
            SubMenuController.show("Aluno");
        }
    }

    public static void validaIdadeAluno(String idade, Aluno aluno){
        if (!idade.isEmpty()) {
            int idadeValidada = validaValorIdade(idade);
            aluno.setIdade(idadeValidada);
        }
        else {
            System.out.println("Digite algum valor para idade!");
            SubMenuController.show("Aluno");
        }
    }
}
