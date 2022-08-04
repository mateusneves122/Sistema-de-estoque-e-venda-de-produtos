//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
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
        this.tela.getSexo().setSelectedIndex(0);
        this.tela.getCargo().setText("");
        this.tela.getIsAdmin().setSelectedIndex(0);
        
        this.tela.getAlerta().setText("");
    }
    
}
