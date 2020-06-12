package dry04.form.template.method;

import java.util.ArrayList;
import java.util.List;

public class ComplexReportGenerator {
    public String generate(List<Customer> customers) {
        List<Customer> selectedCustomers = new ArrayList<>();

        for (Customer customer : customers)
            if (customer.getPoint() >= 100)
                selectedCustomers.add(customer);

        String report = String.format("고객의 수: %d 명\n",
                selectedCustomers.size());

        for (int i = 0; i < selectedCustomers.size(); i++) {
            Customer customer = selectedCustomers.get(i);
            report += String.format("%s: %d\n", customer.getName(),
                    customer.getPoint());
        }

        int totalPoint = 0;
        for (Customer customer : customers)
            totalPoint += customer.getPoint();
        report += String.format("점수 합계: %d", totalPoint);

        return report;
    }
}

