public class MyListNodeDeque implements MyDeque{
    private DoublyListNode head;
    private DoublyListNode tail;
    private int size;

    public MyListNodeDeque() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean offerFirst(int val) {
        DoublyListNode node = new DoublyListNode(val);
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return true;
        }
        node.next = head;
        head.prev = node;
        head = node;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(int val) {
        DoublyListNode node = new DoublyListNode(val);
        if (tail == null) {
            head = node;
            tail = node;
            size++;
            return true;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
        return true;
    }

    @Override
    public Integer pollFirst() {
        if (head == null) {
            tail = null;
            return null;
        }
        Integer val = head.val;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    @Override
    public Integer pollLast() {
        if (tail == null) {
            head = null;
            return null;
        }
        Integer val = tail.val;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    @Override
    public Integer peekFirst() {
        return head == null ? null : head.val;
    }

    @Override
    public Integer peekLast() {
        return tail == null ? null : tail.val;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
