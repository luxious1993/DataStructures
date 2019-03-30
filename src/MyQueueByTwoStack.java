import java.util.LinkedList;

public class MyQueueByTwoStack implements MyQueue {
    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;
    private LinkedList<Integer> minStack;
    public MyQueueByTwoStack() {
        this.stack1 = new LinkedList<>();
        this.stack2 = new LinkedList<>();
    }
    @Override
    public void offer(int value) {
        stack1.offerFirst(value);
    }
    @Override
    public Integer poll() {
        if (stack2.isEmpty() && stack1.isEmpty()) {
            return null;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.offerFirst(stack1.pollFirst());
            }
        }
        return stack2.pollFirst();
    }
    @Override
    public int size() {
        return stack1.size() + stack2.size();
    }
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
