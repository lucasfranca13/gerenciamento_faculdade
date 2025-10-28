package view;

import controller.MenuController;
import controller.SubMenuController;
import model.Aluno;
import dao.CursoDAO;
import model.Curso;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class AlunoView {

    public static void Criar(Aluno aluno) {
        Scanner scan = new Scanner(System.in);
        validaSeExisteCurso();
        mostraCursoExistente();

        System.out.print("Nome: ");
        String nome = scan.nextLine();
        validaNomeAluno(nome, aluno);

        System.out.print("Idade: ");
        String idade = scan.nextLine();
        validaIdadeAluno(idade, aluno);

        System.out.print("Matricula: ");
        String matricula = scan.nextLine();
        validaMatriculaAluno(matricula, aluno);

        System.out.print("Digite o códico do curso: ");
        String curso = scan.nextLine();
        validaCodigoDoCurso(curso, aluno);
        boolean existeEsseCurso = CursoDAO.existeEsseCodigo(curso);
        if(!existeEsseCurso){
            validaCursoAluno(curso, aluno);
        }
        else {
            System.out.println("O código desse curso não existe!");
            SubMenuController.show("Aluno");
        }

    }

    public static void Atualizar(Aluno aluno) {
        Scanner scan = new Scanner(System.in);

        mostraCursoExistente();

        System.out.print("("+ aluno.getNome() + ") - Nome: ");
        String nome = scan.nextLine();
        validaNomeAluno(nome, aluno);

        System.out.print("("+ aluno.getIdade() + ") - Idade: ");
        String idade = scan.nextLine();
        validaIdadeAluno(idade, aluno);

        System.out.print("("+ aluno.getIdCurso() + ") - Código do curso: ");
        String curso = scan.nextLine();
        validaCodigoDoCurso(curso, aluno);

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
        System.out.println("Código do curso: " + aluno.getIdCurso());
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

    public static void validaCursoAluno(String curso, Aluno aluno){
        if (!curso.isEmpty()) {
            Curso existeCurso = CursoDAO.Get(curso);
            if(!existeCurso.getCodigoCurso().isEmpty()){
                aluno.setMatricula(curso);
            }
            else{
                System.out.println("Não existe nenhum curso com esse codigo");
                SubMenuController.show("Curso");
            }

        }
        else {
            System.out.println("Digite algum valor para matricula!");
            SubMenuController.show("Aluno");
        }
    }

    public static void validaSeExisteCurso(){
        List existeCurso = CursoDAO.buscaCursos();

        if(existeCurso.toArray().length == 0){
            System.out.println("Não é possivel criar um aluno sem criar um curso");
            SubMenuController.show("Curso");
        }
    }

    public static void mostraCursoExistente(){
        System.out.println("Cursos disponivel em nossa faculdade:");
        System.out.println();

        List cursosExistentes = CursoDAO.GetAll();
        CursoView.ConsultarAll(cursosExistentes);
    }

    public static void validaCodigoDoCurso(String curso, Aluno aluno){
        if (!curso.isEmpty()) {
            aluno.setIdCurso(curso);
        }
        else {
            System.out.println("Digite algum valor para código do curso!");
            SubMenuController.show("Aluno");
        }
    }
}
