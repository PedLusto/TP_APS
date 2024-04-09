package org.example.persistencias;

import java.io.*;
import java.util.Map;
import java.util.HashMap;

import org.example.classes.Entidade;
import org.example.classes.Estoquista;

public class Db<T extends Entidade> {
    private String arquivo;
    private Map<Integer, T> entidades;
    private Integer nextId = 0;

    public Db(String arquivo) {
        this.arquivo = arquivo;
        this.carregar();
    }

    public T get(Integer id) {
        return entidades.get(id);
    }

    public void insert(T obj) {
        Integer id = ++nextId;
        obj.setId(id);
        entidades.put(id, obj);
    }

    public void remove(Integer id) {
        entidades.remove(id);
    }

    public void close() {
        gravar();
    }

    private void gravar() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            out.writeObject(entidades);
            System.out.println("Estoquistas gravados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao gravar estoquistas: " + e.getMessage());
        }
    }

    private void carregar() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
            entidades = (Map<Integer, T>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            entidades = new HashMap<>();
        }
    }

}
