package com.vendas.sistemadevendas.vender.controller;

import com.vendas.sistemadevendas.adm.autentificacao.login.repository.ConectaDB;
import com.vendas.sistemadevendas.painel.PainelApplication;
import com.vendas.sistemadevendas.vender.model.ClienteModel;
import com.vendas.sistemadevendas.vender.model.ProdutoModel;
import com.vendas.sistemadevendas.vender.model.TabelaProdutoModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProdutoController implements Initializable {
    @FXML
    private Label textoTela;

    @FXML
    private BorderPane mainContainer;

    @FXML
    private TableView<TabelaProdutoModel> tvProduct;

    @FXML
    private TableColumn<TabelaProdutoModel, Integer> codigo;

    @FXML
    private TableColumn<TabelaProdutoModel, String> produto;
    @FXML
    private TableColumn<TabelaProdutoModel, String> descricao;

    @FXML
    private TableColumn<TabelaProdutoModel, Double> preco;

    @FXML
    private TableColumn<TabelaProdutoModel, Integer> estoque;

    private ObservableList<TabelaProdutoModel> obsTarefas;


    private List<TabelaProdutoModel> tarefas = new ArrayList<>();
    //Textfields
    @FXML
    private TextField txtProduto;
    @FXML
    private TextField txtDescricao;
    @FXML
    private TextField txtPreco;
    @FXML
    private TextField txtEstoque;
    @FXML
    private TextField txtIdCodigo;



    public ProdutoController() {
        System.out.println("Produtos");
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        //listarProdutos();
        listarTarefasFromDatabase();
        codigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        produto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        descricao.setCellValueFactory(new PropertyValueFactory<>("descricao")); // Adicione essa linha
        preco.setCellValueFactory(new PropertyValueFactory<>("preco")); // Adicione essa linha
        estoque.setCellValueFactory(new PropertyValueFactory<>("estoque")); // Adicione essa linha

        tvProduct.setItems(obsTarefas);
    }

    public void listarProdutos() {
        System.out.println("apertou");
        try {
            System.out.println("tentou");
            TabelaProdutoModel t1 = new TabelaProdutoModel(1, "Produto 1", "Descrição do Produto 1", 50.0, 100);
            TabelaProdutoModel t2 = new TabelaProdutoModel(2, "Produto 2", "Descrição do Produto 2", 70.0, 150);
            TabelaProdutoModel t3 = new TabelaProdutoModel(3, "Produto 3", "Descrição do Produto 3", 60.0, 120);
            TabelaProdutoModel t4 = new TabelaProdutoModel(4, "Produto 4", "Descrição do Produto 4", 80.0, 200);
            TabelaProdutoModel t5 = new TabelaProdutoModel(5, "Produto 5", "Descrição do Produto 5", 90.0, 180);

            tarefas.add(t1);
            tarefas.add(t2);
            tarefas.add(t3);
            tarefas.add(t4);
            tarefas.add(t5);

            obsTarefas = FXCollections.observableArrayList(tarefas);
        } catch (Exception e) {
            System.out.println("Erro" + e);
        }
    }
    public void listarTarefasFromDatabase() {
        ConectaDB db = new ConectaDB();

        try (Connection connection = db.getConnection()) {
            System.out.println("Conexão da listagem ok");
            String query = "SELECT * FROM produto";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            ObservableList<TabelaProdutoModel> tarefas = FXCollections.observableArrayList();

            while (resultSet.next()) {
                int id = resultSet.getInt("idproduto");
                String produto = resultSet.getString("nomeproduto");
                String descricao = resultSet.getString("descricaoproduto");
                Double preco = resultSet.getDouble("precoproduto");
                int estoque = resultSet.getInt("estoque");

                BorderPane mainContainer = new BorderPane();

                TabelaProdutoModel tarefa = new TabelaProdutoModel(id, produto, descricao, preco, estoque);
                tarefas.add(tarefa);
            }

            obsTarefas = FXCollections.observableArrayList(tarefas);
            tvProduct.setItems(obsTarefas);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void voltarParaPrincipal(javafx.event.ActionEvent actionEvent) throws IOException {
        System.out.println("teste");
        PainelApplication painelApplication = new PainelApplication();
        painelApplication.start(new Stage());

        Stage stagemain = (Stage) mainContainer.getScene().getWindow();
        stagemain.close();
    }

    public void btnCadastrarProduto(ActionEvent actionEvent) throws SQLException {

        String produto = txtProduto.getText();
        String descricao = txtDescricao.getText();
        Double preco = Double.valueOf(txtPreco.getText());
        int estoque = Integer.parseInt(txtEstoque.getText());

        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setIdCliente(1);

        ProdutoModel produtoModel = new ProdutoModel(mainContainer);
        produtoModel.inserirProduto(produto, descricao, preco, estoque, clienteModel);
        System.out.println(produto + descricao + preco + estoque + clienteModel);
        listarTarefasFromDatabase();
        limparformulario();
    }

    public void btnAtualizarProduto(ActionEvent actionEvent) throws SQLException {
        int codigo = 34; // Integer.parseInt(txtIdCodigo.getText());
        String produto = txtProduto.getText();
        String descricao = txtDescricao.getText();
        Double preco = Double.valueOf(txtPreco.getText());
        int estoque = Integer.parseInt(txtEstoque.getText());

        ClienteModel clienteModel = new ClienteModel();
        clienteModel.setIdCliente(1);

        ProdutoModel produtoModel = new ProdutoModel(mainContainer);
        produtoModel.atualizarProduto(codigo, produto, descricao, preco, estoque);
        listarTarefasFromDatabase();
        limparformulario();
    }

    public void btnLimparProduto(ActionEvent actionEvent) {
        limparformulario();
    }
    public void limparformulario(){
        txtIdCodigo.setText("");
        txtProduto.setText("");
        txtDescricao.setText("");
        txtPreco.setText("");
        txtEstoque.setText("");
    }
}
