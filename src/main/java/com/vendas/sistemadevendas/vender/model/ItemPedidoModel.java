package com.vendas.sistemadevendas.vender.model;

public class ItemPedidoModel {
    private int idItemPedido;
    private int quantidadeItemPedido;
    private double precoUnitarioItemPedido;
    private double subTotalItemPedido;
    private PedidoModel pedidoModel; // Representa a relação com Pedido
    private ProdutoModel produtoModel; // Representa a relação com Produto

    // Getters e setters

    public int getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(int idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public int getQuantidadeItemPedido() {
        return quantidadeItemPedido;
    }

    public void setQuantidadeItemPedido(int quantidadeItemPedido) {
        this.quantidadeItemPedido = quantidadeItemPedido;
    }

    public double getPrecoUnitarioItemPedido() {
        return precoUnitarioItemPedido;
    }

    public void setPrecoUnitarioItemPedido(double precoUnitarioItemPedido) {
        this.precoUnitarioItemPedido = precoUnitarioItemPedido;
    }

    public double getSubTotalItemPedido() {
        return subTotalItemPedido;
    }

    public void setSubTotalItemPedido(double subTotalItemPedido) {
        this.subTotalItemPedido = subTotalItemPedido;
    }

    public PedidoModel getPedidoModel() {
        return pedidoModel;
    }

    public void setPedidoModel(PedidoModel pedidoModel) {
        this.pedidoModel = pedidoModel;
    }

    public ProdutoModel getProdutoModel() {
        return produtoModel;
    }

    public void setProdutoModel(ProdutoModel produtoModel) {
        this.produtoModel = produtoModel;
    }
}
