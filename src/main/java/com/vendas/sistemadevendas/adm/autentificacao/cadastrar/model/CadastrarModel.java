package com.vendas.sistemadevendas.adm.autentificacao.cadastrar.model;

import com.vendas.sistemadevendas.adm.autentificacao.login.DAO.LoginDAO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class CadastrarModel {
    //atributos
    private int id;
    private String nome;
    private String senha;

    //Construtores

    private final BorderPane mainContainer;
    //Contrutor
    public CadastrarModel(BorderPane mainContainer) {
        this.mainContainer = mainContainer;
    }

    //Get e set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    //Operação

    public void telacadastro() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/vendas/sistemadevendas/cadastrar-view.fxml"));
        Parent tela1 = loader.load();

        // Criar nova cena para a Tela1
        Scene tela1Scene = new Scene(tela1, 600, 400);

        // Configurar o Stage da Tela1
        Stage stage = new Stage();
        stage.setTitle("Cadastro");
        stage.setScene(tela1Scene);

        // Esconder a janela principal
        Stage stagemain = (Stage) mainContainer.getScene().getWindow();
        stagemain.hide();

        // Mostrar a Tela1
        stage.show();
    }

}