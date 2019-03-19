import java.util.LinkedList;

public class TripleStackSort {
    public static LinkedList<Integer> tripleStackSort(LinkedList<Integer> stack1) {
        LinkedList<Integer> stack2 = new LinkedList<>();
        LinkedList<Integer> stack3 = new LinkedList<>();
        while (!stack1.isEmpty()) {
            int globalMin = stack1.peekFirst();
            while (!stack1.isEmpty()) {
                int num = stack1.pollFirst();
                stack2.offerFirst(num);
                if (num < globalMin) {
                    globalMin = num;
                }
            }
            stack3.offerFirst(globalMin);
            while (!stack2.isEmpty()) {
                int num = stack2.pollFirst();
                if (num != globalMin) {
                    stack1.offerFirst(num);
                }
            }
        }
        return stack3;
    }
    public static void main(String[] args) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        stack1.offerFirst(2);
        stack1.offerFirst(1);
        stack1.offerFirst(3);
        stack1.offerFirst(4);
        LinkedList<Integer> res = tripleStackSort(stack1);
        while (!res.isEmpty()) {
            System.out.println(res.pollFirst());
        }
    }
}
