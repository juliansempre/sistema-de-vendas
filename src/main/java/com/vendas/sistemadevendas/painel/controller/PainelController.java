package com.vendas.sistemadevendas.painel.controller;

import com.vendas.sistemadevendas.adm.autentificacao.login.model.LoginModel;
import com.vendas.sistemadevendas.vender.model.ProdutoModel;
import com.vendas.sistemadevendas.vender.model.VenderModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PainelController {
    @FXML
    private BorderPane mainContainer;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws Exception {
        welcomeText.setText("Welcome to JavaFX Application!");
        abrirLogin(mainContainer);


    }
    public static void abrirLogin(BorderPane mainContainer) throws Exception {
        LoginModel l = new LoginModel(mainContainer);
        l.tela1();
    }

    public void btnNovaVenda(ActionEvent actionEvent) throws IOException {
        VenderModel venderModel = new VenderModel(mainContainer);
        venderModel.tela1();
    }

    public void btnProduto(MouseEvent mouseEvent) throws IOException {
        ProdutoModel produtoModel = new ProdutoModel(mainContainer);
        produtoModel.telaProduto();
    }
}