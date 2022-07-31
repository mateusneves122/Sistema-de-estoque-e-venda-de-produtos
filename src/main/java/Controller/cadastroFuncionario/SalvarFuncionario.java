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
public class SalvarFuncionario implements ActionListener {
    private CadastroProdutoFuncionario tela;

    public SalvarFuncionario(CadastroProdutoFuncionario tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String nome = this.tela.getNomeFuncionario().getText();
            String cpf = this.tela.getCpf().getText();
            
        }
        catch(NumberFormatException err) {
            
        }
    }
    
    
}
