//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
package Controller.CadastroProdutos;

import Model.product.Produto;
import View.produtoFuncionario.CadastroProdutoFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author yanfo
 */
public class CancelarEdicao implements ActionListener {
    CadastroProdutoFuncionario tela;

    public CancelarEdicao(CadastroProdutoFuncionario tela) {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        tela.getAtualizar().setEnabled(false);
        tela.getCancelar().setEnabled(false);
        tela.getAdicionar().setEnabled(true);
        
        tela.getNomeProduto().setText("");
        tela.getPreco().setText("");
        tela.getQuantidade().setText("");
        tela.getTipoProduto().setSelectedIndex(0);
        tela.getValorUnidade().setText("");
        tela.getUnidadeMedida().setSelectedIndex(0);
        tela.getFornecedor().setText("");
        tela.getLocalizacao().setText("");
        tela.getDescricao().setText("");

        int index = this.tela.getTabelaProdutos().getSelectedRow();
        if(index!=-1) {
            int id = (int) this.tela.getTabelaProdutos().getValueAt(index, 0);
            Produto produto = new Produto("",0,0);
            for(Produto i : this.tela.getListaProdutos().getProdutosEmEstoque()) {
                if(i.getId()==id) {
                    produto = i;
                    break;
                }
            }
            
            
            this.tela.getdTipoProduto().setText(produto.getTipo());
            this.tela.getdUnidadeMedida().setText(Double.toString(produto.getPesoVolume()));
            this.tela.getdUnidadeOpt().setText(produto.getUnidadeMedida());
            this.tela.getdFornecedor().setText(produto.getFornecedor());
            this.tela.getdLocalizacao().setText(produto.getLocalizacaoNoEstoque());
            this.tela.getdDescricao().setText(produto.getDescricao());
            
            this.tela.repaint();
        }
    }
    
}
