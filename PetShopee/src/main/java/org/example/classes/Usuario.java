package org.example.classes;

import org.example.controle.ControleUsuario;

public class Usuario {
    private String nome;
    private int ID;
    private ControleUsuario controleUsuario;

    public Usuario(String nome, int ID) {
        this.nome = nome;
        this.ID = ID;
        controleUsuario = new ControleUsuario();
    }

    public String getNome() {
        return nome;
    }

    public int getID() {
        return ID;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
