package IPOS_CA_ORD;

import java.util.ArrayList;

public class OrderManager {

    static final CatalogueAPI catalogueApi= new CatalogueAPI();
    static final OrderAPI orderAPI= new OrderAPI();
    static Catalogue productCatalogue;
    static ArrayList<Order> draftOrders;

    private Order draftOrderInFocus;

    public OrderManager(Order ord){
        this.draftOrderInFocus = ord;
    }

    public boolean getCatalogue(){
        try{
            productCatalogue = new Catalogue(catalogueApi.getCatalogue());
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public void createDraftOrder(){
        Order newOrder = new Order();
        OrderManager.draftOrders.add(newOrder);
        this.getCatalogue();
    }

    public void addItemToOrd(int productID, int quantity){
        Product product = OrderManager.productCatalogue.getProduct(productID);
        this.draftOrderInFocus.addProduct(product);
    }

    public void removeItemFromOrd(int productID){
        Product product = OrderManager.productCatalogue.getProduct(productID);
        this.draftOrderInFocus.removeProduct(product);
    }


}
