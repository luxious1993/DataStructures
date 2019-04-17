public interface MyQueue {
    boolean offer(int value);
    Integer poll();
    int size();
    boolean isEmpty();
}
