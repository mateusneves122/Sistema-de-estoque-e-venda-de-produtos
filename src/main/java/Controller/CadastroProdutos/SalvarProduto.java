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
public class SalvarProduto implements ActionListener {
    private CadastroProdutoFuncionario tela;

    public SalvarProduto(CadastroProdutoFuncionario tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String nome = this.tela.getNomeProduto().getText();
            double preco = toDouble(this.tela.getPreco().getText());
            int quantidade = toInt(this.tela.getQuantidade().getText());
            double unidadeQtd = Double.parseDouble(tela.getValorUnidade().getText());
            
            if(quantidade < 0 || preco < 0 || unidadeQtd < 0) {
                throw new NumberFormatException();
            }
            
            String descricao = tela.getDescricao().getText();
            String tipo = tela.getTipoProduto().getSelectedItem().toString();
            String localizacao = tela.getLocalizacao().getText();
            String fornecedor = tela.getFornecedor().getText();
            
            String unidadeMedida = tela.getUnidadeMedida().getSelectedItem().toString();
            
            Produto produto = new Produto(nome, preco, quantidade);
            
            produto.setDescricao(descricao);
            produto.setTipo(tipo);
            produto.setLocalizacaoNoEstoque(localizacao);
            produto.setFornecedor(fornecedor);
            produto.setPesoVolume(unidadeQtd);
            produto.setUnidadeMedida(unidadeMedida);
            
            // Adicionar produto no estoque:
            tela.getListaProdutos().getProdutosEmEstoque().add(produto);
            
            DefaultTableModel model = (DefaultTableModel) this.tela.getTabelaProdutos().getModel();
            model.addRow(new Object[]{produto.getId(), nome, preco, quantidade});
            
            this.tela.getTabelaProdutos().setModel(model);
            
            tela.getNomeProduto().setText("");
            tela.getNomeProduto().setBackground(Color.white);
            
            tela.getPreco().setText("");
            tela.getPreco().setBackground(Color.white);
            
            tela.getQuantidade().setText("");
            tela.getQuantidade().setBackground(Color.white);
            
            tela.getTipoProduto().setSelectedIndex(0);
            tela.getValorUnidade().setText("");
            tela.getValorUnidade().setBackground(Color.white);
                    
            tela.getUnidadeMedida().setSelectedIndex(0);
            tela.getFornecedor().setText("");
            tela.getLocalizacao().setText("");
            tela.getDescricao().setText("");
            
            tela.getEditarBtn().setEnabled(true);
            
            this.tela.repaint();
        }
        catch (NumberFormatException err) {
            tela.getPreco().setBackground(new Color(254,57,57));
            tela.getQuantidade().setBackground(new Color(254,57,57));
            tela.getValorUnidade().setBackground(new Color(254,57,57));
        }
    }
    
    private Double toDouble(String preco) throws NumberFormatException {
        Double number1 = Double.parseDouble(preco);
        return number1;
    }
    
    private int toInt(String qtd) throws NumberFormatException {
        int number2 = Integer.parseInt(qtd);
        return number2;
    }
}
