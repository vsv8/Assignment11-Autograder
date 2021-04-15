import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MoneyTest {

    private MoneyStack moneyStack;
    private Money money2k;
    private Money money4k;
    private Money money6k;
    private Money money2k2;



    @Before
    public void constructMoneyTestObjects() {
        money2k = new Money(2000);
        money4k = new Money(4000);
        money6k = new Money(6000);
        money2k2 = new Money(2000);


    }

    @Before
    public void constructMoneyStackTestObjects() {
        moneyStack = new MoneyStack();
    }
    @Test
    public void testAdd() {
        assertEquals(money6k, money2k.add(money4k));
    }

    @Test
    public void testEquals() {
        assertTrue(money2k2.equals(money2k));
        assertTrue(money2k.equals(money2k2));
        assertFalse(money4k.equals(money6k));
    }
    @Test
    public void testString() {
    assertEquals(money6k.toString(),"6000");
    assertEquals(money4k.toString(), "4000");
    }


}
