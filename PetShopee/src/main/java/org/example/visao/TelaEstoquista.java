package org.example.visao;

import java.util.Scanner;
import org.example.classes.Estoquista;

public class TelaEstoquista {
    private Scanner scanner;
    private Estoquista estoquista;

    public TelaEstoquista(Estoquista estoquista) {
        this.scanner = new Scanner(System.in);
        this.estoquista = estoquista;
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("=== Menu do Estoquista ===");
            System.out.println("1. Verificar estoque de um item");
            System.out.println("2. Solicitar estoque");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    verificarEstoque();
                    break;
                case 2:
                    solicitarEstoque();
                    break;
                case 0:
                    System.out.println("Saindo do menu do estoquista...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (opcao != 0);
    }

    private void verificarEstoque() {
        System.out.print("Digite o nome do item que deseja verificar o estoque: ");
        String item = scanner.nextLine();
        estoquista.verificarEstoque(item);
    }

    private void solicitarEstoque() {
        System.out.print("Digite o nome do item que deseja solicitar: ");
        String item = scanner.nextLine();
        System.out.print("Digite a quantidade a ser solicitada: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        estoquista.solicitarEstoque(item, quantidade);
    }
}
