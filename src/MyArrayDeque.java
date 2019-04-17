public class MyArrayDeque implements MyDeque {

    private static final int DEFAULT_CAPACITY = 20;
    private static final int DEFAULT_LOAD_FACTOR = 2;

    private int head;
    private int tail;
    private Integer[] array;
    private int size;

    public MyArrayDeque() {
        head = 0;
        tail = 0;
        array = new Integer[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean offerFirst(int val) {
        if (size == 0) {
            array[head] = val;
            size++;
            return true;
        } else if (size == array.length) {
            final int newCapacity = array.length * DEFAULT_LOAD_FACTOR;
            Integer[] newArray = new Integer[newCapacity];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[head];
                head = (head + 1) % array.length;
            }
            head = 0;
            tail = array.length - 1;
            array = newArray;
        }
        head = (array.length + head - 1) % array.length;
        size++;
        array[head] = val;
        return true;
    }

    @Override
    public boolean offerLast(int val) {
        if (size == 0) {
            array[tail] = val;
            size++;
            return true;
        } else if (size == array.length) {
            final int newCapacity = array.length * DEFAULT_LOAD_FACTOR;
            Integer[] newArray = new Integer[newCapacity];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[head];
                head = (head + 1) % array.length;
            }
            head = 0;
            tail = array.length - 1;
            array = newArray;
        }
        tail = (tail + 1) % array.length;
        size++;
        array[tail] = val;
        return true;
    }

    @Override
    public Integer pollFirst() {
        if (size == 0) {
            return null;
        }
        Integer val = array[head];
        head = (head + 1) % array.length;
        size--;
        return val;
    }

    @Override
    public Integer pollLast() {
        if (size == 0) {
            return null;
        }
        Integer val = array[tail];
        tail = (array.length + tail - 1) % array.length;
        size--;
        return val;
    }

    @Override
    public Integer peekFirst() {
        return size == 0? null : array[head];
    }

    @Override
    public Integer peekLast() {
        return size == 0? null : array[tail];
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
