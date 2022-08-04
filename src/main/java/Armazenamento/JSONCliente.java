//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
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
        java.lang.reflect.Type funcionariosTipo = new TypeToken<ArrayList<Cliente>>() {
        }.getType();
        List<Cliente> clientes = gson.fromJson(conteudo, funcionariosTipo);

        return clientes;
    }
}
