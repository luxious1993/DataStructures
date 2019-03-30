public interface MyQueue {
    void offer(int value);
    Integer poll();
    int size();
    boolean isEmpty();
}
