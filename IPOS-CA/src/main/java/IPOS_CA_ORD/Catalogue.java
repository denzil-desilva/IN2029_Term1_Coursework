package IPOS_CA_ORD;

import java.util.ArrayList;
import java.util.Hashtable;

public class Catalogue {

    private ArrayList<Product> products = new ArrayList<>();

    public Catalogue(ArrayList<Product> productList) {

        this.products = productList;
    }

    public Product getProduct(int productID){
        return this.products.get(productID);
    }

}
