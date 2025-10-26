package dao;

import database.DatabaseConnection;
import model.Disciplina;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DisciplinaDAO {

    // CREATE Disciplina
    public static void Add(Disciplina disciplina) {
        String sql = "INSERT INTO disciplina (codigo, nome, carga) VALUES (?, ?, ?)";


        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {

            stmt.setString(1, disciplina.getCodigoDisciplina());
            stmt.setString(2, disciplina.getNome());
            stmt.setInt(3, disciplina.getCarga());

            stmt.executeUpdate();
            System.out.println("\nDisciplina cadastrada com sucesso!\n");

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar disciplina: " + e.getMessage());
            throw new RuntimeException("Erro ao cadastrar disciplina no banco de dados", e);
        }
    }

    //READ disciplina

    public static Disciplina Get(String codigo) {
        String sql = "SELECT * FROM disciplina WHERE codigo = ?";
        Optional<Disciplina> disciplina = Optional.empty();

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {

            stmt.setString(1, codigo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Cria o objeto disciplina a partir dos dados retornados
                    disciplina = Optional.of(new Disciplina(
                            rs.getString("Codigo"),
                            rs.getString("Nome"),
                            rs.getInt("carga")
                    ));
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao consultar disciplina: " + e.getMessage());
            throw new RuntimeException("Erro ao consultar disciplina no banco de dados", e);
        }

        return disciplina.get();
    }

    // lista todas as disciplina

    public static List<Disciplina> GetAll(){
        List<Disciplina> listaDisciplinas = new ArrayList<>();
        String sql = "SELECT codigo, nome, carga FROM disciplina ORDER BY nome";

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Disciplina disciplina = new Disciplina(
                        rs.getString("Codigo"),
                        rs.getString("Nome"),
                        rs.getInt("Carga")
                );
                listaDisciplinas.add(disciplina);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao consultar disciplina: " + e.getMessage());
            throw new RuntimeException("Erro ao consultar disciplina no banco de dados", e);
        }

        return listaDisciplinas;
    }

    //UPDATE Disciplina (SET)
    public static void Atualizar(Disciplina disciplina) {

        String sql = "UPDATE disciplina SET nome = ?, carga = ? WHERE codigo = ?";

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {

            stmt.setString(1, disciplina.getNome());
            stmt.setInt(2, disciplina.getCarga());
            stmt.setString(3, disciplina.getCodigoDisciplina());

            stmt.executeUpdate();
            System.out.println("\nDisciplina Atualizada com sucesso!\n");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar disciplina: " + e.getMessage());
            throw new RuntimeException("Erro ao atualizar disciplina no banco de dados", e);
        }
    }

    // DELETE Disciplina

    public static void Deletar(String codigo) {

        String deleteSql = "DELETE FROM disciplina WHERE codigo = ?";

        try (PreparedStatement deleteStmt = DatabaseConnection.getConnection().prepareStatement(deleteSql)) {
            deleteStmt.setString(1, codigo);
            deleteStmt.executeUpdate();
            System.out.println("\nDisciplina removida do banco de dados com sucesso!\n");
        } catch (SQLException e) {
            System.out.println("Erro ao consultar disciplina: " + e.getMessage());
            throw new RuntimeException("Erro ao consultar disciplina no banco de dados", e);
        }
    }

    public static void Criar() {
        String sqlCreateTable = """
            CREATE TABLE IF NOT EXISTS disciplina (
                codigo VARCHAR(100) PRIMARY KEY,
                nome VARCHAR(100) NOT NULL,
                carga INT NOT NULL
            );
        """;

        try (Statement stmt = DatabaseConnection.getConnection().createStatement()) {

            stmt.executeUpdate(sqlCreateTable);
            System.out.println("Tabela 'disciplina' criada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
