//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
package Controller.LoginEntrar;

import Model.employee.Funcionario;
import View.Login;
import View.TelaVendas;
import View.produtoFuncionario.CadastroProdutoFuncionario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ice
 */
public class Entrar implements ActionListener {
    Login tela;

    public Entrar(Login tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("teste");
        for(Funcionario i : tela.getFuncionariosContratados().getFuncionariosContratados()) {
            if(i.getNome().equals(tela.getTfNome().getText()) && i.getSenha().equals(String.copyValueOf(tela.getTfSenha().getPassword()))) {
                System.out.println("Entrou!");
                if(i.isAdmin()) {
                    this.tela.dispose();
                    CadastroProdutoFuncionario tela = new CadastroProdutoFuncionario(i.getRegistro());
                    tela.montaTela();
                }
                else {
                    this.tela.dispose();
                    TelaVendas tela = new TelaVendas();
                    tela.montaTela();
                }
            }
        }
    }

    
}
