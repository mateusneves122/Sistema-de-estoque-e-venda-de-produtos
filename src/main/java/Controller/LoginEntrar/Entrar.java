/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.LoginEntrar;

import Model.employee.Funcionario;
import View.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ice
 */
public class Entrar implements ActionListener {
    Login tela;

    public Entrar(Login tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Mateus","33333333333", "1234"));
        funcionarios.add(new Funcionario("Denis","55555555555", "1234"));
        
        String nome = tela.getTfNome().getText();
        String senha = tela.getTfSenha().getText();
        
        for(Funcionario i : funcionarios) {
            if(nome.equals(i.getNome()) && senha.equals(i.getSenha())) {
                System.out.println("Logou");
            }
        }
    }

    /*@Override
    public void actionPerformed(ActionEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}
