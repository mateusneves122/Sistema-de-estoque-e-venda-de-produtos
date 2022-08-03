/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.cadastroFuncionario;

import View.produtoFuncionario.CadastroProdutoFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yanfo
 */
public class RemoverFuncionario implements ActionListener {
    private CadastroProdutoFuncionario tela;

    public RemoverFuncionario(CadastroProdutoFuncionario tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = this.tela.getTabelaFuncionarios().getSelectedRow();
        if(index!=-1) {
            int id = (int) this.tela.getTabelaFuncionarios().getValueAt(index, 1);
            if (id != this.tela.getRegistroUsuarioAtual()) {
                this.tela.getFuncionariosContratados().removeRegistroFuncionario(id);

                DefaultTableModel tabela = (DefaultTableModel) this.tela.getTabelaFuncionarios().getModel();
                tabela.removeRow(index);
                this.tela.getTabelaFuncionarios().setModel(tabela);

                this.tela.getNomeFuncionario().setText("");
                this.tela.getCpf().setText("");
                this.tela.getPagamentoFixo().setText("");
                this.tela.getSenha().setText("");
                this.tela.getRg().setText("");
                this.tela.getTelefone().setText("");
                this.tela.getSexo().setSelectedIndex(0);
                this.tela.getCargo().setText("");
                this.tela.getIsAdmin().setSelectedIndex(0);
                
                this.tela.getAlerta().setText("");
            }
            else {
                this.tela.getAlerta().setText("Impossível deletar funcionário logado");
            }
        }
    }
    
    
}
