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
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ProductCSVReader
{
	Set<Product> getAll(File file) throws IOException
	{
		Set<Product> returnSet = new HashSet<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file)))
		{
			String line = reader.readLine();
			while (line != null && !line.trim().equals(""))
			{
				String[] tokens = line.split("\\s*,\\s*");
				Product product = new Product(Integer.parseInt(tokens[0]), tokens[1], new BigDecimal(tokens[2]));
				returnSet.add(product);
				line = reader.readLine();
			}
		}
		return returnSet;
	}
}
