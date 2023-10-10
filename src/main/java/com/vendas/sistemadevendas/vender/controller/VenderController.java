package com.vendas.sistemadevendas.vender.controller;

import com.vendas.sistemadevendas.painel.PainelApplication;
import com.vendas.sistemadevendas.vender.model.Tarefas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class VenderController implements Initializable{
    //Tabela
    @FXML
    private TableView<Tarefas> tvProducaoAroeira;
    @FXML
    private TableColumn<Tarefas, Integer> idColumn;
    @FXML
    private TableColumn<Tarefas, String> tarefaColumn;

    private ObservableList<Tarefas> obsTarefas;
    private List<Tarefas> tarefas = new ArrayList<>();

    @FXML
    private Label textoTela;

    @FXML
    private BorderPane mainContainer; // O contêiner onde as telas serão exibidas

    //Contrutor
    public VenderController(){
        System.out.println("Venda");
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        listarTarefas();

        // Configurar as células da tabela
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tarefaColumn.setCellValueFactory(new PropertyValueFactory<>("tarefa"));

        // Associar os dados à tabela
        tvProducaoAroeira.setItems(obsTarefas);
    }

    public void listarTarefas() {
        Tarefas t1 = new Tarefas(1, "Lavar roupas");
        Tarefas t2 = new Tarefas(2, "Cozinhar");

        tarefas.add(t1);
        tarefas.add(t2);

        obsTarefas = FXCollections.observableArrayList(tarefas);
    }

    @FXML
    private void voltarParaPrincipal(ActionEvent event) throws IOException {
       System.out.println("teste");
        PainelApplication painelApplication = new PainelApplication();
        painelApplication.start(new Stage());

        Stage stagemain = (Stage) mainContainer.getScene().getWindow();
        stagemain.close();
    }
}

