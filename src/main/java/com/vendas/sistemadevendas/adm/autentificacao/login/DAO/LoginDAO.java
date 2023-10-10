package com.vendas.sistemadevendas.adm.autentificacao.login.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.vendas.sistemadevendas.adm.autentificacao.login.model.LoginModel;
import com.vendas.sistemadevendas.adm.autentificacao.login.repository.ConectaDB;

import javax.swing.*;

public class LoginDAO {

    public static void inserirDadosLogin(LoginModel loginModel) throws SQLException {
        Connection connection = ConectaDB.getConnection();
        String query = "INSERT INTO login (nome, senha) VALUES (?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, loginModel.getNome());
            statement.setString(2, loginModel.getSenha());

            statement.executeUpdate();
            System.out.println("Dados inseridos com sucesso!");
            JOptionPane.showMessageDialog(null,"Usuario "+ loginModel.getNome() +" inserido com sucesso!");
            // Você pode adicionar aqui alguma lógica para tratar o sucesso da inserção, se necessário.
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
            JOptionPane.showMessageDialog(null,"Erro ao inserir dados!");
            // Trate a exceção ou propague-a para a camada superior, se necessário.
        } finally {
            ConectaDB.closeConnection(connection);
        }
    }

    public boolean autenticaUsuario(LoginModel login) {
        boolean autenticado = false;
        Connection connection = ConectaDB.getConnection();
        if (connection != null) {
            try {
                // Prepara uma consulta SQL para verificar se o usuário e a senha existem na tabela usuarios
                String sql = "SELECT * FROM login WHERE nome = ? AND senha = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, login.getNome());
                statement.setString(2, login.getSenha());
                ResultSet result = statement.executeQuery();
                // Se o resultado não for vazio, significa que o usuário foi autenticado
                if (result.next()) {
                    autenticado = true;
                }
                // Fecha o resultado, o statement e a conexão
                result.close();
                statement.close();
                ConectaDB.closeConnection(connection);
            } catch (SQLException e) {
                System.out.println("Erro ao autenticar o usuário: " + e.getMessage());
                JOptionPane.showMessageDialog(null,"Erro ao autenticar o usuario!");
            }
        }
        return autenticado;
    }
}
