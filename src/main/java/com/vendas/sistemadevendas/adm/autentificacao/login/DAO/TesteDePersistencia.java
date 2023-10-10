package com.vendas.sistemadevendas.adm.autentificacao.login.DAO;
import com.vendas.sistemadevendas.adm.autentificacao.login.model.LoginModel;
import javafx.scene.layout.BorderPane;

import java.util.Scanner;
import java.sql.SQLException;

public class TesteDePersistencia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();

        // Criar uma instância de LoginModel e definir os dados
        LoginModel loginModel = new LoginModel(new BorderPane());
        loginModel.setNome(nome);
        loginModel.setSenha(senha);

        // Chamar o método da DAO para persistir os dados
        try {
            LoginDAO.inserirDadosLogin(loginModel);
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados: " + e.getMessage());
            // Trate a exceção ou propague-a para a camada superior, se necessário.
        } finally {
            // Fechar o scanner após a entrada do usuário
            scanner.close();
        }
    }
}
