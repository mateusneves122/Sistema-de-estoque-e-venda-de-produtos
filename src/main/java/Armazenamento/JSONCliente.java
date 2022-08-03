/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Armazenamento;

import Model.client.Cliente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SuvacoDeCobra
 */
public class JSONCliente {
    public static String toJSON(Cliente cliente) {
        Gson gson = new Gson();
        String json = gson.toJson(cliente);
        return json;
    }

    public static String toJSON(List<Cliente> clientes) {
        Gson gson = new Gson();
        String json = gson.toJson(clientes);
        return json;
    }
    
    public static Cliente toCliente(String conteudo) {
        Gson gson = new Gson();
        Cliente cliente = gson.fromJson(conteudo, Cliente.class);

        return cliente;
    }

    public static List<Cliente> toClientes(String conteudo) {
        Gson gson = new Gson();
        java.lang.reflect.Type clientesTipo = new TypeToken<ArrayList<Cliente>>() {
        }.getType();
        List<Cliente> clientes = gson.fromJson(conteudo, clientesTipo);

        return clientes;
    }
}
