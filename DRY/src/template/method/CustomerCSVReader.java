/*
 * 1. Instantiate and initialize a Reader to read from a CSV file.
 * 2. Read each line and break it up into tokens.
 * 3. Unmarshal the tokens from each line into an entity, either a Product or a Customer.
 * 4. Add each entity into a Set.
 * 5. Return the Set.
 */
package template.method;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CustomerCSVReader
{
	Set<Customer> getAll(File file) throws IOException
	{
		Set<Customer> returnSet = new HashSet<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file)))
		{
			String line = reader.readLine();
			while (line != null && !line.trim().equals(""))
			{
				String[] tokens = line.split("\\s*,\\s*");
				Customer customer = new Customer(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3]);
				returnSet.add(customer);
				line = reader.readLine();
			}
		}
		return returnSet;
	}
}
