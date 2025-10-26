package model;

public class Disciplina {

    private String nome;
    private String codigoDisciplina;
    private int carga;

    public Disciplina(String codigoDisciplina, String nome, int carga) {
        this.codigoDisciplina = codigoDisciplina;
        this.nome = nome;
        this.carga = carga;
    }
    public Disciplina() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }
}
