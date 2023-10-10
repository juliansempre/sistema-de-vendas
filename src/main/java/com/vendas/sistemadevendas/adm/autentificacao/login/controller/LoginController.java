package com.vendas.sistemadevendas.adm.autentificacao.login.controller;

import com.vendas.sistemadevendas.adm.autentificacao.cadastrar.model.CadastrarModel;
import com.vendas.sistemadevendas.adm.autentificacao.login.DAO.LoginDAO;
import com.vendas.sistemadevendas.adm.autentificacao.login.model.LoginModel;
import com.vendas.sistemadevendas.painel.PainelApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class LoginController {
    @FXML
    private Label textoTela;

    @FXML
    private BorderPane mainContainer; // O contêiner onde as telas serão exibidas

    public BorderPane getMainContainer() {
        return mainContainer;
    }
    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtSenha;

    public void setMainContainer(BorderPane mainContainer) {
        this.mainContainer = mainContainer;
    }

    //Contrutor
    public LoginController(){
        System.out.println("Login");
    }
    @FXML
    private void voltarParaPrincipal(ActionEvent event) throws IOException {
        System.out.println("teste");
        PainelApplication painelApplication = new PainelApplication();
        painelApplication.start(new Stage());

        Stage stagemain = (Stage) mainContainer.getScene().getWindow();
        stagemain.close();
    }

    public void btnEntrarLogin(ActionEvent actionEvent) throws IOException {
        System.out.println("Entrando no sistema...");

        String nome = txtLogin.getText().toLowerCase();
        String senha = txtSenha.getText();

        LoginModel loginModel = new LoginModel(mainContainer);
        loginModel.setNome(nome);
        loginModel.setSenha(senha);

        LoginDAO loginDAO = new LoginDAO();


        Boolean autenticado = loginDAO.autenticaUsuario(loginModel);
        if(nome.isEmpty() || senha.isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha os campos!");

        }else {
            if (autenticado) {
                System.out.println("Usuário autenticado!");
                PainelApplication painelApplication = new PainelApplication();
                painelApplication.start(new Stage());

                Stage stage2 = (Stage) mainContainer.getScene().getWindow();
                stage2.close();
                limparformulario();
            } else {
                System.out.println("Usuário ou senha inválidos!");
                JOptionPane.showMessageDialog(null,"Usuário ou senha inválidos!");
            }
        }

    }
    public void limparformulario(){
        txtLogin.setText("");
        txtSenha.setText("");
    }

    public void btnLimpar(ActionEvent actionEvent) {
        limparformulario();
    }

    public void btnCadastrar(MouseEvent mouseEvent) throws Exception {
        CadastrarModel cadastrarModel = new CadastrarModel(mainContainer);
        cadastrarModel.telacadastro();
    }
}

