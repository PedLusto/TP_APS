package org.example.classes;

import org.example.controle.ControleEstoquista;

public class Estoquista {
    private String nome;
    private int ID;
    private ControleEstoquista controleEstoquista;

    public Estoquista(String nome, int ID) {
        this.nome = nome;
        this.ID = ID;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }

    public void verificarEstoque(String item) {
        controleEstoquista.verificarEstoqueItem(item);
    }

    public void solicitarEstoque(String item, int quantidade) {
        controleEstoquista.solicitarEstoqueItem(item, quantidade);
    }
}
