/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.CadastroProdutos;

import Model.product.Produto;
import View.product.CadastroProduto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author yanfo
 */
public class EditarProduto implements ActionListener {
    private CadastroProduto tela;

    public EditarProduto(CadastroProduto tela) {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
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
            
            this.tela.getNomeProduto().setText(produto.getNome());
            this.tela.getPreco().setText(Double.toString(produto.getPreco()));
            this.tela.getQuantidade().setText(Integer.toString(produto.getQuantidade()));
            
            int tamanhoTipo = this.tela.getTipoProduto().getItemCount();
            for(int i=0; i<tamanhoTipo; i++) {
                if(produto.getTipo() == this.tela.getTipoProduto().getItemAt(i)) {
                    this.tela.getTipoProduto().setSelectedIndex(i);
                }
            }
            
            this.tela.getValorUnidade().setText(Double.toString(produto.getPesoVolume()));
            
            int tamanhoUniMedida = this.tela.getUnidadeMedida().getItemCount();
            for(int i=0; i<tamanhoUniMedida; i++) {
                if(produto.getUnidadeMedida() == this.tela.getUnidadeMedida().getItemAt(i)) {
                    this.tela.getUnidadeMedida().setSelectedIndex(i);
                }
            }
            
            this.tela.getFornecedor().setText(produto.getFornecedor());
            this.tela.getLocalizacao().setText(produto.getLocalizacaoNoEstoque());
            this.tela.getDescricao().setText(produto.getDescricao());
            
            this.tela.getAtualizar().setEnabled(true);
            this.tela.getAdicionar().setEnabled(false);
            
            tela.getdDescricao().setText("");
            tela.getdFornecedor().setText("");
            tela.getdLocalizacao().setText("");
            tela.getdTipoProduto().setText("");
            tela.getdUnidadeMedida().setText("");
            tela.getdUnidadeOpt().setText("");
            
            tela.repaint();
        }
    }
    
}
