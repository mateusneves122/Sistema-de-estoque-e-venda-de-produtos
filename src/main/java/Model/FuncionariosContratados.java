//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
package Model;

import Model.employee.Funcionario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yanfo
 */
public class FuncionariosContratados {
    private List<Funcionario> funcionariosContratados;

    public FuncionariosContratados() {
        this.funcionariosContratados = new ArrayList<>();
    }

    public List<Funcionario> getFuncionariosContratados() {
        return funcionariosContratados;
    }

    public void setFuncionariosContratados(List<Funcionario> funcionariosContratados) {
        this.funcionariosContratados = funcionariosContratados;
    }
    
    public void removeRegistroFuncionario(int id) {

        if (this.checkIfThereIsOnlyOneElementInTheList()) {
            this.removeFirstEmployee();
        } else if (!this.funcionariosContratados.isEmpty()) {
            Funcionario p;
            for (int i = 0; i < funcionariosContratados.size(); i++) {
                p = funcionariosContratados.get(i);
                if (p.getRegistro() == id) {
                    funcionariosContratados.remove(p);
                    break;
                }
            }
        }
    }

    private boolean checkIfThereIsOnlyOneElementInTheList() {
        if (funcionariosContratados.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    private void removeFirstEmployee() {
        this.funcionariosContratados.remove(0);
    }
}
