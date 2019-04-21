import java.util.Arrays;
import java.util.Comparator;

public class MyPriorityQueue<E> {
    private static final int DEFAULT_CAPACITY = 15;
    private static final int DEFAULT_LOAD_FACTOR = 2;

    private Object[] array;
    private final Comparator<? super E> comparator;
    private int size = 0;

    public MyPriorityQueue() {
        this(DEFAULT_CAPACITY, null);
    }

    public MyPriorityQueue(E[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("input object array is Illeagal");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new NullPointerException("input array include null");
            }
        }
        this.array = array;
        this.size = array.length;
        this.comparator = null;
        heapify();
    }

    public MyPriorityQueue(final int capacity) {
        this(capacity, null);
    }

    public MyPriorityQueue(final Comparator<? super E> comparator) {
        this(DEFAULT_CAPACITY, comparator);
    }

    public MyPriorityQueue(final int capacity,
                           final Comparator<? super E> comparator) {
        if (capacity < 1) {
            throw new IllegalArgumentException("The size of MyPriorityQueue shoule be larger than 0");
        }
        this.array = new Object[capacity];
        this.comparator = comparator;
    }

    public void offer(E e) {
        if (e == null) {
            throw new NullPointerException("cannot offer null");
        }
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * DEFAULT_LOAD_FACTOR);
        }
        int i = size;
        array[i] = e;
        percolateUp(i);
        size++;
    }

    public E poll() {
        if (size == 0) {
            return null;
        }
        final E e = (E) array[0];
        array[0] = array[size - 1];
        array[size - 1] = null;
        size--;
        percolateDown(0);
        return e;
    }

    public E peek() {
        if (size == 0) {
            return null;
        }
        return (E) array[0];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void heapify() {
        if (size == 1) {
            return;
        }
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    private void percolateDown(int i) {
        if (comparator != null) {
            percolateDownComparator(i);
        } else {
            percolateDownComparable(i);
        }
    }

    private void percolateDownComparator(int i) {
        while (i <= size / 2 - 1) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;
            int candidateSwapIndex = leftChildIndex;
            if (rightChildIndex < size &&
                    comparator.compare((E) array[leftChildIndex], (E) array[rightChildIndex]) > 0) {
                candidateSwapIndex = rightChildIndex;
            }
            if (comparator.compare((E) array[i], (E) array[candidateSwapIndex]) > 0) {
                swap(i, candidateSwapIndex);
            } else {
                break;
            }
            i = candidateSwapIndex;
        }
    }

    private void percolateDownComparable(int i) {
        final Comparable<? super E> key = (Comparable<? super E>) array[i];
        while (i <= size / 2 - 1) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;
            int candidateSwapIndex = leftChildIndex;
            if (rightChildIndex < size &&
                    ((Comparable<? super E>) array[leftChildIndex]).compareTo((E) array[rightChildIndex]) > 0) {
                candidateSwapIndex = rightChildIndex;
            }
            if (((Comparable<? super E>) array[i]).compareTo((E) array[candidateSwapIndex]) > 0) {
                swap(i, candidateSwapIndex);
            } else {
                break;
            }
            i = candidateSwapIndex;
        }
    }

    private void percolateUp(int i) {
        if (comparator != null) {
            percolateUpComparator(i);
        } else {
            percolateUpComparable(i);
        }
    }

    private void percolateUpComparator(int i) {
        while (i > 0) {
            int parentIndex = (i - 1) / 2;
            if (comparator.compare((E) array[i], (E) array[parentIndex]) < 0) {
                swap(i, parentIndex);
            } else {
                break;
            }
            i = parentIndex;
        }
    }

    private void percolateUpComparable(int i) {
        while (i > 0) {
            int parentIndex = (i - 1) / 2;
            if (((Comparable<? super E>) array[i]).compareTo((E) array[parentIndex]) < 0) {
                swap(i, parentIndex);
            } else {
                break;
            }
            i = parentIndex;
        }
    }

    private void swap(int i, int j) {
        E temp = (E) array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
