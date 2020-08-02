package dry04.form.template.method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportGeneratorTest {

    private final List<Customer> customers = new ArrayList<>();

    @BeforeEach
    void init() {
        prepareCustomers();
    }

    @Test
    void test_SimpleReportGenerator() {
        // Arrange (Given)
        var expected = "고객의 수: 5 명\n" +
                "홍길동: 150\n" +
                "우수한: 350\n" +
                "부족한: 50\n" +
                "훌륭한: 450\n" +
                "최고의: 550\n";
        var generator = new SimpleReportGenerator();

        // Act (When)
        String report = generator.generate(customers);

        // Assert (Then)
        assertEquals(expected, report);
    }

    @Test
    void test_ComplexReportGenerator() {
        // Arrange (Given)
        var expected = "고객의 수: 4 명\n" +
                "홍길동: 150\n" +
                "우수한: 350\n" +
                "훌륭한: 450\n" +
                "최고의: 550\n" +
                "점수 합계: 1550";
        var generator = new ComplexReportGenerator();

        // Act (When)
        String report = generator.generate(customers);

        // Assert (Then)
        assertEquals(expected, report);
    }

    private void prepareCustomers() {
        customers.add(new Customer("홍길동", 150));
        customers.add(new Customer("우수한", 350));
        customers.add(new Customer("부족한", 50));
        customers.add(new Customer("훌륭한", 450));
        customers.add(new Customer("최고의", 550));
    }
}
