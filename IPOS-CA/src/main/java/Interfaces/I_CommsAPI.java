package Interfaces;

public interface I_CommsAPI {

	/**
	 * Purpose : can be used by IPOS-SA and IPOS-CA to send emails to customers and to send
	 * invoices and reminders digitally. Also, can be used to send general purpose emails.
	 *
	 * @param recipientEmail - the email of the intended recipient
	 * @param subject - the main subject of the email
	 * @param body - the actual content that needs to be sent
	 */
	void sendEmail(String recipientEmail, String subject, String body);

	/**
	 * Purpose : this method will be used to send emails to customers who
	 * have applied to register for an account with the merchant
	 *
	 * @param recipientEmail - the email of the customer who has registered for an account
	 * @param username - the username created for the customer
	 * @param tempPass -  a temporary password for the customer for the initial log in
	 */
	void sendRegistrationEmail(String recipientEmail, String username, String tempPass);

	/**
	 * Purpose : method used to send confirmation emails to merchants and customers
	 * so that they are notified and are provided with the tracking code
	 *
	 * @param recipientEmail - the email of the customer who placed the order
	 * @param orderId - the ID of the order that has been placed
	 * @param trackingCode - a code that can be used to check and get updates on the order
	 */
	void sendOrderConfirmationEmail(String recipientEmail, String orderId, String trackingCode);

}