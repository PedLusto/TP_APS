package org.example.visao;

import java.util.Scanner;
import org.example.controle.ControleCliente;
import org.example.classes.Cliente;

public class TelaCliente {
    private ControleCliente controleCliente;

    public TelaCliente() {
        this.controleCliente = new ControleCliente();
    }

    public void cadastrarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Digite o telefone do cliente:");
        String telefone = scanner.nextLine();
        System.out.println("Digite o endereço do cliente:");
        String endereco = scanner.nextLine();

        controleCliente.cadastrarCliente(nome, telefone, endereco);
    }

    public void listarClientes() {
        controleCliente.listarClientes();
    }

    public void apagarCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do cliente que deseja apagar:");
        String nome = scanner.nextLine();
        controleCliente.apagarCliente(nome);
    }

    public void cadastrarPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do cliente que deseja associar o paciente:");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = encontrarCliente(nomeCliente);
        if (cliente != null) {
            System.out.println("Digite o nome do paciente:");
            String nomePaciente = scanner.nextLine();
            System.out.println("Digite a espécie do paciente:");
            String especie = scanner.nextLine();
            System.out.println("Digite a idade do paciente:");
            int idade = scanner.nextInt();

            controleCliente.cadastrarPaciente(cliente, nomePaciente, especie, idade);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void listarPacientes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do cliente:");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = encontrarCliente(nomeCliente);
        if (cliente != null) {
            controleCliente.listarPacientes(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    public void apagarPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do cliente:");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = encontrarCliente(nomeCliente);
        if (cliente != null) {
            System.out.println("Digite o nome do paciente que deseja apagar:");
            String nomePaciente = scanner.nextLine();
            controleCliente.apagarPaciente(cliente, nomePaciente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private Cliente encontrarCliente(String nome) {
    for (Cliente cliente : controleCliente.getClientesPacientes().keySet()) {
        if (cliente.getNome().equalsIgnoreCase(nome)) {
            return cliente;
        }
    }
    return null; // Se não encontrar nenhum cliente com o nome especificado

    }
}
