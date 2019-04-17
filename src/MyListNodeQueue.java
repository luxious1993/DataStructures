public class MyListNodeQueue implements MyQueue{
    //cannot offer any element if you declare the capacity of your queue
    private final int capacity;

    private ListNode head;
    private ListNode tail;
    private int size;

    public MyListNodeQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.capacity = Integer.MAX_VALUE;
    }

    public MyListNodeQueue(int capacity) {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.capacity = capacity;
    }
    @Override
    public boolean offer(int value) {
        if (this.size() >= capacity) {
            return false;
        }
        final ListNode node = new ListNode(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    @Override
    public Integer poll() {
        if (head == null) {
            return null;
        }
        final int val = head.val;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return val;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
}
