package Interfaces;
import IPOS_CA_ORD.Product;

import java.util.List;

public interface I_CatalogueAPI {

	/**
	 * Purpose : this method will be used to get the catalogue of products offered by Info-Pharma
	 *
	 * @return the product catalogue as a list of product type
	 */
	List<Product> getCatalogue();

	/**
	 * Purpose : gets the details of the product associated with the product
	 * with the specified ID
	 *
	 * @param productId - the ID of the concerned product
	 *
	 * @return the details of the product as a string
	 */
	String getProductDetails(String productId);

	/**
	 * Purpose : this method serves the purpose of checking the availability
	 * of a quantity of product, at Info-Pharma
	 *
	 * @param productId - the ID of the concerned product
	 * @param qty - the quantity of the product to check for availability
	 *
	 * @return a boolean value representing the availability
	 */
	boolean getStockAvailability(String productId, int qty);

}
