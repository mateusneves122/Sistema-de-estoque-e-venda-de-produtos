//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
package Controller.TelaVendas;

import View.CompraCartao;
import View.FinalizarCompra;
import View.TelaVendas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import Model.Estoque;
/**
 *
 * @author SuvacoDeCobra
 */

public class FinalizarCompraBtn implements ActionListener {

    public static Estoque estoque;
    private TelaVendas telaVenda;
    private FinalizarCompra telaFinCompra;
    private CompraCartao telacartao;
    private String formaDePagamento;
    private double totalPagar;
    
    public FinalizarCompraBtn(TelaVendas tela) {
       this.telaVenda = tela;
       this.totalPagar = 0;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       JTable carrinho = this.telaVenda.getCarrinho();
       this.formaDePagamento = this.telaVenda.getFormaPagamentoToString();
       this.totalPagar = calculaTotal(carrinho);
       
       //Paramêtros para instancia a telFinCompra;
       if(this.telaVenda.getFormaPagamentoIndex() == 0){
           
           double desconto = 0;
           
           if(this.telaVenda.verificaSeClienteTemCadastroCpf(telaVenda.getCPF())){
                desconto = calculaDesconto(totalPagar);
                totalPagar -= desconto;
            }
           
           telaFinCompra = new FinalizarCompra(Double.toString(totalPagar), formaDePagamento,telaVenda);
           telaFinCompra.montaTela();
       }else{
           telacartao = new CompraCartao(Double.toString(totalPagar), formaDePagamento,telaVenda);
           telacartao.montaTela();
       }
       this.telaVenda.getCadastroClienteNome().setText("");
       this.telaVenda.getCadastroClienteCpf().setText("");
    }
        
    private double calculaTotal (JTable carrinho) {
       int totalRow = carrinho.getRowCount();
       double soma = 0;
       
       for(int i = 0;i < totalRow;i++) {
           double valor = (double)carrinho.getModel().getValueAt(i, 2);
           int quantidade = (int) carrinho.getModel().getValueAt(i, 3);
           soma += valor*(double)quantidade;
        }
       return soma;
    }
    
    private double calculaDesconto(double totalPagar) {
      return totalPagar*0.02;  
    }

    
}
