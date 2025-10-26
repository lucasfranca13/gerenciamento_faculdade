package view;

import controller.SubMenuController;
import model.Curso;
import model.Disciplina;

import java.util.List;
import java.util.Scanner;

public class DisciplinaView {

    public static void Criar(Disciplina disciplina) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Código disciplina: ");
        disciplina.setCodigoDisciplina(scan.nextLine());

        System.out.print("Nome: ");
        disciplina.setNome(scan.nextLine());

        System.out.print("Carga: ");
        disciplina.setCarga(scan.nextInt()); scan.nextLine();

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
    public static void Atualizar(Disciplina disciplina) {
        Scanner scan = new Scanner(System.in);

        System.out.print("("+ disciplina.getNome() + ") - Nome: ");
        String nome = scan.nextLine();
        validaNomeAluno(nome, disciplina);
        disciplina.setNome(nome);

        System.out.print("("+ disciplina.getCarga() + ") - Carga: ");
        int carga = scan.nextInt(); scan.nextLine();
        disciplina.setCarga(carga);

    }

    public static void validaNomeAluno(String nome, Disciplina disciplina){
        if (!nome.isEmpty()) {
            disciplina.setNome(nome);
        }
        else {
            System.out.print("Digite algum valor para nome!");
            SubMenuController.show("Disciplina");
        }
    }

    public static void validaIdadeAluno(String carga, Disciplina disciplina){
        if (!carga.isEmpty()) {
            int idadeValidada = validaValorIdade(carga);
            disciplina.setCarga(idadeValidada);
        }
        else {
            System.out.print("Digite algum valor para carga!");
            SubMenuController.show("Disciplina");
        }
    }

 /*   public static void Listar(List<Disciplina> disciplinas) {
        for(Disciplina a : disciplinas) {
            Consultar(a);
        }
    }*/

    public static void Consultar(Disciplina disciplina) {
        System.out.println("Código Disciplina: " + disciplina.getCodigoDisciplina());
        System.out.println("Nome: " + disciplina.getNome());
        System.out.println("Carga: " + disciplina.getCarga());
        System.out.println();
    }

    public static String GetCodDisciplina() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe sua o código da disciplina: ");
        String codDisciplina = scan.next();
        return codDisciplina;
    }

    public static void ConsultarAll(List<Disciplina> disciplinas) {

        for (Disciplina item : disciplinas){
            System.out.println("Código Disciplinas: " + item.getCodigoDisciplina());
            System.out.println("Nome: " + item.getNome());
            System.out.println("Carga: " + item.getCarga());
            System.out.println();
        }
    }

}
