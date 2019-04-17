public class MyArrayStack implements MyStack {

    private static final int DEFAULT_CAPACITY = 20;
    private static final double DEFAULT_LOAD_FACTOR = 2;

    private final boolean scalable;

    private int pointer;
    private int size;
    int[] array;

    public MyArrayStack() {
        scalable = true;
        pointer = -1;
        size = 0;
        array = new int[DEFAULT_CAPACITY];
    }

    public MyArrayStack(int capacity) {
        scalable = false;
        pointer = -1;
        size = 0;
        array = new int[capacity];
    }

    public MyArrayStack(int capacity, boolean scalable) {
        this.scalable = scalable;
        pointer = -1;
        size = 0;
        array = new int[capacity];
    }

    @Override
    public boolean push(int val) {
        if (!scalable && pointer == array.length - 1) {
            return false;
        } else if (pointer == array.length - 1) {
            final int length = (int) (array.length * DEFAULT_LOAD_FACTOR);
            int[] newArray = new int[length];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        size++;
        array[++pointer] = val;
        return true;
    }

    @Override
    public Integer pop() {
        if (pointer == -1) {
            return null;
        }
        size--;
        return array[pointer--];
    }

    @Override
    public Integer peek() {
        if (pointer == -1) {
            return null;
        }
        return array[pointer];
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
