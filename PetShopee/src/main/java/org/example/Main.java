package org.example;
import org.example.classes.Cliente;
import org.example.persistencias.Db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        Db<Cliente> clienteDb = new Db<Cliente>("clientes.db");
        Cliente pedro = new Cliente("Pedro", "29302390", "cu");
        clienteDb.insert(pedro);

        // Create the main frame
        JFrame frame = new JFrame("Pet Shopee");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        // Create a label
        JLabel label = new JLabel("Click the button");
        label.setHorizontalAlignment(JLabel.CENTER);
        
        // Create a button
        JButton button = new JButton("Click Me!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button Clicked!");
            }
        });
        
        // Create a panel and add components to it
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);
        
        // Add the panel to the frame
        frame.add(panel);
        
        // Set the frame visibility
        frame.setVisible(true);
        clienteDb.close();
    }
}
