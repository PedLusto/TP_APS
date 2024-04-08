package org.example.controle;

import java.util.HashMap;
import java.util.Map;

public class ControleEstoquista {
    private Map<String, Integer> estoque;

    public ControleEstoquista() {
        this.estoque = new HashMap<>();
    }

    public void verificarEstoqueItem(String item) {
        int quantidade = estoque.get(item);
        if (quantidade != 0) {
            System.out.println("Estoque do item " + item + ": " + quantidade + " unidades");
        } else {
            System.out.println("O item " + item + " não está no estoque");
        }
    }

    public void solicitarEstoqueItem(String item, int quantidade) {
        if (estoque.containsKey(item)) {
            int estoqueAtual = estoque.get(item);
            estoque.put(item, estoqueAtual + quantidade);
            System.out.println("Solicitado estoque adicional para o item " + item + ". Novo estoque: " + (estoqueAtual + quantidade) + " unidades");
        } else {
            estoque.put(item, quantidade);
            System.out.println("Item " + item + " adicionado ao estoque com quantidade " + quantidade);
        }
    }
}
