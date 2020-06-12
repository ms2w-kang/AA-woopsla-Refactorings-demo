package dry03.introduce.polymorphic.creation.with.factory.method;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MobileTest {

    @Test
    public void should_create_toys() throws Exception {

        SeoulMobileFactory seoulMobileFactory = new SeoulMobileFactory();
        SSMobileProduct product1 = seoulMobileFactory.produceMobile("Thunder");

        assertEquals(500d, product1.getPrice(), 0.0);

        TokyoMobileFactory tokyoMobileFactory = new TokyoMobileFactory();
        SSMobileProduct product2 = tokyoMobileFactory.of("Plus");

        assertEquals(250d, product2.getPrice(), 0.0);
    }
}
