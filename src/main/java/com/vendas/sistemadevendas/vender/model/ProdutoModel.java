package com.vendas.sistemadevendas.vender.model;

import com.vendas.sistemadevendas.adm.autentificacao.login.repository.ConectaDB;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoModel {
    private int idProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private double precoProduto;
    private int estoque;
    private ClienteModel clienteModel;
    private final BorderPane mainContainer;

    //Construtor
    public ProdutoModel(BorderPane mainContainer){
        this.mainContainer = mainContainer;
    }

    // Getters e setters

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public ClienteModel getClienteModel() {
        return clienteModel;
    }

    public void setClienteModel(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }

    //Operação
    public void inserirProduto(String nomeproduto, String descricaoproduto, Double precoproduto, int estoque, ClienteModel clienteModel) throws SQLException {
        Connection connection = ConectaDB.getConnection();
        String query = "INSERT INTO produto (nomeproduto, descricaoproduto, precoproduto, estoque, Cliente_idCliente) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, nomeproduto);
            statement.setString(2, descricaoproduto);
            statement.setDouble(3, precoproduto);
            statement.setInt(4, estoque);  // Corrigido aqui
            statement.setInt(5, clienteModel.getIdCliente());

            statement.executeUpdate();
            System.out.println("Produto inserido com sucesso!");
            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir dados na classe ProducaoAroeiraModel: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao inserir Produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConectaDB.closeConnection(connection);
        }
    }
    public void atualizarProduto(int idProduto, String nomeproduto, String descricaoproduto, Double precoproduto, int estoque) throws SQLException {
        Connection connection = ConectaDB.getConnection();
        String query = "UPDATE produto SET nomeproduto = ?, descricaoproduto = ?, precoproduto = ?, estoque = ? WHERE idProduto = ?;";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, nomeproduto);
            statement.setString(2, descricaoproduto);
            statement.setDouble(3, precoproduto);
            statement.setInt(4, estoque);  // Corrigido aqui
            statement.setInt(5, idProduto);

            statement.executeUpdate();
            System.out.println("Produto "+idProduto+" atualizado com sucesso!");
            JOptionPane.showMessageDialog(null, "Produto "+idProduto+" inserido com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar dados: " + e.getMessage());
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConectaDB.closeConnection(connection);
        }
    }
    public void telaProduto() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/vendas/sistemadevendas/produto-view.fxml"));
        Parent tela1 = loader.load();

        // Criar nova cena para a Tela1
        Scene tela1Scene = new Scene(tela1, 600, 400);

        // Configurar o Stage da Tela1
        Stage stage = new Stage();
        stage.setTitle("Produto");
        stage.setScene(tela1Scene);

        // Esconder a janela principal
        Stage stagemain = (Stage) mainContainer.getScene().getWindow();
        stagemain.hide();

        // Mostrar a Tela1
        stage.show();
    }
}
