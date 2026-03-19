package IPOS_CA_ORD;

import Interfaces.I_OrderAPI;

import java.util.Date;
import java.util.Map;

public class OrderAPI implements I_OrderAPI {

    public OrderAPI(){};

    @Override
    public String placeOrder(String merchantId, Map<String, Integer> itemAndAmountList) {
        return "";
    }

    @Override
    public String trackOrder(String orderId) {
        return "";
    }

    @Override
    public double queryBalance(String merchantId) {
        return 0;
    }

    @Override
    public String viewPreviousOrders(String merchantId, Date startDate, Date endDate) {
        return "";
    }

    @Override
    public boolean merchantLogin(String username, String password) {
        return false;
    }

    @Override
    public String getOrderDetails(String orderId) {
        return "";
    }

    @Override
    public String getInvoice(String orderId) {
        return "";
    }

    @Override
    public void disconnect() {

    }
}
