package org.example.controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.classes.Cliente;
import org.example.classes.Paciente;

public class ControleCliente {
    private Map<Cliente, List<Paciente>> clientesPacientes;

    public ControleCliente() {
        this.clientesPacientes = new HashMap<>();
    }

    public void cadastrarCliente(String nome, String telefone, String endereco) {
        Cliente cliente = new Cliente(nome, telefone, endereco);
        clientesPacientes.put(cliente, new ArrayList<>());
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void listarClientes() {
        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientesPacientes.keySet()) {
            System.out.println("Nome: " + cliente.getNome() + ", Telefone: " + cliente.getTelefone() + ", Endereço: " + cliente.getEndereco());
        }
    }

    public void apagarCliente(String nome) {
        for (Cliente cliente : clientesPacientes.keySet()) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                clientesPacientes.remove(cliente);
                System.out.println("Cliente removido com sucesso!");
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }

    public void cadastrarPaciente(Cliente cliente, String nome, String especie, int idade) {
        Paciente paciente = new Paciente(nome, especie, idade);
        List<Paciente> pacientes = clientesPacientes.get(cliente);
        pacientes.add(paciente);
        clientesPacientes.put(cliente, pacientes);
        System.out.println("Paciente cadastrado com sucesso para o cliente " + cliente.getNome());
    }

    public void listarPacientes(Cliente cliente) {
        List<Paciente> pacientes = clientesPacientes.get(cliente);
        if (pacientes != null && !pacientes.isEmpty()) {
            System.out.println("Lista de Pacientes do Cliente " + cliente.getNome() + ":");
            for (Paciente paciente : pacientes) {
                System.out.println("Nome: " + paciente.getNome() + ", Espécie: " + paciente.getEspecie() + ", Idade: " + paciente.getIdade());
            }
        } else {
            System.out.println("O cliente " + cliente.getNome() + " não possui pacientes cadastrados.");
        }
    }

    public void apagarPaciente(Cliente cliente, String nome) {
        List<Paciente> pacientes = clientesPacientes.get(cliente);
        if (pacientes != null) {
            for (int i = 0; i < pacientes.size(); i++) {
                if (pacientes.get(i).getNome().equalsIgnoreCase(nome)) {
                    pacientes.remove(i);
                    clientesPacientes.put(cliente, pacientes);
                    System.out.println("Paciente removido com sucesso para o cliente " + cliente.getNome());
                    return;
                }
            }
        }
        System.out.println("Paciente não encontrado para o cliente " + cliente.getNome());
    }
}
