package coupling01.introduce.parameter.object;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3>SMELL: Data Clump</h3>
 * <ul>
 *   <li> Your methods contain a repeating group of parameters.
 * </ul>
 * <h3>TREATMENT: Introduce Parameter Object</h3>
 * <ul>
 *   <li> Replace these parameters with an object.
 * </ul>
 */

class Account {
	// ...
	private final List<Transaction> transactions = new ArrayList<>();

	public double getFlowBetween(LocalDate start, LocalDate end) {
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
	private final LocalDate chargeDate;
	private final double value;

	public Transaction(double value, LocalDate chargeDate) {
		this.value = value;
		this.chargeDate = chargeDate;
	}

	public LocalDate getDate() {
		return chargeDate;
	}

	public double getValue() {
		return value;
	}
}
