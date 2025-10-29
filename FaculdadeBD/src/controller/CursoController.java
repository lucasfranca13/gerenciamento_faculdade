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
        validaSeExisteCodigo(curso.getCodigoCurso());
        if (curso != null) {
            CursoDAO.Add(curso);
        }
    }

    public static void validaSeExisteCodigo(String codigo) {
        boolean existeCodigo = CursoDAO.existeEsseCodigo(codigo);
        if (!existeCodigo) {
            System.out.println("Essa código já está cadastrado em um curso ja existente!");
            SubMenuController.show("Curso");
        }
    }

    public static void Consultar() {
        String codigo = CursoView.GetCurso();
        Curso curso = CursoDAO.Get(codigo);
        CursoView.Consultar(curso);
    }

    public static void ListarCursoAll(){
        CursoView.ConsultarAll(CursoDAO.GetAll());
    }

    public static void Atualizar() {
        String codigo = CursoView.GetCurso();
        Curso curso = CursoDAO.Get(codigo);
        CursoView.Atualizar(curso);
        CursoDAO.Atualizar(curso);
    }

    public static void Deletar() {
        String codigo = CursoView.GetCurso();
        List temAlunoNoCurso = AlunoDAO.buscaAlunoPeloCurso(codigo);
        if(temAlunoNoCurso.toArray().length == 0){
            CursoDAO.Deletar(codigo);
            SubMenuController.show("Curso");
        }
        else{
            System.out.println("Não é possivel apagar curso que tenha um ou mais alunos vinculados!");
            SubMenuController.show("Curso");
        }
    }

}
