/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

//import Controller.ControllerMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    JTextField inputPassword = new JTextField();
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
                dispose();
                new MenuUtama();
            }
        });        
    }
}
