package com.vendas.sistemadevendas.vender.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TabelaProdutoModel {
    private final IntegerProperty codigo;
    private final StringProperty produto;
    private final StringProperty descricao;
    private final DoubleProperty preco;
    private final IntegerProperty estoque;

    public TabelaProdutoModel(int codigo, String produto, String descricao, double preco, int estoque) {
        this.codigo = new SimpleIntegerProperty(codigo);
        this.produto = new SimpleStringProperty(produto);
        this.descricao = new SimpleStringProperty(descricao);
        this.preco = new SimpleDoubleProperty(preco);
        this.estoque = new SimpleIntegerProperty(estoque);
    }

    public int getCodigo() {
        return codigo.get();
    }

    public String getProduto() {
        return produto.get();
    }

    public String getDescricao() {
        return descricao.get();
    }

    public double getPreco() {
        return preco.get();
    }

    public int getEstoque() {
        return estoque.get();
    }

    public IntegerProperty codigoProperty() {
        return codigo;
    }

    public StringProperty produtoProperty() {
        return produto;
    }

    public StringProperty descricaoProperty() {
        return descricao;
    }

    public DoubleProperty precoProperty() {
        return preco;
    }

    public IntegerProperty estoqueProperty() {
        return estoque;
    }
}
