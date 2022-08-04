//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
package Controller.TelaVendas;

import Model.client.Cliente;
import TratamentoErro.CpfException;
import View.CadastrarCliente;
import View.TelaVendas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author SuvacoDeCobra
 */
public class CadastrarClienteBtn implements ActionListener {

    private CadastrarCliente telaCliente;
    private TelaVendas tela;

    public CadastrarClienteBtn(CadastrarCliente telaPrincipal, TelaVendas tela) {
        this.telaCliente = telaPrincipal;
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(Cliente i : this.tela.getClienteList().getClientesCadastrados()) {
            System.out.println(i.getNome() + " " + i.getCpf());
        }
        String nome = this.telaCliente.getNome().getText();
        String cpf = this.telaCliente.getCpf().getText();
        try {
            cpfContemLetras(cpf);
            cpfUsado(cpf, this.tela.getClienteList().getClientesCadastrados());
            Cliente cliente = new Cliente(nome,cpf);
            this.tela.getClienteList().getClientesCadastrados().add(cliente);
            this.telaCliente.getCpf().setBackground(Color.WHITE);
            
            this.telaCliente.add(new JLabel("Cliente Cadastrado!"));
            
            
        } catch (CpfException err) {
            this.telaCliente.getCpf().setBackground(new Color(254, 57, 57));
        }
    }

    private void cpfContemLetras(String t) throws NumberFormatException {
        // passado para double para caber todos os números
        Double.parseDouble(t);
    }

    private void cpfUsado(String t, List<Cliente> lista) throws CpfException {
        for (Cliente f : lista) {
            if (f.getCpf().equals(t)) {
                throw new CpfException("CPF já está em uso!!");
            }
        }
    }
}

