//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
package Controller.CadastroProdutos;

import Model.product.Produto;
import View.produtoFuncionario.CadastroProdutoFuncionario;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yanfo
 */
public class AtualizarProduto implements ActionListener {
    private CadastroProdutoFuncionario tela;

    public AtualizarProduto(CadastroProdutoFuncionario tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int index = this.tela.getTabelaProdutos().getSelectedRow();
            
            String nome = this.tela.getNomeProduto().getText();
            double preco = Double.parseDouble(this.tela.getPreco().getText());
            int quantidade = Integer.parseInt(this.tela.getQuantidade().getText());
            double valorUnidade = Double.parseDouble(tela.getValorUnidade().getText());
            
            if(quantidade < 0 || preco < 0 || valorUnidade<0) {
                throw new NumberFormatException();
            }
            
            Produto produto = new Produto("",0,0);
            
            int id = Integer.parseInt(tela.getTabelaProdutos().getValueAt(index, 0).toString());
            for(Produto i : tela.getListaProdutos().getProdutosEmEstoque()) {
                if(i.getId()==id) {
                    produto = i;
                    break;
                }
            }
            
            String descricao = tela.getDescricao().getText();
            String tipo = tela.getTipoProduto().getSelectedItem().toString();
            String localizacao = tela.getLocalizacao().getText();
            String fornecedor = tela.getFornecedor().getText();
            
            String unidadeMedida = tela.getUnidadeMedida().getSelectedItem().toString();
            
            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setQuantidade(quantidade);
            produto.setDescricao(descricao);
            produto.setTipo(tipo);
            produto.setLocalizacaoNoEstoque(localizacao);
            produto.setFornecedor(fornecedor);
            produto.setPesoVolume(valorUnidade);
            produto.setUnidadeMedida(unidadeMedida);
            
            DefaultTableModel model = (DefaultTableModel) this.tela.getTabelaProdutos().getModel();
            model.addRow(new Object[]{produto.getId(), nome, preco, quantidade});
            model.removeRow(index);
            this.tela.getTabelaProdutos().setModel(model);
            
            tela.getNomeProduto().setText("");
            tela.getNomeProduto().setBackground(Color.white);
            tela.getPreco().setText("");
            tela.getPreco().setBackground(Color.white);
            tela.getQuantidade().setText("");
            tela.getQuantidade().setBackground(Color.white);
            tela.getTipoProduto().setSelectedIndex(0);
            tela.getValorUnidade().setText("");
            tela.getUnidadeMedida().setSelectedIndex(0);
            tela.getFornecedor().setText("");
            tela.getLocalizacao().setText("");
            tela.getDescricao().setText("");
            
            tela.getAtualizar().setEnabled(false);
            tela.getAdicionarNoEstoque().setEnabled(true);
            tela.getEditarBtn().setEnabled(true);
            
            this.tela.repaint();
        }
        catch (NumberFormatException err) {
            tela.getPreco().setBackground(new Color(254,57,57));
            tela.getQuantidade().setBackground(new Color(254,57,57));
        }
    }
    
    
}
