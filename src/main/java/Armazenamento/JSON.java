/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armazenamento;

import Model.employee.Employee;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yanfo
 */
public class JSON {
    public static String toJSON(Employee funcionario) {
        Gson gson = new Gson();
        String json = gson.toJson(funcionario);
        return json;
    }

    public static String toJSON(List<Employee> funcionarios) {
        Gson gson = new Gson();
        String json = gson.toJson(funcionarios);
        return json;
    }
    
    public static Employee toFuncionario(String conteudo) {
        Gson gson = new Gson();
        Employee contato = gson.fromJson(conteudo, Employee.class);

        return contato;
    }

    public static List<Employee> toFuncionarios(String conteudo) {
        Gson gson = new Gson();
        java.lang.reflect.Type funcionariosTipo = new TypeToken<ArrayList<Employee>>() {
        }.getType();
        List<Employee> funcionarios = gson.fromJson(conteudo, funcionariosTipo);

        return funcionarios;
    }
}
