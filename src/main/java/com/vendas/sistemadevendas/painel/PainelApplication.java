package com.vendas.sistemadevendas.painel;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PainelApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PainelApplication.class.getResource("/com/vendas/sistemadevendas/painel-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Inicio");
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