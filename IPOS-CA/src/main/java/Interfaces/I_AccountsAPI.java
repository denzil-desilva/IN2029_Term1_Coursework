package Interfaces;

public interface I_AccountsAPI {

	/**
	 * Purpose : this method will be used to update the details associated
	 * with the respective merchants account on the IPOS-SA subsystem
	 *
	 * @param accountId - specifies the ID of the account that requires the update
	 * @param name - the name of the merchant
	 * @param address - the address of the merchant
	 * @param phone - the contact number of the merchant
	 *
	 * @return a boolean signaling if the update was successful or unsuccessful
	 */
	boolean updateAccountDetails(String accountId, String name, String address, String phone);

	/**
	 * Purpose : this method serves the purpose of retrieving the status of the
	 * merchants account
	 *
	 * @param accountId - specifies the ID of the concerned merchants account
	 *
	 * @return a string value that can be either 'normal', 'suspended' or 'in default'
	 */
	String getAccountStatus(String accountId);

	/**
	 * Purpose : this method will be used to supply the details of the payment,
	 * of an order, made to the IPOS-SA by the merchant
	 *
	 * @param accountId - the account ID of the merchant
	 * @param amount - the amount paid
	 * @param type - the mode that was used to make the payment
	 *
	 * @return a boolean signaling if the payment record was successful or unsuccessful
	 */
	boolean recordPayment(String accountId, double amount, PaymentType type);

	/**
	 * Purpose - get the amount of outstanding balance left to be paid
	 * by the merchant
	 *
	 * @param accountId - the account ID of the merchant
	 *
	 * @return the outstanding balance stored in IPOS-SA as a double value
	 */
	double getOutstandingBalance(String accountId);

}