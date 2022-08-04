//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
package View;

import Controller.TelaVendas.CompraD;
import Interfaces.View;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FinalizarCompra extends JFrame implements View {
    private JPanel tela;
    private String totalPagar;
    private String metodoPagamento;
    private TelaVendas telaVenda;
    private boolean cadastroAtivo;
    
    public FinalizarCompra(String totalPagar, String metodoPagamento,TelaVendas t) {
        this.totalPagar = totalPagar;
        this.metodoPagamento = metodoPagamento;
        this.telaVenda = t;
        this.cadastroAtivo = t.verificaSeClienteTemCadastroCpf(t.getCPF());
    }
    
    private String getDesconto() {
        if(this.cadastroAtivo) {
            return "2%";
        } else{
            return "0%";
        }
    }
    
    @Override
    public void configuraJanela(){
        this.setSize(200, 120);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.tela = new JPanel();
        this.tela.setLayout(new BorderLayout());
        
        this.setLocationRelativeTo(null);
    }
    
    private void configuraFinalizarCompra() {
        JPanel jpFinalizarCompra = new JPanel();
        jpFinalizarCompra.setSize(300,600);
        
        jpFinalizarCompra.setLayout(new GridLayout(4,4));
        jpFinalizarCompra.add(new JLabel("Total a pagar: " + totalPagar));
        jpFinalizarCompra.add(new JLabel("Desconto: " + getDesconto()));
        jpFinalizarCompra.add(new JLabel("Metodo de pagamento: " + metodoPagamento));
        
        JButton btnConfimar = new JButton("Confirmar");
        btnConfimar.setPreferredSize(new Dimension(120,20));
        jpFinalizarCompra.add(btnConfimar);
        btnConfimar.addActionListener(new CompraD(telaVenda,this));
        
        this.add(jpFinalizarCompra, BorderLayout.WEST);
    }

    
    @Override
    public void mostraTela() {
        this.add(tela);
        this.setVisible(true);
    }

    @Override
    public void montaTela() {
        configuraJanela();
        configuraFinalizarCompra();
        mostraTela();
    }
}

  