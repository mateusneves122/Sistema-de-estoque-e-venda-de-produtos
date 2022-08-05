//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
package Controller.TelaVendas;

import Model.product.Produto;
import View.TelaVendas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PICHAU
 */
public class ExcluirDoCarrinho implements ActionListener {
    private TelaVendas tela;

    public ExcluirDoCarrinho(TelaVendas tela) {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int index = this.tela.getCarrinho().getSelectedRow();
        if(index != -1){
            DefaultTableModel carrinhoModel = (DefaultTableModel) this.tela.getCarrinho().getModel();
            DefaultTableModel tabelaModel = (DefaultTableModel) this.tela.getProdutos().getModel();
            try{
                int qtd = Integer.parseInt(carrinhoModel.getValueAt(index, 3).toString());
                int id = Integer.parseInt(carrinhoModel.getValueAt(index, 0).toString());
                for(int i = 0;i < tabelaModel.getRowCount();i++){
                    if(Integer.parseInt(tabelaModel.getValueAt(i, 0).toString()) == id){
                        tabelaModel.setValueAt(Integer.parseInt(tabelaModel.getValueAt(i, 3).toString())+qtd, i, 3);
                        this.tela.getProdutos().setModel(tabelaModel);
                        
                        break;
                    }
                }
                for (Produto i : this.tela.getEstoque().getProdutosEmEstoque()) {
                    if (i.getId() == id) {
                        i.setQuantidade(i.getQuantidade()+qtd);
                    }
                }
                carrinhoModel.removeRow(index);
                this.tela.getCarrinho().setModel(carrinhoModel);
                this.tela.getProdutos().setModel(tabelaModel);
            }catch(RuntimeException a){
                
            }
        }
    }
    
}
