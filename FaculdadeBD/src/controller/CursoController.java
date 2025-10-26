package controller;

import dao.AlunoDAO;
import dao.CursoDAO;
import model.Aluno;
import model.Curso;
import view.AlunoView;
import view.CursoView;

import java.util.List;

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

    public static void Atualizar() {
        int codigo = CursoView.GetCurso();
        Curso curso = CursoDAO.Get(codigo);
        CursoView.Atualizar(curso);
        CursoDAO.Atualizar(codigo);
    }

    public static void Deletar() {
        int codigo = CursoView.GetCurso();
        CursoDAO.Deletar(codigo);
    }

    public static void ListarCursoAll(){
        List<Curso> cursos = CursoDAO.GetAll();
        CursoView.ConsultarAll(cursos);
    }


}
