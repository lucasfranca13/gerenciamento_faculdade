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

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toBinaryString;

public class AlunoDAO {

    private static List<Aluno> listAlunos = new ArrayList<>();

//    public static void Add(Aluno aluno) {
//        listAlunos.add(aluno);
//    }

    public static void Add(Aluno aluno) {
        String sql = "INSERT INTO alunos (matricula, nome, idade) VALUES (?, ?, ?)";
        boolean matricula = existeEssaMatricula(aluno.getMatricula());
        if (matricula) {
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
        else  {
            System.out.println("Essa matricula já está cadastrada em um aluno ja existente!");
            MenuController.show();
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

//    public static Aluno Get(String matricula) {
//        return listAlunos.stream().filter(a -> a.getMatricula().equals(matricula)).findFirst().get();
//    }

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
                    MenuController.show();
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar aluno: " + e.getMessage());
            throw new RuntimeException("Erro ao consultar aluno no banco de dados", e);
        }

        return aluno.get();
    }

    public static List<Aluno> GetAllByAge(int age) {
        return listAlunos.stream().filter(a -> a.getIdade() == age).toList();
    }

//    public static List<Aluno> GetAllByNameContains(String name) {
//        return listAlunos.stream().filter(a -> a.getNome().contains(name)).toList();
//    }

    public static List<Aluno> GetAll() {
        String sql = "SELECT * FROM alunos";
        Optional<Aluno> aluno = Optional.empty();

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Cria o objeto Aluno a partir dos dados retornados
                    aluno = Optional.of(new Aluno(
                            rs.getString("nome"),
                            rs.getInt("idade"),
                            rs.getString("matricula")
                    ));
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar aluno: " + e.getMessage());
            throw new RuntimeException("Erro ao consultar aluno no banco de dados", e);
        }

        return listAlunos = aluno.stream().toList();
    }

    public static void Delete(String matricula) {
        Aluno aluno = Get(matricula);
        listAlunos.remove(aluno);
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
