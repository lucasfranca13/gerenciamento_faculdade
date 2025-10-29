package model;

import java.util.List;

public class Curso {
    private String codigoCurso;
    private String nomeCurso;
    private String turno;
    private List<Aluno> listaAlunos;
    private String idDisciplina;

    public Curso() {
    }

    public Curso(String codigoCurso, String nomeCurso, String turno, String idDisciplina) {
        this.codigoCurso = codigoCurso;
        this.nomeCurso = nomeCurso;
        this.turno = turno;
        this.idDisciplina = idDisciplina;
    }

    public Curso(String codigoCurso, String nomeCurso, String turno, List<Aluno> listaAlunos, String idDisciplina) {
        this.codigoCurso = codigoCurso;
        this.nomeCurso = nomeCurso;
        this.turno = turno;
        this.listaAlunos = listaAlunos;
        this.idDisciplina = idDisciplina;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(String idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }
}
