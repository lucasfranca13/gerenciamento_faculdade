package dao;

import controller.SubMenuController;
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

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;

public class AlunoDAO {

    private static List<Aluno> listAlunos = new ArrayList<>();


    public static void Add(Aluno aluno) {
        String sql = "INSERT INTO alunos (matricula, nome, idade) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {

                stmt.setString(1, aluno.getMatricula());
                stmt.setString(2, aluno.getNome());
                stmt.setInt(3, aluno.getIdade());

                stmt.executeUpdate();
                System.out.println("Aluno cadastrado com sucesso!");

            } catch (SQLException e) {
                System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
                throw new RuntimeException("Erro ao cadastrar aluno no banco de dados", e);
            }

    }

    public static boolean existeEssaMatricula(String matricula) {
        String sql = "SELECT * FROM alunos WHERE matricula = ?";
        Optional<Aluno> aluno = Optional.empty();

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {

            stmt.setString(1, matricula);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Cria o objeto Aluno a partir dos dados retornados
                    aluno = Optional.of(new Aluno(
                            rs.getString("nome"),
                            rs.getInt("idade"),
                            rs.getString("matricula")
                    ));
                }
                if(aluno.isEmpty()){
                    return true;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar aluno: " + e.getMessage());
            throw new RuntimeException("Erro ao consultar aluno no banco de dados", e);
        }

        return false;
    };

    public static Aluno Get(String matricula) {
        String sql = "SELECT * FROM alunos WHERE matricula = ?";
        Optional<Aluno> aluno = Optional.empty();

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {

            stmt.setString(1, matricula);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Cria o objeto Aluno a partir dos dados retornados
                    aluno = Optional.of(new Aluno(
                            rs.getString("nome"),
                            rs.getInt("idade"),
                            rs.getString("matricula")
                    ));
                }
                if(aluno.isEmpty()){
                    System.out.println("Matricula: " + matricula + " não está vinculada a nenhum aluno");
                    SubMenuController.show("Aluno");
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar aluno: " + e.getMessage());
            throw new RuntimeException("Erro ao consultar aluno no banco de dados", e);
        }

        return aluno.get();
    }

    public static List<Aluno> GetAll() {
        String sql = "SELECT * FROM alunos ORDER BY nome";
        Optional<Aluno> aluno = Optional.empty();

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Cria o objeto Aluno a partir dos dados retornados
                    aluno = Optional.of(new Aluno(
                            rs.getString("nome"),
                            rs.getInt("idade"),
                            rs.getString("matricula")
                    ));
                    listAlunos.add(aluno.get());
                }
                if(listAlunos.isEmpty()){
                    System.out.println("Não foi encontrato nenhum aluno em nosso banco de dados");
                    SubMenuController.show("Aluno");
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar aluno: " + e.getMessage());
            throw new RuntimeException("Erro ao consultar aluno no banco de dados", e);
        }

        return listAlunos;
    }

    public static void Atualiza(Aluno aluno) {
        String sql = "UPDATE alunos SET nome = ?, idade = ? WHERE matricula = ?";

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getMatricula());

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Aluno atualizado com sucesso!");
            } else {
                System.out.println("Nenhum aluno encontrado com a matrícula informada.");
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar aluno: " + e.getMessage());
            throw new RuntimeException("Erro ao atualizar aluno no banco de dados", e);
        }
    }

    public static void Delete(String matricula) {
        Aluno aluno = Get(matricula);
        String deleteSql = "DELETE FROM alunos WHERE matricula = ?";
        try (PreparedStatement deleteStmt = DatabaseConnection.getConnection().prepareStatement(deleteSql)) {
            deleteStmt.setString(1, matricula);
            deleteStmt.executeUpdate();
            System.out.println("Aluno "+ aluno.getNome()+" removido do banco de dados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao consultar aluno: " + e.getMessage());
            throw new RuntimeException("Erro ao consultar aluno no banco de dados", e);
        }
    }

    public static void Criar() {
        String sqlCreateTable = """
            CREATE TABLE IF NOT EXISTS alunos (
                matricula VARCHAR(10) PRIMARY KEY,
                nome VARCHAR(100) NOT NULL,
                idade INT NOT NULL
            );
        """;

        try (Statement stmt = DatabaseConnection.getConnection().createStatement()) {

            stmt.executeUpdate(sqlCreateTable);
            System.out.println("Tabela 'alunos' criada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
