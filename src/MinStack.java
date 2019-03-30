import java.util.LinkedList;

public class MinStack {
    private LinkedList<Integer> stack = new LinkedList<>();
    private LinkedList<Pair> minStack = new LinkedList<>();
    public void offer(int value) {
        stack.offerFirst(value);
        if (minStack.isEmpty()) {
            minStack.offerFirst(new Pair(value, 0));
        } else {
            if (value < minStack.peekFirst().getValue()) {
                minStack.offerFirst(new Pair(value, stack.size() - 1));
            }
        }
    }
    public Integer poll() {
        if (stack.isEmpty()) {
            return null;
        }
        int value = stack.pollFirst();
        if (value == minStack.peekFirst().getValue() && minStack.peekFirst().getIndex() >= stack.size()) {
            minStack.pollFirst();
        }
        return value;
    }
    public Integer min() {
        if (minStack.isEmpty()) {
            return null;
        }
        return minStack.peekFirst().getValue();
    }
    public boolean isEmpty() {
        return stack.size() == 0;
    }
}
class Pair {
    private int value;
    private int index;
    Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
    public int getValue() {
        return value;
    }
    public int getIndex() {
        return index;
    }
}
