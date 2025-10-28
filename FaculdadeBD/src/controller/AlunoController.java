package controller;

import dao.AlunoDAO;
import model.Aluno;
import view.AlunoView;
import controller.MenuController;
import dao.CursoDAO;

public class AlunoController {

    public static void Criar() {
        Aluno aluno = new Aluno();
        AlunoView.Criar(aluno);
        validaSeExisteMatricula(aluno.getMatricula());
        if (aluno != null) {
            AlunoDAO.Add(aluno);
        }
    }

    public static void validaSeExisteMatricula(String matricula) {
        boolean existeMatricula = AlunoDAO.existeEssaMatricula(matricula);
        if (!existeMatricula) {
            System.out.println("Essa matricula já está cadastrada em um aluno ja existente!");
            SubMenuController.show("Aluno");
        }
    }

    public static void Consultar() {
        String matricula = AlunoView.GetMatricula();
        Aluno aluno = AlunoDAO.Get(matricula);
        AlunoView.Consultar(aluno);
    }

    public static void Listar() {
        AlunoView.Listar(AlunoDAO.GetAll());
    }

    public static void Atualizar() {
        AlunoView.validaSeExisteCurso();

        String matricula = AlunoView.GetMatricula();
        Aluno aluno = AlunoDAO.Get(matricula);
        AlunoView.Atualizar(aluno);
        AlunoDAO.Atualiza(aluno);
    }

    public static void Deletar() {
        String matricula = AlunoView.GetMatricula();
        AlunoDAO.Delete(matricula);
        SubMenuController.show("Aluno");
    }

}
