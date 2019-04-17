public class Main {
    public static void main(String[] args) {
//        testMySingleNodeList();
        testMyQueue();
//        testMyStack();
//        testMyDeque();
    }

    private static void testMySingleNodeList() {
        MySingleNodeList mySingleNodeList = new MySingleNodeList();
        mySingleNodeList.insert(1);
        mySingleNodeList.insert(2);
        mySingleNodeList.insert(4);
        for (int i = 0; i < mySingleNodeList.size(); i++) {
            System.out.print(mySingleNodeList.get(i) + " , ");
        }
        System.out.println();
        mySingleNodeList.insert(3, 2);
        for (int i = 0; i < mySingleNodeList.size(); i++) {
            System.out.print(mySingleNodeList.get(i) + " , ");
        }
        System.out.println();
        mySingleNodeList.insert(0, 0);
        for (int i = 0; i < mySingleNodeList.size(); i++) {
            System.out.print(mySingleNodeList.get(i) + " , ");
        }
        System.out.println();
        mySingleNodeList.delete();
        for (int i = 0; i < mySingleNodeList.size(); i++) {
            System.out.print(mySingleNodeList.get(i) + " , ");
        }
        System.out.println();
        mySingleNodeList.delete(0);
        for (int i = 0; i < mySingleNodeList.size(); i++) {
            System.out.print(mySingleNodeList.get(i) + " , ");
        }
        System.out.println();
    }
    private static void testMyQueue() {

        MyQueue queue1 = new MyArrayQueue(1);
        System.out.println(queue1.offer(1));
        System.out.println(queue1.offer(2));

        MyQueue queue = new MyArrayQueue();
        for (int i = 0; i < 22; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " , ");
        }
    }

    private static void testMyStack() {
        MyStack stack = new MyListNodeStack();

        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.size());
        System.out.println(stack.peek());
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        MyStack stack1 = new MyListNodeStack(1);
        System.out.println(stack1.push(1));
        System.out.println(stack1.push(2));
    }

    private static void testMyDeque() {
        MyDeque deque = new MyArrayDeque();

        for (int i = 0; i < 22; i++) {
            deque.offerLast(i);
        }
        while (!deque.isEmpty()) {
            System.out.print(deque.pollFirst() + " , ");
        }
    }
}
