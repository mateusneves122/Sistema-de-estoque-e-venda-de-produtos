//Yan Messias de Azevedo Fonseca - 202165153A
//Denis Freesz Vianello          - 202076020
//Matheus Neves dos Santos       - 2020655569C

package Model;

import java.util.ArrayList;
import java.util.List;

import Model.product.*;



public class Estoque {

    List<Produto> produtosEmEstoque = new ArrayList<>();

    public void addProduct(Produto product) {
        produtosEmEstoque.add(product);
    }

    public void removeProductId(int id) {

        if (this.checkIfThereIsOnlyOneElementInTheList()) {
            this.removeFirstProduct();
        } else if (!this.produtosEmEstoque.isEmpty()) {
            Produto p;
            for (int i = 0; i < produtosEmEstoque.size(); i++) {
                p = produtosEmEstoque.get(i);
                System.out.println("ID: " + p.getId());
                if (p.getId() == id) {
                    produtosEmEstoque.remove(p);
                    break;
                }
            }
        }
    }

    private boolean checkIfThereIsOnlyOneElementInTheList() {
        if (produtosEmEstoque.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    private void removeFirstProduct() {
        this.produtosEmEstoque.remove(0);
    }

    public void editProductAmount(int id, int new_amount) {
        for (Produto p : produtosEmEstoque) {
            if (p.getId() == id) {
                p.setQuantidade(new_amount);
            }
        }
    }

    public void editProductPrice(int id, double new_price) {
        for (Produto p : produtosEmEstoque) {
            if (p.getId() == id) {
                p.setPreco(new_price);
            }
        }
    }

    public void inventoryPrint() {
        for (Produto p : produtosEmEstoque) {
            System.out.println("Name: " + p.getNome() + " ID: " + p.getId()
                    + " Price: " + p.getPreco() + " Amount: " + p.getQuantidade());
        }
    }

}
