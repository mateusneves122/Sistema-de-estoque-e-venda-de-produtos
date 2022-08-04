//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
package Controller.TelaVendas;

import View.CompraCartao;
import View.TelaVendas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PICHAU
 */
public class ValidaCartao extends LimpaCarrinho implements ActionListener{
    private TelaVendas tela;
    private CompraCartao nCartao;
   // private CompraCartao mensagem;

    public ValidaCartao(TelaVendas tela, CompraCartao nCartao) {
        this.tela = tela;
        this.nCartao = nCartao;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String k = nCartao.getnCartao().getText();
            int j = k.length();
            System.out.println(j);
            if(j >= 13 && j<= 16){
                limpar(tela);
                nCartao.dispose();
            }            
        }catch(RuntimeException a){
            
        }
    }
    
}
