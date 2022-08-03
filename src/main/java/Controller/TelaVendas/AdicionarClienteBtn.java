/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.TelaVendas;

import Model.client.Cliente;
import TratamentoErro.CpfException;
import View.CadastrarCliente;
import View.TelaVendas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author SuvacoDeCobra
 */
public class AdicionarClienteBtn implements ActionListener {
    
    private CadastrarCliente telaCadastrarCliente;
    private TelaVendas tela;
    
    public AdicionarClienteBtn(TelaVendas tela) {
        this.tela = tela;
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        //telaCadastrarCliente = new CadastrarCliente(tela);
        //telaCadastrarCliente.montaTela();
        String nome = this.tela.getCadastroClienteNome().getText();
        String cpf = this.tela.getCadastroClienteCpf().getText();
        try {
            cpfContemLetras(cpf);
            cpfUsado(cpf, this.tela.getClienteList().getClientesCadastrados());
            Cliente cliente = new Cliente(nome,cpf);
            this.tela.getClienteList().getClientesCadastrados().add(cliente);
            this.tela.getCadastroClienteCpf().setBackground(Color.WHITE);
            
            this.tela.add(new JLabel("Cliente Cadastrado!"));
            
            
        } catch (CpfException err) {
            this.tela.getCadastroClienteCpf().setBackground(new Color(254, 57, 57));
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
