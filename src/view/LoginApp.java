/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Model.Connector;
import Model.Session;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

/**
 *
 * @author sabri
 */
public class LoginApp extends JFrame{
    JLabel header = new JLabel("Login Sistem");
    JLabel labelInputUsername = new JLabel("Username");
    JLabel labelInputPassword = new JLabel("Password");
    JTextField inputUsername = new JTextField();
    JPasswordField inputPassword = new JPasswordField();
    JButton tombolLogin = new JButton("Login");
    
    public LoginApp(){
        setTitle("Logistik App - LOGIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(480, 270);

        add(header);
        add(labelInputUsername);
        add(labelInputPassword);
        add(inputUsername);
        add(inputPassword);
        add(tombolLogin);
        
        header.setBounds(20, 5, 440, 30);
        labelInputUsername.setBounds(20, 35, 440, 20);
        inputUsername.setBounds(20, 60, 440, 36);
        labelInputPassword.setBounds(20, 100, 440, 20);
        inputPassword.setBounds(20, 125, 440, 36);
        tombolLogin.setBounds(20, 175, 440, 40);

        setVisible(true);
        
        tombolLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButtonClicked();
            }
        });        
    }
    
    private void loginButtonClicked() {
        String username = inputUsername.getText();
        String password = inputPassword.getText();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Username dan password tidak boleh kosong!",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            Connection conn = Connector.Connect();

            if (conn == null) {
                JOptionPane.showMessageDialog(this,
                        "Gagal terhubung ke database!",
                        "Error Database",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                // simpan user login ke session
                Session.setUsername(username);

                JOptionPane.showMessageDialog(this,
                        "Login berhasil!",
                        "Sukses",
                        JOptionPane.INFORMATION_MESSAGE);

                dispose();
                new MenuUtama();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Username atau password salah!",
                        "Login Gagal",
                        JOptionPane.ERROR_MESSAGE);

                inputPassword.setText("");
                inputUsername.requestFocus();
            }

            result.close();
            statement.close();
            conn.close();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: " + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
