package Interfaces;

import java.util.Date;
import java.util.Map;

public interface I_OrderAPI {

	/**
	 * Purpose : this method will be used to order stock from Info-Pharma,
	 * by the merchant
	 *
	 * @param merchantId - the ID of the merchant ordering stock
	 * @param itemAndAmountList - the items to order and the respective quantity
	 *
	 * @return the order ID generated as a string value
	 */
	String placeOrder(String merchantId, Map<String, Integer> itemAndAmountList);

	/**
	 * Purpose : this method is responsible for providing the status of the order to
	 * the merchant
	 *
	 * @param orderId - the ID of the order to track
	 *
	 * @return the status of the order as a string value
	 */
	String trackOrder(String orderId);

	/**
	 * Purpose : this method gets the amount of credit left that can be used by the
	 * merchant
	 *
	 * @param merchantId - the ID of the merchant of whose credit balance is required
	 *
	 * @return the amount of credit left as a double value
	 */
	double queryBalance(String merchantId);

	/**
	 * Purpose : the merchant will use this method, to retrieve previous orders that it placed
	 * with Info-Pharma, in the specified date range
	 *
	 * @param merchantId - the ID of the merchant who is enquiring
	 * @param startDate - the start date of the range
	 * @param endDate - the end date of the range
	 *
	 * @return details about previous orders as a JSON formatted string
	 */
	String viewPreviousOrders(String merchantId, Date startDate, Date endDate);

	/**
	 * Purpose : used to log in with the Info-Pharma, by the merchant
	 *
	 * @param username - the username of the merchant
	 * @param password - the password associated with the username
	 *
	 * @return a boolean value confirming successful log in or not
	 */
	boolean merchantLogin(String username, String password);

	/**
	 * Purpose : the merchant will use this method to get the details of the order that they
	 * have placed with Info-Pharma
	 *
	 * @param orderId - the ID of the order that is of concern
	 *
	 * @return the details of the order as a string
	 */
	String getOrderDetails(String orderId);

	/**
	 * Purpose : this method will be used to get the invoice generated for the order
	 * from IPOS-SA
	 *
	 * @param orderId - the ID of the order to get the invoice for
	 *
	 * @return the invoice for the order as a JSON formated string
	 */
	String getInvoice(String orderId);
	
	/**
	 * Purpose : to end the session with IPOS-SA which was started
	 * by merchantLogin()
	 */
	void disconnect();

}