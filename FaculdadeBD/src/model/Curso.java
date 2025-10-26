package model;

import java.util.List;

public class Curso {
    private String codigoCurso;
    private String nomeCurso;
    private String turno;
    private List<Aluno> listaAlunos;

    public Curso() {
    }

    public Curso(String codigoCurso, String nomeCurso, String turno) {
        this.codigoCurso = codigoCurso;
        this.nomeCurso = nomeCurso;
        this.turno = turno;
    }

    public Curso(String codigoCurso, String nomeCurso, String turno, List<Aluno> listaAlunos) {
        this.codigoCurso = codigoCurso;
        this.nomeCurso = nomeCurso;
        this.turno = turno;
        this.listaAlunos = listaAlunos;
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

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(List<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }
}
