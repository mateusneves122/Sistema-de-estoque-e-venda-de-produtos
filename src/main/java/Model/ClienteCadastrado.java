//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
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

    public void setClientesCadastrados(List<Cliente> clientesCadastrados) {
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
