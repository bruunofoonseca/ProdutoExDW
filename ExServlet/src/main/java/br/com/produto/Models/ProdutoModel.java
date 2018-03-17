/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.produto.Models;

import java.util.Date;

/**
 *
 * @author Bruno Fonseca
 * edit Diogo.Felix
 */
public class ProdutoModel {
    
    private int id;
    private String nome;
    private String descricao;
    private float precoCompra;
    private float precoVenda;
    private int quantidade;
    private Date dtCadastro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    // Atributos
    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
}