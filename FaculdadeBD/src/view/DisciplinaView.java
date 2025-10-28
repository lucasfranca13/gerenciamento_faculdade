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
        String codigoDisciplina = scan.nextLine();
        validaCodigoDisciplina(codigoDisciplina, disciplina);

        System.out.print("Nome: ");
        String nome = scan.nextLine();
        validaNomeDisciplina(nome, disciplina);

        System.out.print("Carga: ");
        String cargaDisciplina = scan.nextLine();
        validaCargaDisciplina(cargaDisciplina,  disciplina);

    }

    public static void Atualizar(Disciplina disciplina) {
        Scanner scan = new Scanner(System.in);

        System.out.print("("+ disciplina.getNome() + ") - Nome: ");
        String nome = scan.nextLine();
        validaNomeDisciplina(nome, disciplina);

        System.out.print("("+ disciplina.getCarga() + ") - Carga: ");
        String carga = scan.nextLine();
        validaCargaDisciplina(carga, disciplina);
    }

    public static void Consultar(Disciplina disciplina) {
        System.out.println("Código Disciplina: " + disciplina.getCodigoDisciplina());
        System.out.println("Nome: " + disciplina.getNome());
        System.out.println("Carga: " + disciplina.getCarga());
        System.out.println();
    }

    public static String GetCodDisciplina() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Informe sua o código da disciplina: ");
        String codDisciplina = scan.nextLine();
        if(codDisciplina.isEmpty()){
            System.out.println("Digite algum valor para disciplina!");
            SubMenuController.show("Disciplina");
        }
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

    public static int validaValorCarga(String carga) {
        try  {
            Integer.parseInt(carga);
        } catch (NumberFormatException e) {
            System.out.println("A idade não pode conter letras ou caracteres especiais");
            SubMenuController.show("Aluno");
        }
        return Integer.parseInt(carga);
    };

    public static void validaNomeDisciplina(String nome, Disciplina disciplina){
        if (!nome.isEmpty()) {
            disciplina.setNome(nome);
        }
        else {
            System.out.println("Digite algum valor para nome!");
            SubMenuController.show("Disciplina");
        }
    }

    public static void validaCodigoDisciplina(String codigo, Disciplina disciplina){
        if (!codigo.isEmpty()) {
            disciplina.setCodigoDisciplina(codigo);
        }
        else {
            System.out.println("Digite algum valor para codigo!");
            SubMenuController.show("Disciplina");
        }
    }

    public static void validaCargaDisciplina(String carga, Disciplina disciplina){
        if (!carga.isEmpty()) {
            int cargaValidada = validaValorCarga(carga);
            disciplina.setCarga(cargaValidada);
        }
        else {
            System.out.println("Digite algum valor para carga!");
            SubMenuController.show("Disciplina");
        }
    }

}
