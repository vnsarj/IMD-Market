package com.example.imdmarket;

public class Produto {
    private int codigo_produto;
    private String nome_produto;
    private String descricao_produto;
    private int estoque;

    public Produto(int codigo_produto, String nome_produto, String descricao_produto, int estoque) {
        this.codigo_produto = codigo_produto;
        this.nome_produto = nome_produto;
        this.descricao_produto = descricao_produto;
        this.estoque = estoque;
    }

    public int getCodigo_produto() {
        return codigo_produto;
    }

    public void setCodigo_produto(int codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }


}
