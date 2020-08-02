package coupling01.introduce.parameter.object;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {
    List<Transaction> testTransactions = List.of(
            new Transaction(100, LocalDate.of(2022, 1, 15)),
            new Transaction(100, LocalDate.of(2022, 3, 20)),
            new Transaction(100, LocalDate.of(2022, 7, 11)),
            new Transaction(100, LocalDate.of(2022, 9, 4)),
            new Transaction(100, LocalDate.of(2022, 12, 12))
            );

    @Test
    void test_getFlowBetween() {
        // Arrange (Given)
        Account account = new Account();
        testTransactions.forEach(account::add);

        // Act (When)
        double amounts = account.getFlowBetween(
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 12, 31));

        // Assert (Then)
        assertEquals(500.0, amounts, 0.1);
    }

}
