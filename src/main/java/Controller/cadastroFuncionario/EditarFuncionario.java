/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.cadastroFuncionario;

import Model.employee.Funcionario;
import TratamentoErro.CpfException;
import View.produtoFuncionario.CadastroProdutoFuncionario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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
                String cpf = this.tela.getCpf().getText();
                cpfContemLetras(cpf);
                cpfUsado(cpf, this.tela.getFuncionariosContratados().getFuncionariosContratados());
                double pagamento = Float.parseFloat(this.tela.getPagamentoFixo().getText());
                int telefone = Integer.parseInt(this.tela.getTelefone().getText());
                String nome = this.tela.getNomeFuncionario().getText();
                char[] senha = this.tela.getSenha().getPassword();
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

                
                DefaultTableModel model = (DefaultTableModel) this.tela.getTabelaFuncionarios().getModel();
                model.removeRow(index);
                model.addRow(new Object[]{funcionario.getNome(),funcionario.getRegistro(), funcionario.getCargo(), admin, funcionario.getPagamentoFixo()});

                this.tela.getTabelaFuncionarios().setModel(model);

                this.tela.getNomeFuncionario().setText("");
                this.tela.getCpf().setText("");
                this.tela.getCpf().setBackground(Color.white);
                this.tela.getPagamentoFixo().setText("");
                this.tela.getPagamentoFixo().setBackground(Color.white);
                this.tela.getSenha().setText("");
                this.tela.getRg().setText("");
                this.tela.getTelefone().setText("");
                this.tela.getTelefone().setBackground(Color.white);
                this.tela.getSexo().setSelectedIndex(0);
                this.tela.getCargo().setText("");
                
                this.tela.getAlerta().setText("");

                this.tela.repaint();
            }
            catch(NumberFormatException err) {
                this.tela.getCpf().setBackground(new Color(254,57,57));
                this.tela.getPagamentoFixo().setBackground(new Color(254,57,57));
                this.tela.getTelefone().setBackground(new Color(254,57,57));
            }
            catch(CpfException err) {
                this.tela.getCpf().setBackground(new Color(254,57,57));
            }
        }
    }
    
    private void cpfContemLetras(String t) throws NumberFormatException {
        // passado para double para caber todos os números
        Double.parseDouble(t);
    }
    
    private void cpfUsado(String t, List<Funcionario> lista) throws CpfException {
        for(Funcionario f : lista) {
            if(f.getCpf().equals(t)) {
                throw new CpfException("CPF já está em uso!!");
            }
        }
    }
    
}
