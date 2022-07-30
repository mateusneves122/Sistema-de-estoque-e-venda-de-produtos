/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.CadastroProdutos;

import Model.product.Produto;
import View.product.CadastroProduto;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author yanfo
 */
public class VisualizaItem implements MouseListener {

    CadastroProduto tela;

    public VisualizaItem(CadastroProduto tela) {
        this.tela = tela;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
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
            // =======================================
            this.tela.getdTipoProduto().setText(produto.getTipo());
            this.tela.getdUnidadeMedida().setText(Double.toString(produto.getPesoVolume()));
            this.tela.getdUnidadeOpt().setText(produto.getUnidadeMedida());
            this.tela.getdFornecedor().setText(produto.getFornecedor());
            this.tela.getdLocalizacao().setText(produto.getLocalizacaoNoEstoque());
            this.tela.getdDescricao().setText(produto.getDescricao());
            
            this.tela.repaint();
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
