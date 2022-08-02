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
public class EditarFuncionario implements ActionListener {
    private CadastroProdutoFuncionario tela;

    public EditarFuncionario(CadastroProdutoFuncionario tela) {
        this.tela = tela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Usa basicamente os mesmos eventos de SalvarFuncionário,
        // mudando apenas a inserção na planilha
        int index = this.tela.getTabelaFuncionarios().getSelectedRow();
        if(index!=-1) {
            try {
                double pagamento = Float.parseFloat(this.tela.getPagamentoFixo().getText());
                int telefone = Integer.parseInt(this.tela.getTelefone().getText());
                String nome = this.tela.getNomeFuncionario().getText();
                char[] senha = this.tela.getSenha().getPassword();
                String cpf = this.tela.getCpf().getText();
                String rg = this.tela.getRg().getText();
                String sexo = this.tela.getSexo().getSelectedItem().toString();
                String cargo = this.tela.getCargo().getText();
                String admin = this.tela.getIsAdmin().getSelectedItem().toString();

                Funcionario funcionario = new Funcionario("","","");

                // Adição da edição no arquivo base
                int id = Integer.parseInt(this.tela.getTabelaFuncionarios().getValueAt(index, 1).toString());
                for(Funcionario i : this.tela.getFuncionariosContratados().getFuncionariosContratados()) {
                    if(i.getRegistro()==id){
                        funcionario = i;
                        break;
                    }                    
                }

                funcionario.setNome(nome);
                funcionario.setCpf(cpf);
                funcionario.setSenha(String.copyValueOf(senha));
                funcionario.setPagamentoFixo(pagamento);
                funcionario.setRg(rg);
                funcionario.setTelefone(telefone);
                funcionario.setSexo(sexo);
                funcionario.setCargo(cargo);
                if(admin.equals("Vendas")) {
                    funcionario.setAdmin(false);
                }
                else {
                    funcionario.setAdmin(true);
                }

                /////////////////////////////////// Mudanças aqui
                DefaultTableModel model = (DefaultTableModel) this.tela.getTabelaFuncionarios().getModel();
                model.removeRow(index);
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
    
}
