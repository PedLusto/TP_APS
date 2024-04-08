package org.example.persistencias;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.example.classes.Estoquista;

public class PersistenciaEstoquista {
    private String arquivo;

    public PersistenciaEstoquista(String arquivo) {
        this.arquivo = arquivo;
    }

    public void gravarEstoquistas(List<Estoquista> estoquistas) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            out.writeObject(estoquistas);
            System.out.println("Estoquistas gravados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao gravar estoquistas: " + e.getMessage());
        }
    }

    public List<Estoquista> carregarEstoquistas() {
        List<Estoquista> estoquistas = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
            estoquistas = (List<Estoquista>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar estoquistas: " + e.getMessage());
        }
        return estoquistas;
    }

    public void apagarEstoquistas() {
        try {
            new FileOutputStream(arquivo).close();
            System.out.println("Estoquistas apagados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao apagar estoquistas: " + e.getMessage());
        }
    }
}
