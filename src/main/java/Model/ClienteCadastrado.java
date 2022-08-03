/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.client.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SuvacoDeCobra
 */
public class ClienteCadastrado {
    private List<Cliente> clientesCadastrados;

    public ClienteCadastrado() {
        this.clientesCadastrados = new ArrayList<>();
    }

    public List<Cliente> getClientesCadastrados() {
        return clientesCadastrados;
    }

    public void setClientesCadastrados(List<Cliente> funcionariosContratados) {
        this.clientesCadastrados = clientesCadastrados;
    }

    private boolean checkIfThereIsOnlyOneElementInTheList() {
        if (clientesCadastrados.size() == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    private void removeFirstClient() {
        this.clientesCadastrados.remove(0);
    }
    
}
