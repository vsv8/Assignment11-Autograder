
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoneyStackTest {

    private MoneyStack moneyStack;
    private Money money2k;
    private Money money4k;


    @Before
    public void constructMoneyTestObjects() {
        money2k = new Money(2000);
        money4k = new Money(4000);

    }

    @Before
    public void constructMoneyStackTestObjects() {
        moneyStack = new MoneyStack();
    }

    @Test
    public void isFull() {
        for (int i = 0; i < moneyStack.getCapacity(); i++) {
            assertTrue(!moneyStack.isFull());
            assertFalse(moneyStack.isFull());
            moneyStack.push(money2k);
        }
        assertTrue(moneyStack.isFull());
        moneyStack.pop();
    }

    @Test
    public void pushAndPop() {
        moneyStack.push(money2k);
        assertEquals(2000,moneyStack.pop().getAmount());
        moneyStack.push(money2k);
        moneyStack.push(money4k);
        assertEquals(4000,moneyStack.pop().getAmount()) ;
        assertSame(money2k,moneyStack.pop());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testExceptionPop() {
        moneyStack.pop();
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void testExceptionPush(){
        for (int i = 0; i < 11; i++) {
            moneyStack.push(money2k);
        }
    }

    @Test
    public void isEmpty() {
        assertTrue(moneyStack.isEmpty() == true);
        assertFalse(moneyStack.isEmpty() == false);
        moneyStack.push(money2k);
        assertTrue(moneyStack.isEmpty() == false);
        assertFalse(moneyStack.isEmpty() == true);
    }

    @Test
    public void getCapacity() {
        assertEquals(moneyStack.getCapacity(), 10);
    }

    @Test
    public void getCurrentSize() {
        assertEquals(moneyStack.getCurrentSize(), 0);
        for (int i = 0; i < 3; i++) {
            moneyStack.push(money2k);
        }
        assertEquals(moneyStack.getCurrentSize(),3);
    }

}