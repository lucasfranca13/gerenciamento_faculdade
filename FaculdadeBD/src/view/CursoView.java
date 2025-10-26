package view;

import model.Aluno;
import model.Curso;

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
        String nome = scan.next();
        if (!nome.isEmpty()) { curso.setNomeCurso(nome); }

        System.out.print("("+ curso.getTurno() + ") - Turno: ");
        String turno = scan.nextLine();
        if (!turno.isEmpty()) { curso.setTurno(turno); }

    }

    // listar cursos (a fazer)

    public static void Consultar(Curso curso) {
        System.out.println("Código Curso: " + curso.getCodigoCurso());
        System.out.println("Nome: " + curso.getNomeCurso());
        System.out.println("Turno: " + curso.getTurno());
        System.out.println();
    }


    public static Integer GetCurso() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o código: ");
        Integer codigo = scan.nextInt();
        return codigo;
    }

}
