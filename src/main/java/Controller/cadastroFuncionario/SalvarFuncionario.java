/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.cadastroFuncionario;

import Model.employee.Funcionario;
import View.produtoFuncionario.CadastroProdutoFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

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
            float pagamento = Float.parseFloat(this.tela.getPagamentoFixo().getText());
            int telefone = Integer.parseInt(this.tela.getTelefone().getText());
            String nome = this.tela.getNomeFuncionario().getText();
            char[] senha = this.tela.getSenha().getPassword();
            String cpf = this.tela.getCpf().getText();
            String rg = this.tela.getRg().getText();
            String sexo = this.tela.getSexo().getSelectedItem().toString();
            String cargo = this.tela.getCargo().getText();
            String admin = this.tela.getIsAdmin().getSelectedItem().toString();
            
            Funcionario funcionario = new Funcionario(nome,cpf,String.copyValueOf(senha));
            
            funcionario.setPagamentoFixo(pagamento);
            funcionario.setRg(rg);
            funcionario.setTelefone(telefone);
            funcionario.setSexo(sexo);
            funcionario.setCargo(cargo);
            if(admin.equals("vendas"))
                funcionario.setAdmin(false);
            else 
                funcionario.setAdmin(true);
            
            this.tela.getFuncionariosContratados().getFuncionariosContratados().add(funcionario);
            DefaultTableModel model = (DefaultTableModel) this.tela.getTabelaFuncionarios().getModel();
            model.addRow(new Object[]{funcionario.getNome(),funcionario.getRegistro(), funcionario.getCargo(), admin, funcionario.getPagamentoFixo()});
            
            this.tela.getTabelaFuncionarios().setModel(model);
            
            this.tela.getNomeFuncionario().setText("");
            this.tela.getCpf().setText("");
            this.tela.getPagamentoFixo().setText("");
            this.tela.getSenha().setText("");
            this.tela.getRg().setText("");
            this.tela.getTelefone().setText("");
            this.tela.getSexo().setSelectedIndex(0);
            this.tela.getCargo().setText("");
            
            this.tela.repaint();
        }
        catch(NumberFormatException err) {
            
        }
    }
    
    
}
