//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C
package Armazenamento;

import Model.product.Produto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yanfo
 */
public class JSONProduto {
    public static String toJSON(Produto funcionario) {
        Gson gson = new Gson();
        String json = gson.toJson(funcionario);
        return json;
    }

    public static String toJSON(List<Produto> funcionarios) {
        Gson gson = new Gson();
        String json = gson.toJson(funcionarios);
        return json;
    }
    
    public static Produto toProduto(String conteudo) {
        Gson gson = new Gson();
        Produto produtos = gson.fromJson(conteudo, Produto.class);

        return produtos;
    }

    public static List<Produto> toProdutos(String conteudo) {
        Gson gson = new Gson();
        java.lang.reflect.Type funcionariosTipo = new TypeToken<ArrayList<Produto>>() {
        }.getType();
        List<Produto> produto = gson.fromJson(conteudo, funcionariosTipo);

        return produto;
    }
}
