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

    public static String toJSON(List<Employee> contatos) {
        Gson gson = new Gson();
        String json = gson.toJson(contatos);
        return json;
    }
    
    public static Employee toContato(String conteudo) {
        Gson gson = new Gson();
        Employee contato = gson.fromJson(conteudo, Employee.class);

        return contato;
    }

    public static List<Employee> toContatos(String conteudo) {
        Gson gson = new Gson();
        java.lang.reflect.Type funcionariosTipo = new TypeToken<ArrayList<Employee>>() {
        }.getType();
        List<Employee> contatos = gson.fromJson(conteudo, funcionariosTipo);

        return contatos;
    }
}
