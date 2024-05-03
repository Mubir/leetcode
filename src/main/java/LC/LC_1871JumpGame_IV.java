package LC;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC_1871JumpGame_IV {

    public static boolean jumpGameFour(String str, int minJump, int maxJump) {
        int sz = str.length() - 1;

        Deque<Integer> dq = new ArrayDeque();
        int current = 0;
        dq.add(0);
        while (current <= sz) {
            while (!dq.isEmpty() && dq.peek() < (current - maxJump)) {
                dq.pop();
            }
            if (str.charAt(current) == '0'
                    && !dq.isEmpty()
                    && dq.peek() <= (current - minJump)) {
                dq.add(current);
            }
            current++;
        }

        return !dq.isEmpty() && dq.peekLast() == sz;
    }

    public static void main(String[] args) {
        System.out.println(jumpGameFour("011010", 2, 3));
        System.out.println(jumpGameFour("01101110", 2, 3));
    }
}
