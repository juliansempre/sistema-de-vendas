package com.vendas.sistemadevendas.adm.autentificacao.login.model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginStart extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.vendas.sistemadevendas.painel.PainelApplication.class.getResource("/com/vendas/sistemadevendas/login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Login");
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
        // Define a tela para ser maximizada
//	stage.setMaximized(true);
        stage.setResizable(false); //impedir a maximização
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}