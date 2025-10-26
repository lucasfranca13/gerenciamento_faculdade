package view;

import model.Aluno;
import model.Curso;

import java.util.List;
import java.util.Scanner;

public class CursoView {

    public static void Criar(Curso curso) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Codigo: ");
        curso.setCodigoCurso(scan.nextInt()); scan.nextLine();

        System.out.print("Nome: ");
        curso.setNomeCurso(scan.nextLine());

        System.out.print("Turno: ");
        curso.setTurno(scan.nextLine());

    }

    public static void Atualizar(Curso curso) {
        Scanner scan = new Scanner(System.in);

        System.out.print("("+ curso.getNomeCurso() + ") - Nome: ");
        String nome = scan.nextLine();
        if (!nome.isEmpty()) { curso.setNomeCurso(nome); }

        System.out.print("("+ curso.getTurno() + ") - Turno: ");
        String turno = scan.nextLine();
        if (!turno.isEmpty()) { curso.setTurno(turno); }

    }

    // listar cursos (a fazer)

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


    public static Integer GetCurso() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe o código: ");
        int codigo = scan.nextInt(); scan.nextLine();
        return codigo;
    }

}
