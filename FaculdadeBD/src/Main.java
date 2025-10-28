import controller.MenuController;
import dao.AlunoDAO;
import dao.CursoDAO;
import dao.DisciplinaDAO;
import database.DatabaseConnection;
import model.Curso;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        DatabaseConnection.getConnection();
        DisciplinaDAO.Criar();
        CursoDAO.Criar();
        AlunoDAO.Criar();
        MenuController.show();
        DatabaseConnection.closeConnection();

    }
}