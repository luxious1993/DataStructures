public interface MyDeque {
    boolean offerFirst(int val);
    boolean offerLast(int val);
    Integer pollFirst();
    Integer pollLast();
    Integer peekFirst();
    Integer peekLast();
    int size();
    boolean isEmpty();
}
