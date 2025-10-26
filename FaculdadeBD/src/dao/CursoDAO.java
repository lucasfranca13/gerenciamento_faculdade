package dao;

import database.DatabaseConnection;
import model.Aluno;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import controller.MenuController;
import model.Curso;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;

public class CursoDAO {

    // CREATE CURSO
    public static void Add(Curso curso) {
        String sql = "INSERT INTO cursos (codigo, nome, turno) VALUES (?, ?, ?)";


            try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {

                stmt.setInt(1, curso.getCodigoCurso());
                stmt.setString(2, curso.getNomeCurso());
                stmt.setString(3, curso.getTurno());

                stmt.executeUpdate();
                System.out.println("Curso cadastrado com sucesso!");

            } catch (SQLException e) {
                System.out.println("Erro ao cadastrar curso: " + e.getMessage());
                throw new RuntimeException("Erro ao cadastrar curso no banco de dados", e);
            }
    }

    //READ CURSO

    public static Curso Get(int codigo) {
        String sql = "SELECT * FROM cursos WHERE codigo = ?";
        Optional<Curso> curso = Optional.empty();

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {

            stmt.setInt(1, codigo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Cria o objeto Curso a partir dos dados retornados
                    curso = Optional.of(new Curso(
                            rs.getInt("Codigo"),
                            rs.getString("Nome"),
                            rs.getString("Turno")
                    ));
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar curso: " + e.getMessage());
            throw new RuntimeException("Erro ao consultar curso no banco de dados", e);
        }

        return curso.get();
    }

    // lista todos os cursos

    public static List<Curso> GetAll(){
        List<Curso> listaCursos = new ArrayList<>();
        String sql = "SELECT Codigo, Nome, Turno FROM cursos ORDER BY Nome";

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getInt("Codigo"),
                        rs.getString("Nome"),
                        rs.getString("Turno")
                );
                listaCursos.add(curso);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao consultar cursos: " + e.getMessage());
            throw new RuntimeException("Erro ao consultar cursos no banco de dados", e);
        }

        return listaCursos;
    }

    //UPDATE CURSO (SET)
    public static void Atualizar(int codigo) {
        Curso curso = Get(codigo);

        String sql = "UPDATE cursos SET nome = ?, turno = ? WHERE codigo = ?";

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {

            stmt.setString(1, curso.getNomeCurso());
            stmt.setString(2, curso.getTurno());
            stmt.setInt(3, curso.getCodigoCurso());

            stmt.executeUpdate();
            System.out.println("\nCurso Atualizado com sucesso!\n");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar curso: " + e.getMessage());
            throw new RuntimeException("Erro ao atualizar curso no banco de dados", e);
        }
    }

    // DELETE CURSO

    public static void Deletar(int codigo) {

        String deleteSql = "DELETE FROM cursos WHERE codigo = ?";

        try (PreparedStatement deleteStmt = DatabaseConnection.getConnection().prepareStatement(deleteSql)) {
            deleteStmt.setInt(1, codigo);
            deleteStmt.executeUpdate();
            System.out.println("Curso removido do banco de dados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao consultar curso: " + e.getMessage());
            throw new RuntimeException("Erro ao consultar curso no banco de dados", e);
        }
    }

    public static void Criar() {
        String sqlCreateTable = """
            CREATE TABLE IF NOT EXISTS cursos (
                codigo INT PRIMARY KEY,
                nome VARCHAR(100) NOT NULL,
                turno VARCHAR(100) NOT NULL
            );
        """;

        try (Statement stmt = DatabaseConnection.getConnection().createStatement()) {

            stmt.executeUpdate(sqlCreateTable);
            System.out.println("Tabela 'cursos' criada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
