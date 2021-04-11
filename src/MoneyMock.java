import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyMock {

    private Money money2k;
    private Money money4k;
    private Money mockMoney2k;
    private Money mockMoney4k;
    private MoneyStack moneyStack;

    @Before
    public void constructMock() {
        money2k = new Money(2000);
        money4k = new Money(4000);
        mockMoney2k = mock(Money.class);
        mockMoney4k = mock(Money.class);
        moneyStack = new MoneyStack();
    }

    @Test
    public void sum() {
        assertEquals(moneyStack.sum(), 0);
        moneyStack.push(money2k);
        assertEquals(moneyStack.sum(), 2000);
        moneyStack.push(money4k);
        assertEquals(moneyStack.sum(),6000);
    }

    @Test
    public void mockSum() {
        assertNotNull(money2k.getAmount());

        moneyStack.push(mockMoney2k);
        when(moneyStack.sum()).thenReturn(2000);
        assertEquals(moneyStack.sum(), 2000);
        verify(mockMoney2k).getAmount();

        moneyStack.push(mockMoney4k);
        when(moneyStack.sum()).thenReturn(6000);
        assertEquals(moneyStack.sum(), 6000);
        verify(mockMoney4k, times(2)).getAmount();
    }
}
