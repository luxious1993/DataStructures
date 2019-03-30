public class MyQueueTest {
    public static void main(String[] args) {
        MyQueueTest myQueueTest = new MyQueueTest();
        myQueueTest.test();
    }
    private void test() {
        MyQueue queue = new MyQueueByTwoStack();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        System.out.println(queue.poll());
        queue.offer(3);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
