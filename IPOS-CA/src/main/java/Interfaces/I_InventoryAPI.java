package Interfaces;
import IPOS_CA_ORD.Product;

import java.util.List;

public interface I_InventoryAPI {
	/**
	 * Purpose : this method will be used by the IPOS-PU subsystem to retrieve the
	 * catalogue of products at the merchants store/warehouse
	 *
	 * @return the catalogue of products as a list
	 */
	List<Product> getCatalogue();

	/**
	 * Purpose : gets the details of the product associated with the product
	 * with the specified ID, from the merchants inventory
	 *
	 * @param productId - the ID of the concerned product
	 *
	 * @return the details of the product as a string
	 */
	String getProductDetails(String productId);

	/**
	 * Purpose : this method serves the purpose of checking the availability
	 * of a quantity of product, in the merchants inventory
	 *
	 * @param productId - the ID of the concerned product
	 * @param qty - the quantity of the product to check for availability
	 *
	 * @return a boolean value representing the availability
	 */
	boolean getStockAvailability(String productId, int qty);

	/**
	 * Purpose : this method is to be used to decrease the stock amount of a product
	 * in the merchants inventory, when a customer orders a product through the IPOS-PU
	 *
	 * @param productId - the ID of the product ordered
	 * @param qty - the quantity that the stock amount needs to be reduced by
	 *
	 * @return returns true if it was successful or else false
	 */
	boolean decreaseStock(String productId, int qty);

}
