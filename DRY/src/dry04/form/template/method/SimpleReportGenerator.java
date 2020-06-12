package dry04.form.template.method;

import java.util.List;

public class SimpleReportGenerator {
    public String generate(List<Customer> customers) {

        String report = String.format("고객의 수: %d 명\n", customers.size());

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            report += String.format("%s: %d\n", customer.getName(),
                customer.getPoint());
        }

        return report;
    }

}

