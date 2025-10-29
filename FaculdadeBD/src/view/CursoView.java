package view;

import controller.SubMenuController;
import dao.CursoDAO;
import dao.DisciplinaDAO;
import model.Aluno;
import model.Curso;
import model.Disciplina;

import java.util.List;
import java.util.Scanner;

public class CursoView {

    public static void Criar(Curso curso) {
        Scanner scan = new Scanner(System.in);
        validaSeExisteDisciplina();
        mostraDisciplinaExistente();

        System.out.print("Codigo: ");
        String codigoCurso = scan.nextLine();
        validaCodigoCurso(codigoCurso, curso);

        System.out.print("Nome: ");
        String nome = scan.nextLine();
        validaNomeCurso(nome, curso);

        System.out.print("Turno: ");
        String turno = scan.nextLine();
        validaTurnoCurso(turno, curso);

        System.out.print("Digite o codigo da disciplina: ");
        String disciplina = scan.nextLine();
        validaCodigoDaDisciplina(disciplina, curso);
        boolean existeEssaDisciplina = DisciplinaDAO.existeEsseCodigoDiciplina(disciplina);
        if(!existeEssaDisciplina){
            validaDisciplinaCurso(disciplina, curso);
        }
        else {
            System.out.println("O código dessa disciplina não existe!");
            SubMenuController.show("Curso");
        }
    }

    public static void Atualizar(Curso curso) {
        Scanner scan = new Scanner(System.in);

        mostraDisciplinaExistente();

        System.out.print("("+ curso.getNomeCurso() + ") - Nome: ");
        String nome = scan.nextLine();
        validaNomeCurso(nome, curso);

        System.out.print("("+ curso.getTurno() + ") - Turno: ");
        String turno = scan.nextLine();
        validaTurnoCurso(turno, curso);

        System.out.print("("+ curso.getIdDisciplina() + ") - Código da disciplina: ");
        String disciplina = scan.nextLine();
        validaCodigoDaDisciplina(disciplina, curso);
    }

    // listar cursos

    public static void ConsultarAll(List<Curso> curso) {

        for (Curso item : curso){
            System.out.println("Código Curso: " + item.getCodigoCurso());
            System.out.println("Nome: " + item.getNomeCurso());
            System.out.println("Turno: " + item.getTurno());
            System.out.println("Código da disciplina: " + item.getIdDisciplina());
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

    public static void validaDisciplinaCurso(String disciplina, Curso curso){
        if (!disciplina.isEmpty()) {
            Disciplina existeCurso = DisciplinaDAO.Get(disciplina);
            if(!existeCurso.getCodigoDisciplina().isEmpty()){
                curso.setIdDisciplina(disciplina);
            }
            else{
                System.out.println("Não existe nenhuma disciplina com esse codigo");
                SubMenuController.show("Disciplina");
            }

        }
        else {
            System.out.println("Digite algum valor para código da disciplina!");
            SubMenuController.show("Curso");
        }
    }

    public static void validaSeExisteDisciplina(){
        List existeDisciplina = DisciplinaDAO.buscaDisciplina();

        if(existeDisciplina.toArray().length == 0){
            System.out.println("Não é possivel criar um curso sem criar uma disciplina");
            SubMenuController.show("Disciplina");
        }
    }

    public static void mostraDisciplinaExistente(){
        System.out.println("Disciplinas disponivel em nossa faculdade:");
        System.out.println();

        List disciplinaExistentes = DisciplinaDAO.GetAll();
        DisciplinaView.ConsultarAll(disciplinaExistentes);
    }

    public static void validaCodigoDaDisciplina(String disciplina, Curso curso){
        if (!disciplina.isEmpty()) {
            boolean existeDisciplina = DisciplinaDAO.existeEsseCodigoDiciplina(disciplina);
            if(!existeDisciplina){
                curso.setIdDisciplina(disciplina);
            }
            else {
                System.out.println("O codigo da disciplina não existe");
                SubMenuController.show("Curso");
            }
        }
        else {
            System.out.println("Digite algum valor para código da disciplina!");
            SubMenuController.show("Curso");
        }
    }

}
