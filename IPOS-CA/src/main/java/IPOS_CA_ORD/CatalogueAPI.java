package IPOS_CA_ORD;

import Interfaces.I_CatalogueAPI;

import java.util.ArrayList;

public class CatalogueAPI implements I_CatalogueAPI {

    public CatalogueAPI(){}

    /**
     * Purpose : this method will be used to get the catalogue of products offered by Info-Pharma
     *
     * @return the product catalogue as a list of product type
     */
    @Override
    public ArrayList<Product> getCatalogue() {

        ArrayList<Product> n = new ArrayList<>();
        n.add(new Product(100001, "Paracetamol",
                "box", "Caps", 20, 0.10, 10345));

        return n;
    }

    /**
     * Purpose : gets the details of the product associated with the product
     * with the specified ID
     *
     * @param productId - the ID of the concerned product
     * @return the details of the product as a string
     */
    @Override
    public String getProductDetails(String productId) {
        return "";
    }

    /**
     * Purpose : this method serves the purpose of checking the availability
     * of a quantity of product, at Info-Pharma
     *
     * @param productId - the ID of the concerned product
     * @param qty       - the quantity of the product to check for availability
     * @return a boolean value representing the availability
     */
    @Override
    public boolean getStockAvailability(String productId, int qty) {
        return false;
    }
}
