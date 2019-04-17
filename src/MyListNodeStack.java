public class MyListNodeStack implements MyStack{
    //cannot push any element if you declare the capacity of your stack;
    private final int capacity;

    private ListNode head;
    private int size;

    public MyListNodeStack() {
        this.head = null;
        this.size = 0;
        this.capacity = Integer.MAX_VALUE;
    }

    public MyListNodeStack(int cap) {
        this.head = null;
        this.size = 0;
        this.capacity = cap;
    }

    @Override
    public boolean push(int val) {
        if (this.size() >= this.capacity) {
            return false;
        }
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
        size++;
        return true;
    }

    @Override
    public Integer pop() {
        if (head == null) {
            return null;
        }
        int val = head.val;
        head = head.next;
        size--;
        return val;
    }

    @Override
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
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
