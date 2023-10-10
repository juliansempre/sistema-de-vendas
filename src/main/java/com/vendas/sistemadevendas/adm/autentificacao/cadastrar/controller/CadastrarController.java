package com.vendas.sistemadevendas.adm.autentificacao.cadastrar.controller;

import com.vendas.sistemadevendas.adm.autentificacao.login.DAO.LoginDAO;
import com.vendas.sistemadevendas.adm.autentificacao.login.model.LoginModel;
import com.vendas.sistemadevendas.adm.autentificacao.login.model.LoginStart;
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
import java.sql.SQLException;

public class CadastrarController {
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
    public CadastrarController(){
        System.out.println("Cadastro");
    }
    @FXML
    private void voltarParaPrincipal(ActionEvent event) throws IOException {
        System.out.println("teste");
        PainelApplication painelApplication = new PainelApplication();
        painelApplication.start(new Stage());

        Stage stagemain = (Stage) mainContainer.getScene().getWindow();
        stagemain.close();
    }

    public void btnCadastroLogin(ActionEvent actionEvent) throws IOException, SQLException {
        System.out.println("Cadastrando usuário...");
        String nome = txtLogin.getText().toLowerCase();
        String senha = txtSenha.getText();

        LoginModel loginModel = new LoginModel(mainContainer);
        loginModel.setNome(nome);
        loginModel.setSenha(senha);

        if(nome.isEmpty() || senha.isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha os campos!");

        }else {
            LoginDAO.inserirDadosLogin(loginModel);
            limparformulario();
        }

    }
    public void limparformulario(){
        txtLogin.setText("");
        txtSenha.setText("");
    }

    public void btnLimpar(ActionEvent actionEvent) {
        limparformulario();
    }

    public void btnLogin(MouseEvent mouseEvent) throws Exception {
        LoginModel loginModel = new LoginModel(mainContainer);
        loginModel.tela1();
    }
}

