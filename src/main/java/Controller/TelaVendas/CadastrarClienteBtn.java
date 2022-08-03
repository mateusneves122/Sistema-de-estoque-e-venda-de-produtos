/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.TelaVendas;

import Model.client.Cliente;
import TratamentoErro.CpfException;
import View.CadastrarCliente;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author SuvacoDeCobra
 */
public class CadastrarClienteBtn implements ActionListener {

    private CadastrarCliente telaCadastrarCliente;

    public CadastrarClienteBtn(CadastrarCliente telaPrincipal) {
        this.telaCadastrarCliente = telaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = this.telaCadastrarCliente.getNome().getText();
        String cpf = this.telaCadastrarCliente.getCpf().getText();
        try {
            cpfContemLetras(cpf);
            cpfUsado(cpf, this.telaCadastrarCliente.getClienteList().getClientesCadastrados());
            Cliente cliente = new Cliente(nome,cpf);
            this.telaCadastrarCliente.getClienteList().getClientesCadastrados().add(cliente);
            this.telaCadastrarCliente.getCpf().setBackground(Color.WHITE);
            
            this.telaCadastrarCliente.add(new JLabel("Cliente Cadastrado!"));
        } catch (CpfException err) {
            this.telaCadastrarCliente.getCpf().setBackground(new Color(254, 57, 57));
        }
    }

    private void cpfContemLetras(String t) throws NumberFormatException {
        // passado para double para caber todos os números
        Double.parseDouble(t);
    }

    private void cpfUsado(String t, List<Cliente> lista) throws CpfException {
        for (Cliente f : lista) {
            if (f.getCpf().equals(t)) {
                throw new CpfException("CPF já está em uso!!");
            }
        }
    }
}

