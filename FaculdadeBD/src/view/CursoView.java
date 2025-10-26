package view;

import controller.SubMenuController;
import model.Aluno;
import model.Curso;

import java.util.List;
import java.util.Scanner;

public class CursoView {

    public static void Criar(Curso curso) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Codigo: ");
        String codigoCurso = scan.nextLine();
        validaCodigoCurso(codigoCurso, curso);

        System.out.print("Nome: ");
        String nome = scan.nextLine();
        validaNomeCurso(nome, curso);

        System.out.print("Turno: ");
        String turno = scan.nextLine();
        validaTurnoCurso(turno, curso);
    }

    public static void Atualizar(Curso curso) {
        Scanner scan = new Scanner(System.in);

        System.out.print("("+ curso.getNomeCurso() + ") - Nome: ");
        String nome = scan.nextLine();
        validaNomeCurso(nome, curso);

        System.out.print("("+ curso.getTurno() + ") - Turno: ");
        String turno = scan.nextLine();
        validaTurnoCurso(turno, curso);
    }

    // listar cursos

    public static void ConsultarAll(List<Curso> curso) {

        for (Curso item : curso){
            System.out.println("Código Curso: " + item.getCodigoCurso());
            System.out.println("Nome: " + item.getNomeCurso());
            System.out.println("Turno: " + item.getTurno());
            System.out.println();
        }
    }

    public static void Consultar(Curso curso) {
        System.out.println("Código Curso: " + curso.getCodigoCurso());
        System.out.println("Nome: " + curso.getNomeCurso());
        System.out.println("Turno: " + curso.getTurno());
        System.out.println();
    }

    public static String GetCurso() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe o código: ");
        String codigo = scan.nextLine();
        if(codigo.isEmpty()){
            System.out.println("Digite algum valor para código!");
            SubMenuController.show("Curso");
        }
        return codigo;
    }

    public static void validaNomeCurso(String nome, Curso curso){
        if (!nome.isEmpty()) {
            curso.setNomeCurso(nome);
        }
        else {
            System.out.println("Digite algum valor para nome!");
            SubMenuController.show("Curso");
        }
    }

    public static void validaCodigoCurso(String codigo, Curso curso){
        if (!codigo.isEmpty()) {
            curso.setCodigoCurso(codigo);
        }
        else {
            System.out.println("Digite algum valor para codigo!");
            SubMenuController.show("Curso");
        }
    }

    public static void validaTurnoCurso(String turno, Curso curso){
        if (!turno.isEmpty()) {
            curso.setTurno(turno);
        }
        else {
            System.out.println("Digite algum valor para turno!");
            SubMenuController.show("Curso");
        }
    }

}
