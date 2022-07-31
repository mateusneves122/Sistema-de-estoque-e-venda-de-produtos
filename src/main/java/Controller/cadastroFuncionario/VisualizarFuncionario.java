/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.cadastroFuncionario;

import Model.employee.Funcionario;
import View.produtoFuncionario.CadastroProdutoFuncionario;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author yanfo
 */
public class VisualizarFuncionario implements MouseListener {
    private CadastroProdutoFuncionario tela;

    public VisualizarFuncionario(CadastroProdutoFuncionario tela) {
        this.tela = tela;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int index = this.tela.getTabelaFuncionarios().getSelectedRow();
        if(index!=-1) {
            int id = (int) this.tela.getTabelaFuncionarios().getValueAt(index, 1);
            Funcionario funcionario = new Funcionario("","","");
            for(Funcionario i : this.tela.getFuncionariosContratados().getFuncionariosContratados()) {
                if(i.getRegistro()==id) {
                    funcionario = i;
                    break;
                }
            }
            this.tela.getNomeFuncionario().setText(funcionario.getNome());
            this.tela.getCpf().setText(funcionario.getCpf());
            this.tela.getPagamentoFixo().setText(Double.toString(funcionario.getPagamentoFixo()));
            this.tela.getSenha().setText(funcionario.getSenha());
            this.tela.getRg().setText(funcionario.getRg());
            this.tela.getTelefone().setText(Integer.toString(funcionario.getTelefone()));
            this.tela.getCargo().setText(funcionario.getCargo());
            
            int tamanhoListaSexo = this.tela.getSexo().getItemCount();
            for(int i=0; i<tamanhoListaSexo; i++) {
                if(funcionario.getSexo() == this.tela.getSexo().getItemAt(i)) {
                    this.tela.getSexo().setSelectedIndex(i);
                }
            }
            
            String funcao;
            boolean isAdmin = funcionario.isAdmin();
            if(isAdmin)
                funcao = "Administração";
            else 
                funcao = "Vendas";
            
            int tamanhoListaFuncao = this.tela.getIsAdmin().getItemCount();
            for(int i=0; i<tamanhoListaFuncao; i++) {
                if(funcao == this.tela.getSexo().getItemAt(i)) {
                    this.tela.getIsAdmin().setSelectedIndex(i);
                }
            }
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}
