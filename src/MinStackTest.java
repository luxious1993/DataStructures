public class MinStackTest {
    public static void main(String[] args) {
        MinStackTest test = new MinStackTest();
        test.run();
    }
    private void run() {
        MinStack stack = new MinStack();
        stack.offer(3);
        stack.offer(2);
        stack.offer(4);
        System.out.println(stack.min());
        System.out.println(stack.poll());
        System.out.println();
        stack.offer(3);
        stack.offer(1);
        stack.offer(3);
        stack.offer(2);
        while (!stack.isEmpty()) {
            System.out.println("min is " + stack.min());
            System.out.println("poll " + stack.poll());
        }
    }
}
