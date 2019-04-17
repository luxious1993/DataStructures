public class MyArrayQueue implements MyQueue{
    private static final int DEFAULT_CAPACITY = 20;
    private static final double DEFAULT_LOAD_FACTOR = 2;

    private final boolean scalable;

    private Integer[] array;
    // array[head] is not used here and cricularArray is full when tail == head;
    private int head;
    private int tail;
    private int size;

    public MyArrayQueue() {
        this.scalable = true;
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.array = new Integer[DEFAULT_CAPACITY];
    }

    public MyArrayQueue(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("The capacity of MyQueue should be larger than 0");
        }
        this.scalable = false;
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.array = new Integer[capacity];
    }

    public MyArrayQueue(int capacity, boolean scalable) {
        if (capacity < 0) {
            throw new IllegalArgumentException("The capacity of MyQueue should be larger than 0");
        }
        this.scalable = scalable;
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.array = new Integer[capacity];
    }

    @Override
    public boolean offer(int value) {
        if (!scalable && size == array.length) {
            return false;
        } else if (size == array.length) {
            final int length = (int) (array.length * DEFAULT_LOAD_FACTOR);
            Integer[] newArray = new Integer[length];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[head];
                head = (head + 1) % array.length;
            }
            head = 0;
            tail = array.length;
            array = newArray;
        }
        array[tail] = value;
        size++;
        tail = (tail + 1) % array.length;
        return true;
    }

    @Override
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        Integer val = array[head];
        head = (head + 1) % array.length;
        size--;
        return val;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[head];
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
