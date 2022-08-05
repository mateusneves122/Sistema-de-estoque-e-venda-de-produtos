//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
package Controller.CadastroProdutos;

import View.produtoFuncionario.CadastroProdutoFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yanfo
 */
public class ExcluirProduto implements ActionListener {
    private CadastroProdutoFuncionario tela;

    public ExcluirProduto(CadastroProdutoFuncionario tela) {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int index = this.tela.getTabelaProdutos().getSelectedRow();
        if(index != -1) {
            int id = (int) this.tela.getTabelaProdutos().getValueAt(index, 0);
            this.tela.getListaProdutos().removeProductId(id);
            DefaultTableModel tabela = (DefaultTableModel) this.tela.getTabelaProdutos().getModel();
            tabela.removeRow(index);
            this.tela.getTabelaProdutos().setModel(tabela);
            
            tela.getdDescricao().setText("");
            tela.getdFornecedor().setText("");
            tela.getdLocalizacao().setText("");
            tela.getdTipoProduto().setText("");
            tela.getdUnidadeMedida().setText("");
            tela.getdUnidadeOpt().setText("");
            
            tela.getEditarBtn().setEnabled(true);
        }
    }
    
}
