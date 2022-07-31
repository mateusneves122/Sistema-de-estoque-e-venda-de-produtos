/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.cadastroFuncionario;

import View.produtoFuncionario.CadastroProdutoFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author yanfo
 */
public class LimparCampos implements ActionListener {
    
    private CadastroProdutoFuncionario tela;

    public LimparCampos(CadastroProdutoFuncionario tela) {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.tela.getNomeFuncionario().setText("");
        this.tela.getCpf().setText("");
        this.tela.getPagamentoFixo().setText("");
        this.tela.getSenha().setText("");
        this.tela.getRg().setText("");
        this.tela.getTelefone().setText("");
        this.tela.getRegistro().setText("");
        this.tela.getSexo().setSelectedIndex(0);
        this.tela.getCargo().setText("");
    }
    
}
