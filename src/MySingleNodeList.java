public class MySingleNodeList {
    private ListNode head;
    private ListNode tail;
    private int size;

    public MySingleNodeList() {
        head = null;
        tail = null;
        size = 0;
    }

    public ListNode insert(int val) {
        //O(1) insert at tail
        ListNode node = new ListNode(val);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
        return head;
    }
    public ListNode insert(int val, int index) {
        //O(n) insert at index;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("index: %d is out of bound", index));
        } else if (index == size) {
            return insert(val);
        }
        ListNode node = new ListNode(val);
        if (index == 0) {
            node.next = head;
            head = node;
        } else {
            ListNode prev = findNode(index - 1);
            ListNode next = prev.next;
            prev.next = node;
            node.next = next;
        }
        size++;
        return head;
    }

    public int get(int index) {
        //O(n) get
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("index: %d is out of bound", index));
        }
        if (index == size - 1) {
            return tail.val;
        }
        return findNode(index).val;
    }

    public ListNode delete() {
        //O(n) delete the last element
        if (head == null || head == tail) {
            head = null;
            tail = null;
            size = 0;
            return null;
        }
        ListNode cur = head;
        while (cur.next != tail) {
            cur = cur.next;
        }
        cur.next = null;
        tail = cur;
        size--;
        return head;
    }

    public ListNode delete(int index) {
        //O(n) delete index element
        if (head == null) {
            return null;
        }
        if (index == 0) {
            size--;
            if (tail == head) {
                tail = null;
            }
            return head.next;
        } else if (index == size - 1) {
            return delete();
        } else if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("index: %d is out of bound", index));
        }
        ListNode cur = findNode(index - 1);
        cur.next = cur.next.next;
        size--;
        return head;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private ListNode findNode(int index) {
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }
}
