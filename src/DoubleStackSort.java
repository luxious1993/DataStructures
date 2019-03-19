import java.util.LinkedList;

public class DoubleStackSort {
    //assume no duplicate num
    public static LinkedList<Integer> doubleStackSort(LinkedList<Integer> stack1) {
        LinkedList<Integer> stack2 = new LinkedList<>();
        while (!stack1.isEmpty()) {
            int globalMin = stack1.peekFirst();
            while (!stack1.isEmpty()) {
                int num = stack1.pollFirst();
                if (num < globalMin) {
                    globalMin = num;
                }
                stack2.offerFirst(num);
            }
            while (!stack2.isEmpty() && stack2.peekFirst() >= globalMin) {
                int num = stack2.pollFirst();
                if (num > globalMin) {
                    stack1.offerFirst(num);
                }
            }
            stack2.offerFirst(globalMin);
        }
        return stack2;
    }
    public static void main(String[] args) {
        LinkedList<Integer> stack1 = new LinkedList<>();
        stack1.offerFirst(2);
        stack1.offerFirst(1);
        stack1.offerFirst(3);
        stack1.offerFirst(4);
        LinkedList<Integer> res = doubleStackSort(stack1);
        while (!res.isEmpty()) {
            System.out.println(res.pollFirst());
        }
    }
}
