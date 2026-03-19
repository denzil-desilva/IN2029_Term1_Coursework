package IPOS_CA_ORD;

import java.util.ArrayList;
import java.util.Hashtable;

public class Catalogue {

    private final Hashtable<Integer, Product> products = new Hashtable<>();

    public Catalogue(ArrayList<Product> productList) {

        for (Product item : productList){
            if (item != null) {
                this.products.put(item.getProductId(), item);
            }
        }
    }

    public Product getProduct(int productID){
        return this.products.get(productID);
    }

}
