package IPOS_CA_ORD;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order{

    static int rawOrderNo = 1000;

    String orderID;
    String orderStatus;
    double orderTotal;
    LocalDateTime creationDateAndTime;
    ArrayList<Product> orderProducts = new ArrayList<>();
    int noOfProducts = 0;

//    when a draft order is required
    public Order(){

//        get the latest catalogue from Info-Pharma
        this.orderID = "OID" + Integer.toString(rawOrderNo);
        Order.rawOrderNo += 1;
        double orderTotal = 0;
        this.orderStatus = "draft";
        this.creationDateAndTime = LocalDateTime.now();
    }

//    when the order is retrieved from IPOS-SA
    public Order(String ID, String status){
        this.orderID = ID;
        this.orderStatus = status;
    }

    public String getOrderID(){
        return this.orderID;
    }

    public String getOrderStatus(){
        return this.orderStatus;
    }

    public double getOrderTotal(){return this.orderTotal;}

    public LocalDateTime getCreationDateAndTime(){return this.creationDateAndTime;}

    public int getNoOfProducts(){return this.noOfProducts;}

    public ArrayList<Product> getOrderProducts(){return this.orderProducts;}

    public void addProduct(Product product){

        int quantity = product.getQuantityRequired();

        if (quantity >= 1){

//            add the product to the list
            this.orderProducts.add(product);

//            the value of one pack x the quantity desired
            double stockValue = product.getPackCost() * quantity;
            this.orderTotal += stockValue;

            this.noOfProducts ++;

        }else{
            System.out.println("The quantity is invalid");
        }

    }

    public void removeProduct(Product product){

        int quantity = product.getQuantityRequired();
        this.orderProducts.remove(product);

//      the value of one pack x the quantity provided
        double stockValue = product.getPackCost() * quantity;
        this.orderTotal -= stockValue;

        this.noOfProducts --;
    }
}
