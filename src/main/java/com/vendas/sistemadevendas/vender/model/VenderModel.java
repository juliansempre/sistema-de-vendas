package com.vendas.sistemadevendas.vender.model;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class VenderModel {
    private final BorderPane mainContainer;
    //Contrutor
    public VenderModel(BorderPane mainContainer) {
        this.mainContainer = mainContainer;
    }
    //Operação
    public void tela1() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/vendas/sistemadevendas/vender-view.fxml"));
        Parent tela1 = loader.load();

        // Criar nova cena para a Tela1
        Scene tela1Scene = new Scene(tela1, 600, 400);

        // Configurar o Stage da Tela1
        Stage stage = new Stage();
        stage.setTitle("Venda");
        stage.setScene(tela1Scene);

        // Esconder a janela principal
        Stage stagemain = (Stage) mainContainer.getScene().getWindow();
        stagemain.hide();

        // Mostrar a Tela1
        stage.show();
    }
}