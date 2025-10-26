package model;

public class Disciplinas {

    private String nome;
    private int carga;
    private String codigoDisciplina;

    public Disciplinas(String nome, int carga, String codigoDisciplina) {
        this.nome = nome;
        this.carga = carga;
        this.codigoDisciplina = codigoDisciplina;
    }
    public Disciplinas() {

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
