/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
    
}
