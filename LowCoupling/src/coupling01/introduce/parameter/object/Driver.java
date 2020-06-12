/*
 * SMELL: Data Clump
 *   -- Your methods contain a repeating group of parameters.
 * 
 * TREATMENT: Introduce Parameter Object
 *   -- Replace these parameters with an object.
 */
package coupling01.introduce.parameter.object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Account {
	// ...
	private List<Transaction> transactions = new ArrayList<>();

	public double getFlowBetween(Date start, Date end) {
		double result = 0;

		for (Transaction each : transactions) {
			if (each.getDate().compareTo(start) >= 0 && 
					each.getDate().compareTo(end) <= 0) {
				result += each.getValue();
			}
		}
		return result;
	}
	
	public void add(Transaction transaction) {
		transactions.add(transaction);
	}
}

class Transaction {
	private Date chargeDate;
	private double value;

	public Transaction(double value, Date chargeDate) {
		this.value = value;
		this.chargeDate = chargeDate;
	}

	public Date getDate() {
		return chargeDate;
	}

	public double getValue() {
		return value;
	}
}
