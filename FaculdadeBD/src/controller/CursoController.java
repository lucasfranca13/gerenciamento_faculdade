package controller;

import dao.AlunoDAO;
import dao.CursoDAO;
import model.Aluno;
import model.Curso;
import view.AlunoView;
import view.CursoView;

public class CursoController {

    public static void Criar() {
        Curso curso = new Curso();
        CursoView.Criar(curso);
        if (curso != null) {
            CursoDAO.Add(curso);
        }
    }

    public static void Consultar() {
        int codigo = CursoView.GetCurso();
        Curso curso = CursoDAO.Get(codigo);
        CursoView.Consultar(curso);
    }




}
