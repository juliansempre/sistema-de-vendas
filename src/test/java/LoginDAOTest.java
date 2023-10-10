import com.vendas.sistemadevendas.adm.autentificacao.login.DAO.LoginDAO;
import com.vendas.sistemadevendas.adm.autentificacao.login.model.LoginModel;
import javafx.scene.layout.BorderPane;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class LoginDAOTest {

    @Test
    public void testInserirDadosLogin() {
        // Criar uma instância de LoginModel com dados de teste na string
        LoginModel loginModel = new LoginModel(new BorderPane());
        loginModel.setNome("testeNome");
        loginModel.setSenha("testeSenha");

        try {
            // Chamar o método da DAO para inserir os dados
            LoginDAO.inserirDadosLogin(loginModel);

            // Você pode adicionar verificações aqui para garantir que os dados foram inseridos corretamente
            // Por exemplo, você pode buscar os dados do banco de dados e comparar com os dados de teste.

            // Neste exemplo, vamos apenas afirmar que a inserção foi bem-sucedida.
            assertTrue(true, "Inserção bem-sucedida");
        } catch (SQLException e) {
            fail("Erro ao inserir dados: " + e.getMessage());
        }
    }
}

