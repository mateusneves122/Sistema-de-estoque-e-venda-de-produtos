/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Armazenamento;

import Model.employee.Funcionario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yanfo
 */
public class JSONFuncionario {
    public static String toJSON(Funcionario funcionario) {
        Gson gson = new Gson();
        String json = gson.toJson(funcionario);
        return json;
    }

    public static String toJSON(List<Funcionario> funcionarios) {
        Gson gson = new Gson();
        String json = gson.toJson(funcionarios);
        return json;
    }
    
    public static Funcionario toFuncionario(String conteudo) {
        Gson gson = new Gson();
        Funcionario funcionario = gson.fromJson(conteudo, Funcionario.class);

        return funcionario;
    }

    public static List<Funcionario> toFuncionarios(String conteudo) {
        Gson gson = new Gson();
        java.lang.reflect.Type funcionariosTipo = new TypeToken<ArrayList<Funcionario>>() {
        }.getType();
        List<Funcionario> funcionarios = gson.fromJson(conteudo, funcionariosTipo);

        return funcionarios;
    }
}
