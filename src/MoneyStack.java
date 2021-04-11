import java.util.Observable;
import java.util.Observer;

public class MoneyStack {
	private static final int theCapacity = 10;
	private Money[] theStack;
	private int nextPushLocation; // Location in theStack array, where next push
									// will insert. 0 means: stack is empty.

	public MoneyStack() {
		theStack = new Money[MoneyStack.theCapacity];
		nextPushLocation = 0;
	}

	public boolean isFull() {
		if (nextPushLocation == theCapacity) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty() {
		if (nextPushLocation == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void push(Money element) throws ArrayIndexOutOfBoundsException {
		theStack[nextPushLocation++] = element;
	}

	public Money pop() throws ArrayIndexOutOfBoundsException {
		return theStack[--nextPushLocation];
	}

	public int sum() {
		int currentSum = 0;
		for (int i = nextPushLocation-1; i >= 0; i--) {
			currentSum +=(theStack[i]).getAmount();
		}
		return currentSum;
	}

	public int getCapacity() {
		return theCapacity;
	}

	public int getCurrentSize() {
		int count = 0;
		for (int i = 0; i < theStack.length; i++) {
			if (theStack[i] == null) {
				return count;
			}
			count++;
		}
		return count;
	}
}
