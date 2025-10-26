package controller;

import dao.CursoDAO;
import dao.DisciplinaDAO;
import model.Curso;
import model.Disciplina;
import view.CursoView;
import view.DisciplinaView;

import java.util.List;

public class DisciplinaController {
    public static void Criar() {
        Disciplina disciplina = new Disciplina();
        DisciplinaView.Criar(disciplina);
        if (disciplina != null) {
            DisciplinaDAO.Add(disciplina);
        }
    }

    public static void Consultar() {
        String codigo = DisciplinaView.GetCodDisciplina();
        Disciplina disciplina = DisciplinaDAO.Get(codigo);
        DisciplinaView.Consultar(disciplina);
    }

    public static void Atualizar() {
        String codigo = DisciplinaView.GetCodDisciplina();
        Disciplina disciplina = DisciplinaDAO.Get(codigo);
        DisciplinaView.Atualizar(disciplina);
        DisciplinaDAO.Atualizar(disciplina);
    }

    public static void Deletar() {
        String codigo = DisciplinaView.GetCodDisciplina();
        DisciplinaDAO.Deletar(codigo);
    }

    public static void ListarDisciplinasAll(){
        List<Disciplina> disciplina = DisciplinaDAO.GetAll();
        DisciplinaView.ConsultarAll(disciplina);
    }

}

